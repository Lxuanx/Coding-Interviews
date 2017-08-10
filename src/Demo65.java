/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，
 * 向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。 例如 a b c e s f c s a d e e
 * 矩阵中包含一条字符串
 * "bcced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
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
