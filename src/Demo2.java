/**
 * ��ʵ��һ����������һ���ַ����еĿո��滻�ɡ�%20����
 * ���磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
 * 
 */
public class Demo2 {
	public static void main(String[] args) {

	}

	public static String replaceSpace(StringBuffer str) {
		if (str == null) {
			return null;
		}
		if (str.length() == 0) {
			return "";
		}

		char[] charArray = str.toString().toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] == ' ') {
				sb.append("%20");
			} else {
				sb.append(charArray[i]);
			}
		}
		return sb.toString();
	}

}
