import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,
 * bca,cab和cba。
 * 
 */
public class Demo27 {
	public static ArrayList<String> al = new ArrayList<String>();
	public static HashSet<String> hs = new HashSet<String>();

	public static ArrayList<String> Permutation(String str) {
		if (str == null || str.length() == 0) {
			return al;
		}
		char[] charArray = str.toCharArray();
		arrayWord(charArray, 0);
		al.addAll(hs);
		Collections.sort(al);
		return al;
	}

	private static void arrayWord(char[] charArray, int curIndex) {
		if (curIndex == charArray.length) {
			hs.add(new String(charArray));
			return;
		}
		for (int i = curIndex; i < charArray.length; i++) {
			swap(charArray, i, curIndex);
			arrayWord(charArray, curIndex + 1);
			swap(charArray, i, curIndex);
		}
	}

	private static void swap(char[] charArray, int i, int curIndex) {
		if (i != curIndex) {
			char temp = charArray[i];
			charArray[i] = charArray[curIndex];
			charArray[curIndex] = temp;
		}
	}

	public static void main(String[] args) {
		ArrayList<String> arrayList = Permutation("abc");
		System.out.println(arrayList);
	}
}
