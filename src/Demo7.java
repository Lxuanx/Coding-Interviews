/**
 * ��Ҷ�֪��쳲��������У�����Ҫ������һ������n���������쳲��������еĵ�n� n<=39
 * 
 */
public class Demo7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int Fibonacci(int n) {
		if (n < 0) {
			return 0;
		}

		int[] result = { 0, 1 };
		if (n < 2) {
			return result[n];
		}

		int num1 = result[0];
		int num2 = result[1];

		for (int i = 2; i <= n; i++) {
			int temp = num1 + num2;
			num1 = num2;
			num2 = temp;
		}

		return num2;
	}
}
