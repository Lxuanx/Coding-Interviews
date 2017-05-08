/**
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
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
