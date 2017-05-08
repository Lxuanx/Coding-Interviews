/**
 * ����һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ�����е�����λ�������ǰ�벿�֣����е�ż��λ��λ������ĺ�벿�֣�����֤������������
 * ż����ż��֮������λ�ò��䡣
 * 
 */
public class Demo13 {

	public static void main(String[] args) {
		int[] ints = { 1, 3, 5, 7, 2, 4, 6 };
		reOrderArray(ints);
		for (int num : ints) {
			System.out.print(num + " ");
		}
	}

	public static void reOrderArray(int[] array) {
		int[] newArray = new int[array.length];
		int index = 0, newIndex = 0;
		while (index < array.length) {
			// �ҳ���һ����������index
			while (index < array.length && (array[index] & 1) == 0) {
				index++;
			}
			if (index < array.length) {
				newArray[newIndex++] = array[index++];
			}
		}
		index = 0;
		while (index < array.length && newIndex != array.length) {
			// �ҳ���һ����ż����index
			while (index < array.length && (array[index] & 1) == 1) {
				index++;
			}
			if (index < array.length) {
				newArray[newIndex++] = array[index++];
			}
		}
		for (int i = 0; i < array.length; i++) {
			array[i] = newArray[i];
		}
	}

	private static void error(int[] array) {
		int left = 0, right = array.length - 1;
		while (left <= right) {
			// �������������
			while (left < array.length && (array[left] & 1) == 1) {
				left++;
			}
			while (right >= 0 && (array[right] & 1) == 0) {
				right--;
			}

			if (left <= right) {
				int temp = array[left];
				array[left] = array[right];
				array[right] = temp;
			}
		}
	}
}
