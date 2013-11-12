public class Permute {
	static void permute(java.util.List<Integer> arr, int k) {
		for (int i = k; i < arr.size(); i++) {
			java.util.Collections.swap(arr, i, k);
			permute(arr, k + 1);
			java.util.Collections.swap(arr, i, k);
		}
		System.out.println("k=" + k);
		if (k == arr.size() - 1) {
			// System.out.println(java.util.Arrays.toString(arr.toArray()));
			System.out.println(arr.toString());
		}
	}

	static void permute(StringBuffer sb, int k) {
		for (int i = k; i < sb.length(); i++) {
			{
				char t = sb.charAt(i);
				sb.setCharAt(i, sb.charAt(k));
				sb.setCharAt(k, t);
			}
			// java.util.Collections.swap(arr, i, k);
			permute(sb, k + 1);
			{

				char t = sb.charAt(i);
				sb.setCharAt(i, sb.charAt(k));
				sb.setCharAt(k, t);
			}
			// java.util.Collections.swap(arr, k, i);
		}
		if (k == (sb.length() - 1)) {
			// System.out.println(java.util.Arrays.toString(arr.toArray()));
			System.out.println(sb.toString());
		}
	}

	public static void main(String[] args) {
		Permute.permute(java.util.Arrays.asList(1, 2, 3), 0);
		Permute.permute(new StringBuffer("abcd"), 0);
	}
}