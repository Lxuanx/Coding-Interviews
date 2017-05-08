/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，并保证奇数和奇数，
 * 偶数和偶数之间的相对位置不变。
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
			// 找出下一个是奇数的index
			while (index < array.length && (array[index] & 1) == 0) {
				index++;
			}
			if (index < array.length) {
				newArray[newIndex++] = array[index++];
			}
		}
		index = 0;
		while (index < array.length && newIndex != array.length) {
			// 找出下一个是偶数的index
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
			// 是奇数的情况下
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
