/**
 * ��1+2+3+...+n��Ҫ����ʹ�ó˳�����for��while��if��else��switch��case�ȹؼ��ּ������ж���䣨A?B:C��
 * 
 */
public class Demo47 {

	public static void main(String[] args) {
		System.out.println(Sum_Solution(10));
	}

	public static int Sum_Solution(int n) {
		int sum = n;
		boolean ans = (n != 0) && (sum += Sum_Solution(n - 1)) > 0;
		return sum;
	}
}