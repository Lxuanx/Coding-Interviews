/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 =
 * 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * 
 */
public class Demo66 {
	public static void main(String[] args) {
		new Demo66().movingCount(threshold, rows, cols)
	}

	int time;

	public int movingCount(int threshold, int rows, int cols) {
		if (rows == 0 || cols == 0) {
			return time;
		}
		boolean[][] bs = new boolean[rows][cols];
		dfs(threshold, 0, 0, rows, cols, bs);
		return time;
	}

	private void dfs(int threshold, int i, int j, int rows, int cols,
			boolean[][] bs) {
		if (bs[i][j] == true) {
			return;
		}
		if (bitSum(i) + bitSum(j) > threshold) {
			return;
		}
		bs[i][j] = true;
		time++;
		if (i != 0) {
			dfs(threshold, i - 1, j, rows, cols, bs);
		}
		if (i != rows - 1) {
			dfs(threshold, i + 1, j, rows, cols, bs);
		}
		if (j != 0) {
			dfs(threshold, i, j - 1, rows, cols, bs);
		}
		if (j != cols - 1) {
			dfs(threshold, i, j + 1, rows, cols, bs);
		}
	}

	public int bitSum(int num) {
		int sum = 0;
		while (num != 0) {
			sum += num % 10;
			num /= 10;
		}
		return sum;
	}

}
