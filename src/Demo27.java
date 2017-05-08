import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * ����һ���ַ���,���ֵ����ӡ�����ַ������ַ����������С����������ַ���abc,���ӡ�����ַ�a,b,c�������г����������ַ���abc,acb,bac,
 * bca,cab��cba��
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
