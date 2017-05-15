import java.util.Scanner;

/**
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * 
 */
public class Demo49 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String numStr = sc.next();
		System.out.println(StrToInt(numStr));
	}

	public static int StrToInt(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		char[] numChars = str.toCharArray();
		int num = 0;
		for (char c : numChars) {
			if(c == '+' || c == '-'){
				continue;
			}
			int temp = c - '0';
			if(temp < 0 || temp > 9) {
				return 0;
			}
			num = num * 10 + temp;
		}
		if(numChars[0] == '-'){
			num = -num;
		}
		return num;
	}
}
