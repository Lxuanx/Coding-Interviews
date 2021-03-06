import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。 例如序列1,2,3,4,5
 * 是某栈的压入顺序
 * ，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 * 
 * 
 */
public class Demo21 {

	public static void main(String[] args) {
		int[] push = new int[]{1,2,3,4,5};
		int[] pop = new int[]{4,5,3,2,1};
		int[] pop2 = new int[]{4,3,5,1,2};
		System.out.println(IsPopOrder(push, pop));
		System.out.println(IsPopOrder(push, pop2));
	}

	public static boolean IsPopOrder(int[] pushA, int[] popA) {
		if (pushA == null || popA == null || pushA.length != popA.length) {
			return false;
		}

		int index = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i : pushA) {
			stack.add(i);
			while (index != popA.length && stack.peek() == popA[index]) {
				stack.pop();
				index++;
			}
		}

		return index == popA.length;
	}
}
