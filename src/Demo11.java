/**
 * ����һ��������������������Ʊ�ʾ��1�ĸ��������и����ò����ʾ��
 */
public class Demo11 {

	public static void main(String[] args) {
		System.out.println(NumberOf1(100000));
	}

	public static int NumberOf1(int n) {
		//��Ч
		int count = 0;
		while (n != 0) {
			count++;
			n = n & (n - 1);
		}
		return count;
		//��Ч
//		int flag = 1;
//		int count = 0;
//		while (flag != 0) {
//			if ((flag & n) != 0) {
//				count++;
//			}
//			flag = flag << 1;
//		}
//		return count;
	}
	
}
