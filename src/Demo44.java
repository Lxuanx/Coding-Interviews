/**
 * ţ���������һ����Ա��Fish��ÿ���糿���ǻ�����һ��Ӣ����־��дЩ�����ڱ����ϡ�ͬ��Cat��Fishд�������ĸ���Ȥ����һ������Fish����������
 * ��ȴ������������˼�����磬��student. a am I������������ʶ������һ�ԭ���Ѿ��ӵ��ʵ�˳��ת�ˣ���ȷ�ľ���Ӧ���ǡ�I am a
 * student.����Cat��һһ�ķ�ת��Щ����˳��ɲ����У����ܰ�����ô��
 * 
 */
public class Demo44 {
	public static void main(String[] args) {
		System.out.println(ReverseSentence("  student. a am I   "));
	}

	public static String ReverseSentence(String str) {
		if (str == null || str.length() == 0) {
			return "";
		}
		char[] charArray = str.toCharArray();
		int i = 0, j = 0;
		while (j < charArray.length) {
			while (j != charArray.length && charArray[j] != ' ') {
				j++;
			}
			// ��ǰ�ǿո����
			if (i == j) {
				i++;
				j++;
				continue;
			}
			swapChars(charArray, i, j - 1);
			j++;
			i = j;
		}
		swapChars(charArray, 0, charArray.length - 1);
		return new String(charArray);
	}

	// ���ܴ���" "����
	// public static String ReverseSentence(String str) {
	// if (str == null || str.length() == 0) {
	// return "";
	// }
	// String[] strs = str.split(" ");
	// char[] newChars = new char[str.length()];
	// int index = 0;
	// for (int i = 0; i < strs.length; i++) {
	// char[] charArray = strs[i].toCharArray();
	// swapChars(charArray, 0, charArray.length - 1);
	// System.arraycopy(charArray, 0, newChars, index, charArray.length);
	// index += charArray.length;
	// if (i != strs.length - 1) {
	// newChars[index++] = ' ';
	// }
	// }
	// swapChars(newChars, 0, newChars.length - 1);
	// return new String(newChars);
	// }

	public static void swapChars(char[] chars, int i, int j) {
		while (i < j) {
			char temp = chars[i];
			chars[i++] = chars[j];
			chars[j--] = temp;
		}
	}
}
