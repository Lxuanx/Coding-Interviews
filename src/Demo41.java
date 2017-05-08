import java.util.ArrayList;

/**
 * С����ϲ����ѧ,��һ����������ѧ��ҵʱ,Ҫ������9~16�ĺ�,�����Ͼ�д������ȷ����100�����������������ڴ�,
 * �����뾿���ж������������������еĺ�Ϊ100
 * (���ٰ���������)��û���,���͵õ���һ������������Ϊ100������:18,19,20,21,22�����ڰ����⽻����
 * ,���ܲ���Ҳ�ܿ���ҳ����к�ΪS��������������? Good Luck!
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
