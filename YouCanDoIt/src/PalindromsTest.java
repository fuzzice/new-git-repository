import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class PalindromsTest {

	@Test
	public void test() {
		ArrayList<String> ar = new ArrayList<String>();
		ar.add("Paap");
		ar.add("MADAM I'M ADAM");
		ar.add("Eye");
		for (String s : ar) {
			assertEquals(true, Palindroms.isPalindrome(s));
		}
	}

}
