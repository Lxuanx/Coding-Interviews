/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class Demo40 {
	public static void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
		if (array == null || array.length == 0) {
			return;
		}
		int data = 0, lastAt1 = 0;
		for (int i : array) {
			data ^= i;
		}
		while ((data & 1) != 1) {
			data >>= 1;
			lastAt1++;
		}
		int partition = 1 << lastAt1;
		for (int i : array) {
			if ((i & partition) != 0) {
				num1[0] ^= i;
			} else {
				num2[0] ^= i;
			}
		}
	}
}
