package com.sendhub;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import com.sendhub.beans.ConnectionRequestInput;
import com.sendhub.beans.ConnectionResponseOutput;
import com.sendhub.beans.Resource;
import com.sendhub.beans.Route;
import com.sendhub.exceptions.InvalidPhoneNumberException;
import com.sendhub.exceptions.PhoneNumbersExceededExpectedCapacity;

@Path("/hello")
public class RoutingHelper {
	private final static int EXPECTEDPHONENUMBERSSIZE = 5000;
	private final static int MAXHOSTS = 254;
	static Map<String, Resource> resources;
	static {

		// available resources
		resources = new LinkedHashMap<String, Resource>();
		Resource res = new Resource();
		res.setCapacity("super");
		res.setCostPerRequest(0.25);
		res.setRelaySubnet("10.0.4.");
		res.setMaxHosts(254);
		res.setThroughput(25);
		resources.put("super", res);

		res = new Resource();
		res.setCapacity("large");
		res.setCostPerRequest(0.10);
		res.setRelaySubnet("10.0.3.");
		res.setMaxHosts(254);
		res.setThroughput(10);
		resources.put("large", res);

		res = new Resource();
		res.setCapacity("medium");
		res.setCostPerRequest(0.05);
		res.setRelaySubnet("10.0.2.");
		res.setMaxHosts(254);
		res.setThroughput(5);
		resources.put("medium", res);

		res = new Resource();
		res.setCapacity("small");
		res.setCostPerRequest(0.01);
		res.setRelaySubnet("10.0.1.");
		res.setMaxHosts(254);
		res.setThroughput(1);
		resources.put("small", res);

	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnTitle() {
		return "<p>Java Web Service</p>";
	}

	@POST
	@Produces(MediaType.TEXT_HTML)
	public String returnTitlePost() {
		return "<p>Java Web Service for Post</p>";
	}

	@Path("/route")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getRouting(@QueryParam("input") String input)
			throws Exception {

		ConnectionRequestInput cri = null;
		// parse the input as json
		try {
			cri = parseInput(input);
		} catch (JsonParseException e1) {
			// log exception in production code

			System.out.println(e1.toString());
			throw e1;

		} catch (JsonMappingException e2) {
			System.out.println(e2.toString());
			throw e2;

		} catch (IOException e3) {
			System.out.println(e3.toString());
			throw e3;
		}

		// validate the parsed json
		try {
			validateInput(cri);
		} catch (InvalidPhoneNumberException e) {
			System.out.println(e.toString());
			throw e;
		} catch (PhoneNumbersExceededExpectedCapacity e2) {
			System.out.println(e2.toString());
			throw e2;
		}
		String jsonOutput = getOutput(cri);
		return "Input: " + input + " \n Output: " + jsonOutput;
	}

	private String getOutput(ConnectionRequestInput cri) throws Exception {
		ConnectionResponseOutput cro = new ConnectionResponseOutput();
		// since this is like making change for US currency, we can go with
		// greedy as its optimal and polynomial as compared to the memoization
		// dp approach

		int size = cri.getRecipients().size();
		cro.setMessage(cri.getMessage());
		String json = null;
		int end = size - 1;
		for (String s : resources.keySet()) {
			int throughput = resources.get(s).getThroughput();
			int divisor = size / throughput;
			int remainder = size % throughput;
			if (divisor > MAXHOSTS) {
				size = size - throughput * MAXHOSTS;
				divisor = MAXHOSTS;

			} else
				size = remainder;

			for (int i = 0; i < divisor; i++) {
				Route r = new Route();
				r.setIp(resources.get(s).getRelaySubnet() + (i + 1));
				List<String> nos = getChunks(cri.getRecipients(), end,
						throughput);
				end -= throughput;
				r.setRecipients(nos);
				if (cro.getRoutes() == null)
					cro.setRoutes(new ArrayList<Route>());
				cro.getRoutes().add(r);
			}

			ObjectWriter ow = new ObjectMapper().writer()
					.withDefaultPrettyPrinter();
			try {
				json = ow.writeValueAsString(cro);
			} catch (JsonGenerationException e) {
				// catch log and rethrow
				e.printStackTrace();
				throw e;
			} catch (JsonMappingException e) {
				e.printStackTrace();
				throw e;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if (size != 0) {
			String message = "No of recipients more than available hosts can support";
			throw new PhoneNumbersExceededExpectedCapacity(message);
		}
		return json;

	}

	// get Chunks is a helper method to retrieve chunks of phone numbers for a
	// host for the output
	private List<String> getChunks(List<String> recipients, int end,
			int throughput) {
		String[] chunk = new String[throughput];
		for (int i = 0; i < throughput; i++)
			chunk[i] = recipients.get(end - i);
		return Arrays.asList(chunk);
	}

	private void validateInput(ConnectionRequestInput cri)
			throws InvalidPhoneNumberException,
			PhoneNumbersExceededExpectedCapacity {

		if (cri.getRecipients().size() > EXPECTEDPHONENUMBERSSIZE) {
			String message = "Sorry, the max no of phone numbers currently suported is "
					+ EXPECTEDPHONENUMBERSSIZE;
			throw new PhoneNumbersExceededExpectedCapacity(message);
		}
		// for all nos check it its a valid no
		// for this example, we are only going to allow numbers in format:
		// +1XXXXXXXXXX
		for (String phoneNo : cri.getRecipients()) {

			String s = phoneNo.substring(2);
			String regex = "[2-9][0-8][0-9][2-9][0-9][0-9][0-9][0-9][0-9][0-9]";
			boolean regexPass = s.matches(regex);
			if (regexPass == false) {
				String message = "One of the Phone numbers " + s
						+ " does not seem to be a valid phone number";
				throw new InvalidPhoneNumberException(message);
			}
			// (http://en.wikipedia.org/wiki/North_American_Numbering_Plan)
			if (s.charAt(1) == s.charAt(2)) {
				// ERC's
				String message = "One of the Phone numbers "
						+ s
						+ " does not seem to be a valid phone number as second and third digits are the same.";
				// log exception in production code

				throw new InvalidPhoneNumberException(message);
			}

			if (s.charAt(4) == '1' && s.charAt(5) == '1') {
				String message = "One of the Phone numbers "
						+ s
						+ " does not seem to be a valid phone number as fifth and sixth digs are 1s.";
				// log exception in production code
				throw new InvalidPhoneNumberException(message);
			}
		}
	}

	private ConnectionRequestInput parseInput(String input)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper ob = new ObjectMapper();
		ob.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES,
				false);
		ConnectionRequestInput cri = ob.readValue(input,
				ConnectionRequestInput.class);
		System.out.println(cri.getRecipients().size());

		for (String s : resources.keySet()) {
			Resource r = resources.get(s);
			System.out.println(r.toString());
		}
		return cri;
	}
}
