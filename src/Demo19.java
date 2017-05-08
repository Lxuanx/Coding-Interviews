import java.util.ArrayList;

/**
 * ����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ�����֣����磬����������¾��� 1 2 3 4 5 6 7 8 9 10 11 12 13 14
 * 15 16 �����δ�ӡ������1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
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
		int layers = ((row > col ? col : row) - 1) / 2 + 1; // ���ѭ���Ų���!!! �Ǹ���!!!
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
