import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
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
				throw new RuntimeException("无 min 值");
			} else {
				return minStack.peek();
			}
		}
	}

}
