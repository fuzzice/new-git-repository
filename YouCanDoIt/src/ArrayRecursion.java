public class ArrayRecursion {

	static int max(int a[], int i, int max) {
		if (i == a.length)
			return max;
		max = Math.max(a[i], max);
		return max(a, i + 1, max);
	}

	static String reverse(String s) {
		if (1 == s.length())
			return s;
		return s.charAt(s.length() - 1)
				+ reverse(s.substring(0, s.length() - 1));
	}

	public static void main(String[] args) {
		int a[] = { 2, 5, 4, 6, 9, 11, 4, 5, 88 };
		System.out.println("Max: " + max(a, 0, Integer.MIN_VALUE));
		System.out.println(reverse("sahil is a good boy"));
	}

}
