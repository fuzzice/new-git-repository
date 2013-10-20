import java.util.ArrayList;

public class MaximumContiguousValue {

	public static void main(String[] args) {
		ArrayList<Integer> ar = new ArrayList<Integer>();
		ar.add(-2);
		ar.add(4);
		ar.add(-1);
		ar.add(4);
		ar.add(-3);
		ar.add(7);

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
