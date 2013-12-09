import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class NumberToWord {
	public static String numToWord(long x) throws Exception {
		if (x < 100) {

			int t = (int) x;
			switch (t) {
			case 0:
				return "";
			case 1:
				return "One";
			case 2:
				return "Two";
			case 3:
				return "Three";
			case 4:
				return "Four";
			case 5:
				return "Five";
			case 6:
				return "Six";
			case 7:
				return "Seven";
			case 8:
				return "Eight";
			case 9:
				return "Nine";
			case 10:
				return "Ten";
			case 11:
				return "Eleven";
			case 12:
				return "Twelve";
			case 13:
				return "Thirteen";
			case 14:
				return "Fourteen";
			case 15:
				return "Fifteen";
			case 16:
				return "Sixteen";
			case 17:
				return "Seventeen";
			case 18:
				return "Eighteen";
			case 19:
				return "Nineteen";
			case 20:
				return "Twenty ";
			case 30:
				return "Thirty ";
			case 40:
				return "Forty ";
			case 50:
				return "Fifty ";
			case 60:
				return "Sixty ";
			case 70:
				return "Seventy ";
			case 80:
				return "Eighty ";
			case 90:
				return "Ninety ";
			default:
				return numToWord(x - (x % 10)) + numToWord(x % 10);
			}// end switch

		}// x<100
		else if (x < 1000) {
			return numToWord(x / 100) + " Hundred " + numToWord(x % 100);
		} else if (x < 1000000) {
			return numToWord(x / 1000) + " Thousand " + numToWord(x % 1000);
		} else if (x < 1000000000l) {
			return numToWord(x / 1000000) + " Million "
					+ numToWord(x % 1000000);
		} else if (x < 1000000000000l) {
			return numToWord(x / 1000000000) + " Billion "
					+ numToWord(x % 1000000000);
		} else {
			throw new Exception(
					"Something seems to be wrong with the input. We support only billions for now");
		}

	}

	public static void main(String[] args) throws Exception {
		long x = 91;
		for (int i = 0; i < 1000; i++) {
			System.out.println(i + ": " + numToWord(i));
		}
		System.out.println("Num to Words: " + numToWord(x));
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

}
