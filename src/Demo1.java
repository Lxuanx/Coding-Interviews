/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 */
public class Demo1 {
	public static void main(String[] args) {

	}

	public static boolean find(int target, int[][] array) {
		if (array == null || array[0].length == 0) {
			return false;
		}

		int i = 0;
		int j = array[0].length - 1;

		while (true) {
			while (j >= 0 && i <= array.length - 1 && array[i][j] > target) {
				j--;
			}

			while (j >= 0 && i <= array.length - 1 && array[i][j] < target) {
				i++;
			}

			if (j < 0 || i > array.length - 1) {
				return false;
			}

			if (array[i][j] == target) {
				return true;
			}
		}

	}
}
