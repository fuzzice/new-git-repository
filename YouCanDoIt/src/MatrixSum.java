public class MatrixSum {
	private static final int size = 10;

	int matrix[][] = new int[size][size];
	int sumMatrix[][] = new int[size][size];

	void populate() {
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++) {
				// matrix[i][j] = i + j + 10 + (int) (Math.random() * 3);
				matrix[i][j] = i + j;
				sumMatrix[i][j] = 0;

			}
		sumMatrix[0][0] = matrix[0][0];
	}

	void print() {
		System.out.println("MATRIX is\n");
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(matrix[i][j] + "  ");

			}
			System.out.println();
		}

		System.out.println("MATRIX sum is\n");
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(sumMatrix[i][j] + "  ");

			}
			System.out.println();
		}
	}

	void sumUp() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i > 0 && j > 0) {
					sumMatrix[i][j] = sumMatrix[i][j - 1] + sumMatrix[i - 1][j]
							- sumMatrix[i - 1][j - 1] + matrix[i][j];
				} else if (i == 0 && j > 0) {
					sumMatrix[i][j] = sumMatrix[i][j - 1] + matrix[i][j];
				} else if (j == 0 && i > 0) {
					sumMatrix[i][j] = sumMatrix[i - 1][j] + matrix[i][j];
				}
			}
		}
	}

	public static void main(String[] args) {
		MatrixSum m = new MatrixSum();
		m.populate();
		m.print();
		m.sumUp();
		;
		m.print();
	}
}
