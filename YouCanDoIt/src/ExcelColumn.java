public class ExcelColumn {

	public static void main(String[] args) {
		String x = convert26(676);
		System.out.println(x);
	}

	static String convert26(long no) {
		String ans = "";
		System.out.println(no);
		while (no != 0) {
			ans += (no % 26);
			no = no / 26;
		}
		return new StringBuilder(ans).reverse().toString();
	}

}
/*
 * 1: A 10:J 26:Z 27:AA 52:AZ 53: BA 626:ZZ 677: AAA
 */