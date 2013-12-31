package com.sendhub.beans;

import java.util.List;

//Supplementary class for the ConnectionResponseOutput
public class Route {
	String ip;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public List<String> getRecipients() {
		return recipients;
	}

	public void setRecipients(List<String> recipients) {
		this.recipients = recipients;
	}

	@Override
	public String toString() {
		return "Route [ip=" + ip + ", recipients=" + recipients + "]";
	}

	List<String> recipients;
}
