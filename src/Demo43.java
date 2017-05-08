/**
 * �����������һ����λָ�����ѭ�����ƣ�ROL���������и��򵥵����񣬾������ַ���ģ�����ָ���������������һ���������ַ�����S��
 * �������ѭ������Kλ����������
 * �����磬�ַ�����S=��abcXYZdef��,Ҫ�����ѭ������3λ��Ľ��������XYZdefabc�����ǲ��Ǻܼ򵥣�OK���㶨����
 * 
 */
public class Demo43 {
	public static void main(String[] args) {
		System.out.println(LeftRotateString("abcXYZdef", 3));
	}

	public static String LeftRotateString(String str, int n) {
		if (str == null || n < 0 || n > str.length()) {
			return "";
		}
		char[] chars = str.toCharArray();
		int i = 0, j = n - 1;
		swapChars(chars, i, j);
		i = n;
		j = chars.length - 1;
		swapChars(chars, i, j);
		i = 0;
		j = chars.length - 1;
		swapChars(chars, i, j);

		return new String(chars);
	}
	
	public static void swapChars(char[] chars, int i, int j){
		while (i < j) {
			char temp = chars[i];
			chars[i++] = chars[j];
			chars[j--] = temp;
		}
	}
}
