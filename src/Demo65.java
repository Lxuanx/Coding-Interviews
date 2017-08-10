/**
 * �����һ�������������ж���һ���������Ƿ����һ������ĳ�ַ��������ַ���·����·�����ԴӾ����е�����һ�����ӿ�ʼ��ÿһ�������ھ������������ң����ϣ�
 * �����ƶ�һ�����ӡ����һ��·�������˾����е�ĳһ�����ӣ����·�������ٽ���ø��ӡ� ���� a b c e s f c s a d e e
 * �����а���һ���ַ���
 * "bcced"��·�������Ǿ����в�����"abcb"·������Ϊ�ַ����ĵ�һ���ַ�bռ���˾����еĵ�һ�еڶ�������֮��·�������ٴν���ø��ӡ�
 * 
 */
public class Demo65 {
	public static void main(String[] args) {
		boolean hasPath = new Demo65().hasPath("AAAAAAAAAAAA".toCharArray(), 3,
				4, "AAAAAAAAAAAA".toCharArray());
		System.out.println(hasPath);
	}

	public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		if (matrix == null && str == null) {
			return true;
		} else if (matrix == null || str == null || str.length > matrix.length
				|| rows == 0 || cols == 0 || cols * rows > matrix.length) {
			return false;
		}
		boolean[] matrixBoolean = new boolean[matrix.length];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (dfs(matrix, matrixBoolean, i, j, rows, cols, str, 0)) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean dfs(char[] matrix, boolean[] mboolean, int i, int j,
			int rows, int cols, char[] str, int k) {
		if (matrix[i * cols + j] == str[k]) {
			mboolean[i * cols + j] = true;
			if (k == str.length - 1) {
				return true;
			}
			boolean b = false;
			if (i != 0 && mboolean[(i - 1) * cols + j] != true) {
				b = dfs(matrix, mboolean, i - 1, j, rows, cols, str, k + 1);
			}
			if (b == true) {
				return true;
			}
			if (j != cols - 1 && mboolean[i * cols + (j + 1)] != true) {
				b = dfs(matrix, mboolean, i, j + 1, rows, cols, str, k + 1);
			}
			if (b == true) {
				return true;
			}
			if (j != 0 && mboolean[i * cols + (j - 1)] != true) {
				b = dfs(matrix, mboolean, i, j - 1, rows, cols, str, k + 1);
			}
			if (b == true) {
				return true;
			}
			if (i != rows - 1 && mboolean[(i + 1) * cols + j] != true) {
				b = dfs(matrix, mboolean, i + 1, j, rows, cols, str, k + 1);
			}
			if (b == true) {
				return true;
			}
			mboolean[i * cols + j] = false;
		}
		return false;
	}

}
