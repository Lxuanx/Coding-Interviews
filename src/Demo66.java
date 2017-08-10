/**
 * ������һ��m�к�n�еķ���һ�������˴�����0,0�ĸ��ӿ�ʼ�ƶ���ÿһ��ֻ�������ң��ϣ����ĸ������ƶ�һ��
 * ���ǲ��ܽ�������������������λ֮�ʹ���k�ĸ��ӡ� ���磬��kΪ18ʱ���������ܹ����뷽��35,37������Ϊ3+5+3+7 =
 * 18�����ǣ������ܽ��뷽��35,38������Ϊ3+5+3+8 = 19�����ʸû������ܹ��ﵽ���ٸ����ӣ�
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
