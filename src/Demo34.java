import java.util.HashMap;

/**
 * ��һ���ַ���(1<=�ַ�������<=10000��ȫ������ĸ���)���ҵ���һ��ֻ����һ�ε��ַ�,����������λ�á�����ַ���Ϊ��,����-1
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
