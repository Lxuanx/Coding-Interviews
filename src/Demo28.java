/**
 * ��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡���������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}��
 * ��������2�������г�����5�Σ��������鳤�ȵ�һ�룬������2����������������0��
 * 
 */
public class Demo28 {
	public static void main(String[] args) {
		int[] ints = { 1, 2, 3, 2, 2, 2, 5, 4};
		int i = MoreThanHalfNum_Solution(ints);
		System.out.println(i);
	}

	public static int MoreThanHalfNum_Solution(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}
		int current = array[0];
		int currentTime = 1;
		for (int i = 1; i < array.length; i++) {
			if (array[i] == current) {
				currentTime++;
			} else {
				currentTime--;
				if (currentTime == -1) {
					currentTime = 1;
					current = array[i];
				}
			}

		}

		if (currentTime > 0) {
			currentTime = 0;
			for (int i = 0; i < array.length; i++) {
				if (array[i] == current) {
					currentTime++;
				}
			}
			if (currentTime * 2 > array.length) {
				return current;
			}
		}
		return 0;
	}
}
