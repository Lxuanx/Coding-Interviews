/**
 * ����һ��double���͵ĸ�����base��int���͵�����exponent����base��exponent�η���
 */
public class Demo12 {

	public static void main(String[] args) {
		double power = Power(2, 3);
		System.out.println(power);
	}

	public static double Power(double base, int exponent) {
		if (base == 0) {
			return 0;
		}

		if (exponent < 0) {
			exponent = -exponent;
			base = 1 / base;
		}

		double value = base;
		while (exponent != 0) {
			int flag = exponent & 1;
			exponent = exponent >> 1;
			if (exponent != 0) {
				value *= value;
				break;
			}
			if (flag == 1) {
				value += base;
			}
		}
		return value;
	}
	// ��Ч��
	// public static double Power(double base, int exponent) {
	// if (base == 0) {
	// return 0;
	// }
	//
	// if (exponent < 0) {
	// exponent = -exponent;
	// base = 1 / base;
	// }
	// double value = 1;
	// for(int i = 0; i < exponent ; i ++) {
	// value = base * value;
	// }
	// return value;
	// }
}
