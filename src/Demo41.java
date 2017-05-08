import java.util.ArrayList;

/**
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,
 * 他在想究竟有多少种连续的正数序列的和为100
 * (至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你
 * ,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 */
public class Demo41 {
	
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> al = FindContinuousSequence(1);
		System.out.println(al);
	}
	public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
		if (sum <= 1) {
			return al;
		}
		int start = 1;
		int end = 0;
		int currentSum = 0;
		int maxValue = (sum >> 1) + 1;
		while (end <= maxValue) {
			while (currentSum < sum) {
				currentSum += ++end;
			}
			if (currentSum == sum) {
				addCurrentSequence(al, start, end);
				currentSum += ++end;
			}
			while (currentSum > sum) {
				currentSum -= start++;
			}
		}
		return al;
	}

	private static void addCurrentSequence(ArrayList<ArrayList<Integer>> al,
			int start, int end) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = start; i <= end; i++) {
			list.add(i);
		}
		al.add(list);
	}
}
