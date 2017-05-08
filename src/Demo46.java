/**
 * ÿ����һ��ͯ��,ţ�Ͷ���׼��һЩС����ȥ�����¶�Ժ��С����,����������ˡ�HF��Ϊţ�͵�����Ԫ��,��ȻҲ׼����һЩС��Ϸ������,�и���Ϸ��������:����,
 * ��С������Χ��һ����Ȧ
 * ��Ȼ��,�����ָ��һ����m,�ñ��Ϊ0��С���ѿ�ʼ������ÿ�κ���m-1���Ǹ�С����Ҫ���г��׸�,Ȼ���������Ʒ�����������ѡ����,���Ҳ��ٻص�Ȧ��
 * ,��������һ��С���ѿ�ʼ
 * ,����0...m-1����....������ȥ....ֱ��ʣ�����һ��С����,���Բ��ñ���,�����õ�ţ������ġ�����̽���ϡ���ذ�(��������Ŷ
 * !!^_^)��������������,�ĸ�С���ѻ�õ������Ʒ�أ�(ע��С���ѵı���Ǵ�0��n-1)
 * 
 */
public class Demo46 {
	public static void main(String[] args) {
		System.out.println(LastRemaining_Solution(3, 3));
	}

	public static int LastRemaining_Solution(int n, int m) {
		if (n <= 0 || m <= 0) {
			return -1;
		}
		int[] ints = new int[n];
		int index = 0;
		int step = m;
		int currentPersonCount = n;
		while (currentPersonCount != 1) {
			while (ints[index] == -1) {
				index = (index + 1) % n;
			}
			step--;
			if (step == 0) {
				ints[index] = -1;
				currentPersonCount--;
				step = m;
			}
			index = (index + 1) % n;
		}
		for (int i = 0; i < ints.length; i++) {
			if (ints[i] == 0) {
				return i;
			}
		}
		return 0;
	}

	/**
	 * ����ʱ�䣺452msռ���ڴ棺528k
	 */
	public static int LastRemaining_Solution1(int n, int m) {
		if (n <= 0 || m <= 0) {
			return 0;
		}
		boolean[] isLive = new boolean[n];
		for (int i = 0; i < isLive.length; i++) {
			isLive[i] = true;
		}
		int index = 0;
		int current = m;
		int currentCount = n;
		while (currentCount != 1) {
			while (isLive[index] == false) {
				index = (index + 1) % n;
			}
			current--;
			if (current == 0) {
				isLive[index] = false;
				currentCount--;
				current = m;
			}
			index = (index + 1) % n;
		}
		for (int i = 0; i < isLive.length; i++) {
			if (isLive[i] == true) {
				return i;
			}
		}
		return 0;
	}
}
