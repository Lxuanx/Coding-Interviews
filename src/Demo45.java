import java.util.Arrays;

/**
 * LL���������ر��,��Ϊ��ȥ����һ���˿���,���������Ȼ��2������,2��С��(һ����ԭ����54��^_^)...��������г����5����,�����Լ�������,
 * �����ܲ��ܳ鵽˳��,����鵽�Ļ�,������ȥ��������Ʊ,�ٺ٣���������A,����3,С��,����,��Ƭ5��,��Oh My
 * God!������˳��.....LL��������,��������,������\С
 * �����Կ����κ�����,����A����1,JΪ11,QΪ12,KΪ13�������5���ƾͿ��Ա�ɡ�1,2,3,4,5��(��С���ֱ���2��4),��So
 * Lucky!����LL����ȥ��������Ʊ���� ����,Ҫ����ʹ�������ģ������Ĺ���,Ȼ���������LL��������Ρ�Ϊ�˷������,�������Ϊ��С����0��
 * 
 */
public class Demo45 {
	public static void main(String[] args) {
		int[] ints = { 0, 2, 1, 3, 5 };
		System.out.println(isContinuous(ints));

	}

	public static boolean isContinuous(int[] numbers) {
		if (numbers == null || numbers.length != 5) {
			return false;
		}
		Arrays.sort(numbers);
		int left = 0, right = numbers.length - 1;
		while (numbers[left] == 0) {
			left++;
		}
		if (numbers[right] - numbers[left] > 4) {
			return false;
		}
		for (int i = left; i < right ; i++) {
			if (numbers[i] == numbers[i + 1]) {
				return false;
			}
		}
		return true;
	}
}