import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
 * 则打印出这三个数字能排成的最小数字为321323。
 * 
 * 
 */
public class Demo32 {

	public static void main(String[] args) {
		System.out.println("323".compareTo("332"));
		int[] ints = { 3,32,321};
		System.out.println(PrintMinNumber(ints));
	}

	public static String PrintMinNumber(int[] numbers) {
		if (numbers == null || numbers.length == 0) {
			return "";
		}
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i : numbers) {
			al.add(i);
		}
		Collections.sort(al, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				String str1 = o1 + "" + o2;
				String str2 = o2 + "" + o1;
				return str1.compareTo(str2);
			}
		});
		StringBuilder sb = new StringBuilder();
		Iterator<Integer> iterator = al.iterator();
		while (iterator.hasNext()) {
			sb.append(iterator.next());
		}
		return sb.toString();
	}
}
