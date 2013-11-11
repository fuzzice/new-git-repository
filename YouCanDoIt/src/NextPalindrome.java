public class NextPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1;
		for (int i = 0; i < 100; i++) {
			n = nextPalindrome(n);
			System.out.println(n);
			n++;
		}
	}

	static int nextPalindrome(int n) {

		String s = Integer.toString(n);
		// 12456 even 123: 2
		// 12345
		// 12321

		int mid = (s.length() + 1) / 2;

		StringBuffer sb = new StringBuffer();
		String str = s.substring(0, mid);
		// System.out.print(str + "\n");

		if (s.length() % 2 == 0) {
			// even length 123=>123321
			sb.append(str);
			sb.append(new StringBuffer(str).reverse());
		} else {
			// sb.append(sb.reverse().substring(1, sb.length()));
			// odd length 123=>12321
			sb.append(str);
			sb.append(new StringBuffer(str).reverse()
					.substring(1, str.length()));

		}

		int newno = Integer.parseInt(sb.toString());
		// System.out.println(n + " : " + newno);
		// if (newno == n)
		// newno = nextPalindrome(newno + 1);
		if (newno >= n) {
			// System.out.println("We are done here. The next pal no is " +
			// newno);
			return newno;
		} else {
			// newno is smaller. Round up newno
			newno = newno + 10;
			newno = newno / 10;
			newno = newno * 10;
			newno = nextPalindrome(newno);

		}
		return newno;

	}
}
