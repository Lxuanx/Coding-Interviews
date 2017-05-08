/**
 * ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת�� ����һ���ǵݼ�����������һ����ת�������ת�������СԪ�ء�
 * ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1�� NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��
 * 
 */
public class Demo6 {
	public static void main(String[] args) {
		int minNumber = minNumberInRotateArray(new int[] { 4, 5, 2, 3 });
		System.out.println(minNumber);
	}

	public static int minNumberInRotateArray(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}
		int low = 0;
		int high = array.length - 1;
		while (low < high) {
			int mid = (low + high) / 2;
			if (array[mid] > array[high]) {
				low = mid + 1;
			} else if (array[mid] < array[high]) {
				high = mid;
			} else {
				high--;
			}
		}
		return array[low];
	}

	/*
	 * public static int minNumberInRotateArray(int[] array) { if (array == null
	 * || array.length == 0) { return 0; } if (array.length == 1) { return
	 * array[0]; } if (array.length == 2) { return binarySearch(array); }
	 * 
	 * int min = binarySearch(array, 0, array.length - 1); return min; }
	 */

	private static int binarySearch(int[] array, int start, int end) {
		int mid = (start + end) / 2;
		if (mid != 0 && array[mid] < array[mid - 1]) {
			return array[mid];
		}

		int min = -1;
		if (array[mid] > array[start] && array[mid] > array[end]) {
			min = binarySearch(array, mid, end);
		} else if (array[mid] < array[start] && array[mid] < array[end]) {
			min = binarySearch(array, start, mid);
		} else if (array[mid] == array[start] || array[mid] == array[end]) {
			min = binarySearch(array);
		}

		return min;
	}

	private static int binarySearch(int[] array) {
		int min = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] < array[i - 1]) {
				min = array[i];
				break;
			}
		}

		return min;
	}
}
