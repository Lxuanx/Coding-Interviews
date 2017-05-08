import java.util.Stack;

/**
 * ����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ��СԪ�ص�min������
 * 
 */
public class Demo20 {

	public static void main(String[] args) {
	}

	public static class SS {
		public Stack<Integer> stack = new Stack<Integer>();
		public Stack<Integer> minStack = new Stack<Integer>();

		public void push(int node) {
			stack.push(node);
			if (minStack.size() == 0) {
				minStack.push(node);
			} else {
				if (min() >= node) {
					minStack.push(node);
				}
			}
		}

		public void pop() {
			Integer pop = stack.pop();
			if (pop == min()) {
				minStack.pop();
			}
		}

		public int top() {
			return stack.peek();
		}

		public int min() throws RuntimeException {
			if (minStack.size() == 0) {
				throw new RuntimeException("�� min ֵ");
			} else {
				return minStack.peek();
			}
		}
	}

}
