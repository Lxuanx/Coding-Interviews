/**
 * ����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ��������������Yes,�������No���������������������������ֶ�������ͬ��
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
