/**
 * ���ǿ�����2*1��С���κ��Ż�������ȥ���Ǹ���ľ��Ρ�������n��2*1��С�������ص��ظ���һ��2*n�Ĵ���Σ��ܹ��ж����ַ�����
 * 
 */
public class Demo10 {
	public static void main(String[] args) {

	}

	public static int RectCover(int target) {
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
