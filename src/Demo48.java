/**
 * дһ������������������֮�ͣ�Ҫ���ں������ڲ���ʹ��+��-��*��/����������š�
 * 
 */
public class Demo48 {
	public static void main(String[] args) {
		System.out.println(Add(5, 0));
	}

	public static int Add(int num1, int num2) {
		if (num1 == 0) {
			return num2;
		} else if (num2 == 0) {
			return num1;
		}

		int a = num1 ^ num2;
		int b = (num1 & num2) << 1;
		num1 = a;
		num2 = b;
		while (b != 0) {
			a = num1 ^ num2;
			b = (num1 & num2) << 1;
			num1 = a;
			num2 = b;
		}
		return a;
	}
}
