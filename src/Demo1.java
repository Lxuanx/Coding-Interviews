/**
 * ��һ����ά�����У�ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳�����������һ������������������һ����ά�����һ��������
 * �ж��������Ƿ��и�������
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
