import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CompressStringTest {

	@Test
	public void test() {
		String s = "dddffggddff";
		String e = "d5f4g2";
		assertEquals(CompressString.compress2(s), e);
	}
}
