/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 * 
 */
public class Demo35 {
	public static void main(String[] args) {
		int[] ints = { 1, 2, 3, 4, 1, 2, 3, 1, 2, 3, 4, 5, 6, 7, 0, 4, 5, 6, 7,
				0, 5, 6, 7, 0 };
		System.out.println(InversePairs(ints));
	}

	public static int[] newInts;

	public static int InversePairs(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}
		newInts = new int[array.length];
		return mergerPairs(array, 0, array.length - 1);
	}

	private static int mergerPairs(int[] array, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			int left = mergerPairs(array, start, mid);
			int right = mergerPairs(array, mid + 1, end);

			return (left + right + getTime(array, start, mid, mid + 1, end)) % 1000000007;
		}
		return 0;
	}

	private static int getTime(int[] array, int start1, int end1, int start2,
			int end2) {
		int i = start1, j = start2;
		int index = 0;
		int time = 0;
		while (i <= end1 && j <= end2) {
			if (array[i] < array[j]) {
				newInts[index++] = array[i++];
			} else {
				newInts[index++] = array[j++];
				time += end1 - i + 1;
				if (time > 1000000007) {
					time %= 1000000007;
				}
			}
		}
		while (i <= end1) {
			newInts[index++] = array[i++];
		}
		while (j <= end2) {
			newInts[index++] = array[j++];
		}
		index = 0;
		for (int k = start1; k <= end2; k++) {
			array[k] = newInts[index++];
		}
		return time % 1000000007;
	}
}
