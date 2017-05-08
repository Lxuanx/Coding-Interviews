/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。 n<=39
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
