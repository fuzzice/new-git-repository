import java.util.Arrays;

public class NegativeAndPositive {
	// http://www.careercup.com/question?id=5201559730257920
	// I dont think this program works

	private static final int[] array = new int[] { 100, -1, 5, 4, -7, 11, 12,
			0, -2, -1, -10, 11, -2 };

	public static void main(String[] args) {

		for (int i = 0, j = array.length - 1; i < j;) {

			if (array[i] < 0) {
				i++;
				continue;
			}

			if (array[j] > 0) {
				j--;
				continue;
			}

			swap(i, j);

		}

		System.out.println(Arrays.toString(array));

	}

	private static void swap(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void Main(String[] args) {
		int[] a = { -1, 1, 3, -2, 2 };
		int neg = 0;
		int pos = 0;

		for (int i = 0; i < a.length; i++) {
			if (a[i] <= 0)
				neg++;
			else
				pos++;
		}

		int countneg = 0;
		int i = 0;
		int j = 1;
		int k = 0;
		int temp = 0;
		while (countneg < neg) {
			if (a[i] <= 0) {
				countneg++;
				i++;
			} else {
				j = i;
				k = i;
				while (a[k] >= 0) {
					k++;
				}
				temp = a[j];
				a[j] = a[k];
				for (int z = k; z > j; z--) {
					a[z] = a[z - 1];
				}
				a[j + 1] = temp;
				countneg++;
				i++;
			}
		}

		for (i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
