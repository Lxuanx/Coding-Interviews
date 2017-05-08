import java.util.HashMap;

/**
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置。如果字符串为空,返回-1
 * 
 */
public class Demo34 {

	public int FirstNotRepeatingChar(String str) {
		if (str == null || str.equals("")) {
			return 0;
		}
		char[] array = str.toCharArray();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : array) {
			if (!map.containsKey(c)) {
				map.put(c, 0);
			} else {
				map.put(c, 1);
			}
		}
		for (int i = 0; i < array.length; i++) {
			if (map.get(array[i]) == 0) {
				return i;
			}
		}
		return 0;
	}
}
