import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14
 * 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * 
 * 
 */
public class Demo19 {

	public static void main(String[] args) {
		int[][] ints = { { 1, 2 }, { 3, 4 }, { 5, 6 }, { 7, 8 }, { 9, 10 } };
		;
		ArrayList<Integer> list = printMatrix(ints);
		System.out.println(list);
	}

	public static ArrayList<Integer> printMatrix(int[][] matrix) {
		if (matrix == null) {
			return new ArrayList<Integer>();
		}
		int row = matrix.length;
		int col = matrix[0].length;
		int layers = ((row > col ? col : row) - 1) / 2 + 1; // 这个循环才层数!!! 是个坑!!!
		ArrayList<Integer> al = new ArrayList<Integer>();
		int i = 0;
		while (i < layers) {
			for (int j = i; j < col - i; j++) {
				al.add(matrix[i][j]);
			}
			for (int k = i + 1; k < row - i; k++) {
				al.add(matrix[k][col - i - 1]);
			}
			for (int j = col - i - 2; (j > i) && (row - i - 1 != i); j--) {
				al.add(matrix[row - i - 1][j]);
			}
			for (int k = row - i - 1; (k > i) && (col - i - 1 != i); k--) {
				al.add(matrix[k][i]);
			}
			i++;
		}

		return al;
	}
}
