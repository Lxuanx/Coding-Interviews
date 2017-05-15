import java.util.Scanner;

/**
 * ��һ���ַ���ת����һ��������Ҫ����ʹ���ַ���ת�������Ŀ⺯���� ��ֵΪ0�����ַ�������һ���Ϸ�����ֵ�򷵻�0
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
