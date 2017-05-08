import java.util.Stack;

/**
 * ���������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ�Ϊ��ջ�ĵ���˳�򡣼���ѹ��ջ���������־�����ȡ� ��������1,2,3,4,5
 * ��ĳջ��ѹ��˳��
 * ������4��5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У���4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С���ע�⣺���������еĳ�������ȵģ�
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
