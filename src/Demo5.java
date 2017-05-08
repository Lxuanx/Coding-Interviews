import java.util.Stack;
/**
 * ������ջ��ʵ��һ�����У���ɶ��е�Push��Pop������ �����е�Ԫ��Ϊint���͡�
 *
 */
public class Demo5 {

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			System.out.println(pop());
		}
	}

	static Stack<Integer> stack1 = new Stack<Integer>();
	static Stack<Integer> stack2 = new Stack<Integer>();

	public static void push(int node) {
		stack1.push(node);
	}

	public static int pop() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}

		if (!stack2.isEmpty()) {
			Integer pop = stack2.pop();
			return pop;
		}
		return -1;
	}
}
