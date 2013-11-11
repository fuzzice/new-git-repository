import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class IsoMorphicStringWord {
	/**
	 * Given two (dictionary) words as Strings, determine if they are
	 * isomorphic. Two words are called isomorphic if the letters in one word
	 * can be remapped to get the second word. Remapping a letter means
	 * replacing all occurrences of it with another letter while the ordering of
	 * the letters remains unchanged. No two letters may map to the same letter,
	 * but a letter may map to itself.
	 * 
	 * Example: given "foo", "app"; returns true we can map 'f' -> 'a' and 'o'
	 * -> 'p'
	 * 
	 * given "bar", "foo"; returns false we can't map both 'a' and 'r' to 'o'
	 * 
	 * given "turtle", "tletur"; returns true we can map 't' -> 't', 'u' -> 'l',
	 * 'r' -> 'e', 'l' -> 'u', 'e' ->'r'
	 * 
	 * given "ab", "ca"; returns true we can map 'a' -> 'c', 'b' -> 'a'
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isIsomorphic("foo", "app"));

		String s = "sahil is a good boy";
		StringTokenizer st = new StringTokenizer(s);
		while (st.hasMoreElements())
			System.out.print(st.nextToken());
		String s2 = "408-507-80444";
		String[] s3 = s2.split("*-*-*");
		System.out.println(s3[0] + s3[1] + s3[2]);

	}

	static boolean isIsomorphic(String s, String t) {
		if (s.length() != t.length())
			return false;
		Map<Character, Character> map = new LinkedHashMap<Character, Character>();
		boolean isIsoMorphic = true;
		for (int i = 0; i < s.length(); i++) {
			if (!map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), t.charAt(i));
			} else {
				if (map.get(s.charAt(i)) != t.charAt(i)) {
					isIsoMorphic = false;
					break;
				}
			}
		}

		return isIsoMorphic;
	}
}
