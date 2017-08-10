/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"
 * 都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */

public class Demo53 {
	public static void main(String[] args) {
		System.out.println(isNumeric("12e+4.3".toCharArray()));
	}

	public static boolean isNumeric(char[] str) {
		if (str == null || str.length == 0) {
			return false;
		}
		int index = 0;
		if (str[index] == '+' || str[index] == '-') {
			index++;
		}
		index = scrollNum(str, index);
		if (str.length > index) {
			if ((str[index] == 'E' || str[index] == 'e')) {
				index++;
				if(index == str.length ){
					return false;
				}
				if (str.length > index
						&& (str[index] == '+' || str[index] == '-')) {
					index++;
				}
				while (str.length > index && str[index] >= '0' && str[index] <= '9') {
					index++;
				}
				if (index == str.length) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		}

		return true;
	}

	private static int scrollNum(char[] str, int i) {
		while (str.length > i && str[i] >= '0' && str[i] <= '9') {
			i++;
		}
		if (str.length > i && str[i] == '.') {
			i++;
		}
		while (str.length > i && str[i] >= '0' && str[i] <= '9') {
			i++;
		}
		return i;
	}
}
