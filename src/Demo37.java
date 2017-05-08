/**
 * 统计一个数字在排序数组中出现的次数。
 * 
 * 
 */
public class Demo37 {
	public static void main(String[] args) {
		int[] ints = { 1, 1, 2, 2, 2, 2, 2 };
		int numberOfK = GetNumberOfK(ints, 1);
		System.out.println(numberOfK);
	}

	public static int GetNumberOfK(int[] array, int k) {
		if (array == null || array.length == 0) {
			return 0;
		}
		int start = 0;
		int end = array.length - 1;
		int mid = (start + end) / 2;
		int midNumber = array[mid];
		while (midNumber != k) {
			if (start > end) {
				return 0;
			}
			if (start <= end && midNumber < k) {
				start = mid + 1;
				mid = (start + end) / 2;
				midNumber = array[mid];
			}
			if (start <= end && midNumber > k) {
				end = mid - 1;
				mid = (start + end) / 2;
				midNumber = array[mid];
			}
		}
		start = mid;
		end = mid;
		while (start > 0 && array[start - 1] == k) {
			start--;
		}
		while (end < array.length - 1 && array[end + 1] == k) {
			end++;
		}
		return end - start + 1;
	}
}
