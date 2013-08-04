import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class NumberToWordTest {
	static ArrayList<Long> test;
	static ArrayList<String> results;

	@Before
	public void testSetup() {
		test = new ArrayList<Long>();
		test.add(1l);
		test.add(10l);
		test.add(19l);
		test.add(20l);
		test.add(30l);
		test.add(100l);
		test.add(199l);
		test.add(999l);
		test.add(1999l);
		test.add(10003344l);

		results = new ArrayList<String>();
		results.add("One");
		results.add("Ten");
		results.add("Nineteen");
		results.add("Twenty");
		results.add("Thirty");
		results.add("One Hundred");
		results.add("One Hundred Ninety Nine");
		results.add("Nine Hundred Ninety Nine");
		results.add("One Thousand Nine Hundred Ninety Nine");
		results.add("Ten Million Three Thousand Three Hundred Forty Four");
		// One Thousand Nine Hundred Ninety Nine

	}

	@Test
	public void testNumToWord() throws Exception {
		System.out.println("Starting now");
		for (int i = 0; i < results.size(); i++) {
			System.out.println("Testing " + test.get(i));
			assertEquals(results.get(i), NumberToWord.numToWord(test.get(i))
					.trim());
		}

	}

}
