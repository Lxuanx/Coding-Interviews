/**
 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2��������Ҳ��������n���������������һ��n����̨���ܹ��ж�����������
 * 
 */
public class Demo9 {

	public static void main(String[] args) {

	}

	public static int JumpFloorII(int target) {
		if (target <= 0) {
			return 0;
		}

		return 1 << (target - 1);
	}
}