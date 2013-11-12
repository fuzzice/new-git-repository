import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class CompressString {

	public static String compress(String s) {
		StringBuffer sb = new StringBuffer();
		char c = s.charAt(0);
		int ct = 1;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == c) {
				ct++;
			} else {
				sb.append(c);
				sb.append(ct);
				ct = 1;
				c = s.charAt(i);
			}
		}
		sb.append(c);
		sb.append(ct);
		return sb.toString();
	}

	static String compress2(String s) {
		Map<Character, Integer> mp = new TreeMap<Character, Integer>();
		// for (int i = 0; i < s.length(); i++) {
		// if (mp.containsKey(s.charAt(i) + "")) {
		// mp.put(s.charAt(i) + "", mp.get(s.charAt(i) + 1));
		// } else {
		// mp.put(s.charAt(i) + "", new Integer(0));
		// }
		// }
		for (int i = 0; i < s.length(); i++) {
			// String t = new Character(s.charAt(i)).toString();
			Character t = s.charAt(i);
			if (mp.containsKey(t)) {
				Integer t1 = mp.get(t);
				t1++;
				mp.put(t, t1);
			} else {
				Integer t1 = new Integer(1);
				mp.put(t, t1);
			}
		}
		StringBuffer sb = new StringBuffer();
		Set<Character> h = mp.keySet();
		for (Character c : h) {
			// System.out.print(c);
			sb.append(c);
			sb.append(mp.get(c));
		}
		return sb.toString();

	}

	public static void main(String[] args) {
		String uncompressed = "aaahhdddjjjkkssshhhdddfffaaa";
		char[] a = uncompressed.toCharArray();
		Arrays.sort(a);
		uncompressed = new String(a);

		System.out.println("Compressed string is " + compress(uncompressed));
		System.out.println("Compressed string is " + compress2(uncompressed));

		String s = "Sahil,is,a,good,boy";
		String[] s2 = s.split(",");
		System.out.println(s2[0] + s2[1] + s2[2]);

	}
}
