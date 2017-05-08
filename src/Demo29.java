import java.util.ArrayList;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * 
 */

public class Demo29 {
	public static void main(String[] args) {
		int[] ints = { 4,5,1,6,2,7,3,8};
		ArrayList<Integer> list = GetLeastNumbers_Solution(ints, 4);
		System.out.println(list);

	}

	public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		if (input == null || input.length == 0 || k < 0 || k > input.length) {
			return new ArrayList<Integer>();
		}
		ArrayList<Integer> al = partition(input, 0, input.length - 1, k);
		return al;
	}

	private static ArrayList<Integer> partition(int[] input, int start,
			int end, int k) {
		int i = start;
		int j = end;
		int temp = input[start];
		while (i < j) {
			while (i < j && input[j] > temp) {
				j--;
			}
			if (i < j) {
				input[i] = input[j];
				i++;
			}
			while (i < j && input[i] < temp) {
				i++;
			}
			if (i < j) {
				input[j] = input[i];
				j--;
			}
		}
		input[i] = temp;
		ArrayList<Integer> al;
		if (i == k || i + 1 == k) {
			al = new ArrayList<Integer>();
			for (int m = 0; m < k; m++) {
				al.add(input[m]);
			}
		} else {
			if (i < k) {
				al = partition(input, i + 1, end, k);
			} else {
				al = partition(input, start, i - 1, k);
			}
		}
		return al;
	}

}
