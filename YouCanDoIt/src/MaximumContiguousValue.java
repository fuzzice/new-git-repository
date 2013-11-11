import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumContiguousValue {

	public static void main(String[] args) {
		List<Integer> ar = new ArrayList<Integer>();
		Integer a[] = { 2, 4, 5, -3, -4, -2, 3, -9, 3, 6, 8, -1, 5 };
		int b[] = { 1, 2, 3 };
		ar = Arrays.asList(a);

		int max = 0;
		int maxsofar = 0;

		for (int x : ar) {
			maxsofar = maxsofar + x;
			if (maxsofar < 0)
				maxsofar = 0;
			else if (maxsofar > max)
				max = maxsofar;
		}
		System.out.println(max);
	}
}
