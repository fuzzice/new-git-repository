import java.util.HashSet;
import java.util.Set;

public class AllPossiblePermutations {

	public static void main(String args[]) {
		permutation("abcd");

		Set<Character> h = new HashSet<Character>();

	}

	public static void permutation(String str) {
		permutation("", str);
	}

	private static void permutation(String prefix, String str) {
		int n = str.length();
		if (n == 0)
			System.out.println(prefix);
		else {
			for (int i = 0; i < n; i++)
				permutation(prefix + str.charAt(i),
						str.substring(0, i) + str.substring(i + 1, n));
		}
	}
}
