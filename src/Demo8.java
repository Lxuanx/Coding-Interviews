/**
 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2���������������һ��n����̨���ܹ��ж�����������
 */
public class Demo8 {

	public static void main(String[] args) {
		System.out.println(JumpFloor(5));
	}

	public static int JumpFloor(int target) {
		if (target <= 0) {
			return 0;
		} else if (target == 1 || target == 2) {
			return target;
		}
		int[] ints = new int[target + 1];
		ints[1] = 1;
		ints[2] = 2;
		for (int i = 3; i < target + 1; i++) {
			ints[i] = ints[i - 1] + ints[i - 2];
		}
		return ints[target];
	}
}
