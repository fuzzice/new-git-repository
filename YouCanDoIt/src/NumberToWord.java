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
		long x = 1999l;
		System.out.println("Num to Words: " + numToWord(x));
	}

}
