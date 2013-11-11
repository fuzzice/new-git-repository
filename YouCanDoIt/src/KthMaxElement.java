import java.util.ArrayList;
import java.util.List;

public class KthMaxElement {

	public static int findKthMax(List<Integer> input, int k) {
		if (input != null && input.size() > 0) {
			int element = input.get(0);
			List largerThanElement = new ArrayList();
			List smallerThanElement = new ArrayList();

			for (int i = 1; i < input.size(); i++) {
				if (element < input.get(i)) {
					largerThanElement.add(input.get(i));
				} else {
					smallerThanElement.add(input.get(i));
				}
			}

			if (largerThanElement.size() == k - 1) {
				return element;
			} else if (largerThanElement.size() < k - 1) {
				return findKthMax(smallerThanElement,
						k - largerThanElement.size() - 1);
			} else if (largerThanElement.size() >= k) {
				return findKthMax(largerThanElement, k);
			}
			return element; // To satisfy the crazy compiler
		} else {
			throw new IllegalArgumentException();
		}
	}

	public static void main(String[] args) {

		List<Integer> l = new ArrayList<Integer>();
		l.add(3);
		l.add(4);
		l.add(2);
		l.add(9);
		l.add(7);
		for (int i = 1; i <= 5; i++)
			System.out.println(findKthMax(l, i));
		;
	}
}
