/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * 
 */
public class Demo23 {

	public static void main(String[] args) {
		int[] ints = { 1, 2, 3, 9, 5, 4 };
		boolean b = VerifySquenceOfBST(ints);
		System.out.println(b);
	}

	public static boolean VerifySquenceOfBST(int[] sequence) {
		if (sequence == null) {
			return true;
		}
		return VerifySquenceOfBST(sequence, 0, sequence.length - 1);
	}

	private static boolean VerifySquenceOfBST(int[] sequence, int start, int end) {
		if (start >= end) {
			return true;
		}

		int lastValue = sequence[end];
		int left = start - 1;
		while (sequence[left + 1] < lastValue) {
			left++;
		}
		int right = left;
		while (sequence[right + 1] > lastValue) {
			right++;
		}
		if (right != end - 1) {
			return false;
		}

		return VerifySquenceOfBST(sequence, start, left)
				&& VerifySquenceOfBST(sequence, left + 1, right);
	}
}
