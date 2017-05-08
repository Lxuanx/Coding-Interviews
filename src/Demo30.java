/**
 * HZż������Щרҵ������������Щ�Ǽ����רҵ��ͬѧ����������鿪����,���ַ�����:�ڹ��ϵ�һάģʽʶ����,������Ҫ��������������������,
 * ������ȫΪ������ʱ��
 * ,����ܺý��������,��������а�������,�Ƿ�Ӧ�ð���ĳ������,�������Աߵ��������ֲ����أ�����:{6,-3,-2,7,-15,1,2,
 * 2},����������������Ϊ8(�ӵ�0����ʼ,����3��Ϊֹ)����᲻�ᱻ������ס��(�������ĳ���������1)
 * 
 */
public class Demo30 {
	public static void main(String[] args) {
		int[] ints = { 6, -3, -2, 7, -15, 1, 2, 2 };
		System.out.println(FindGreatestSumOfSubArray(ints));
	}

	public static int FindGreatestSumOfSubArray(int[] array) {
		if (array == null) {
			return 0;
		}
		int candidate = array[0];
		int sum = array[0];
		for (int i = 1; i < array.length; i++) {
			if (sum < 0) {
				sum = array[i];
			} else {
				sum += array[i];
			}

			if (sum > candidate) {
				candidate = sum;
			}
		}
		return candidate;
	}

}
