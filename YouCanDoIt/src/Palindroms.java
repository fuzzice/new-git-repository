public class Palindroms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "Paap";
		System.out.println(isPalindrome(s));
	}

	public static boolean isPalindrome(String s) {
		StringBuffer sb = new StringBuffer(s);
		for (int i = 0; i < sb.length(); i++)
			if (Character.toUpperCase(sb.charAt(i)) < 'A'
					|| Character.toUpperCase(sb.charAt(i)) > 'Z')
				sb.deleteCharAt(i);

		for (int i = 0; i < sb.length() / 2; i++) {
			if (Character.toUpperCase(sb.charAt(i)) != Character.toUpperCase(sb
					.charAt(sb.length() - i - 1)))
				return false;

		}
		return true;
	}

}
