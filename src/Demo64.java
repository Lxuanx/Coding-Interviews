import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * 
 */
public class Demo64 {

	public static void main(String[] args) {
		Demo64 demo64 = new Demo64();
		ArrayList<Integer> al = demo64.maxInWindows(new int[] { 16, 14, 12, 10,
				8, 6, 4 }, 5);
		System.out.println(al);
	}

	public ArrayList<Integer> maxInWindows(int[] num, int size) {
		if (num == null || num.length == 0 || size == 0 || size > num.length) {
			return new ArrayList<Integer>();
		}
		ArrayList<Integer> res = new ArrayList<Integer>();
		LinkedList<Integer> indexs = new LinkedList<Integer>();
		// 窗口移动
		for (int i = 0; i < num.length; i++) {
			if (!indexs.isEmpty() && indexs.peekFirst() + size <= i) {
				indexs.pollFirst();
			}
			// 不断剔除后面小的
			while (!indexs.isEmpty() && num[indexs.peekLast()] < num[i]) {
				indexs.pollLast();
			}
			// 添加到最后
			indexs.addLast(i);
			if (i >= size - 1) {
				res.add(num[indexs.peekFirst()]);
			}
		}
		return res;
	}

	public ArrayList<Integer> maxInWindows2(int[] num, int size) {
		if (num == null || num.length == 0 || size == 0 || size > num.length) {
			return new ArrayList<Integer>();
		}

		ArrayList<Integer> res = new ArrayList<Integer>();
		LinkedList<Integer> indexs = new LinkedList<Integer>();
		// 窗口移动
		for (int i = 0; i < num.length; i++) {
			if (i >= size) {
				res.add(num[indexs.peekFirst()]);
				if (indexs.peekFirst() + size <= i) {
					indexs.pollFirst();
				}
			}

			Integer LastIndex = indexs.peekLast();
			// 不断剔除后面小的
			while (LastIndex != null && num[LastIndex] < num[i]) {
				indexs.pollLast();
				LastIndex = indexs.peekLast();
			}
			// 添加到最后
			indexs.addLast(i);
		}
		if (indexs.peekFirst() + size <= num.length - 1) {
			indexs.pollFirst();
		}
		res.add(num[indexs.peekFirst()]);

		return res;
	}

	public ArrayList<Integer> maxInWindows1(int[] num, int size) {
		if (num == null || num.length == 0 || size == 0 || size > num.length) {
			return new ArrayList<Integer>();
		}

		ArrayList<Integer> al = new ArrayList<Integer>();
		LinkedList<Integer> indexs = new LinkedList<Integer>();
		// 获得初始窗口
		for (int i = 0; i < size; i++) {
			Integer lastIndex = indexs.peekLast();
			// 不断剔除后面小的
			while (lastIndex != null && num[lastIndex] < num[i]) {
				indexs.pollLast();
				lastIndex = indexs.peekLast();
			}
			// 添加到最后
			indexs.addLast(i);
		}

		// 窗口移动
		for (int i = size; i < num.length; i++) {
			al.add(num[indexs.peekFirst()]);

			if (indexs.peekFirst() + size <= i) {
				indexs.pollFirst();
			}

			Integer LastIndex = indexs.peekLast();
			// 不断剔除后面小的
			while (LastIndex != null && num[LastIndex] < num[i]) {
				indexs.pollLast();
				LastIndex = indexs.peekLast();
			}
			// 添加到最后
			indexs.addLast(i);
		}
		if (indexs.peekFirst() + size <= num.length - 1) {
			indexs.pollFirst();
		}
		al.add(num[indexs.peekFirst()]);

		return al;
	}
}
