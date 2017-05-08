/**
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，
 * 但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a
 * student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
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
			// 当前是空格情况
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

	// 不能处理" "问题
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
