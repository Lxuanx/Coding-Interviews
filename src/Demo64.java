import java.util.ArrayList;
import java.util.LinkedList;

/**
 * ����һ������ͻ������ڵĴ�С���ҳ����л�����������ֵ�����ֵ�����磬�����������{2,3,4,2,6,2,5,1}���������ڵĴ�С3��
 * ��ôһ������6���������ڣ����ǵ����ֵ�ֱ�Ϊ{4,4,6,6,6,5}�� �������{2,3,4,2,6,2,5,1}�Ļ�������������6����
 * {[2,3,4],2,6,2,5,1}�� {2,[3,4,2],6,2,5,1}�� {2,3,[4,2,6],2,5,1}��
 * {2,3,4,[2,6,2],5,1}�� {2,3,4,2,[6,2,5],1}�� {2,3,4,2,6,[2,5,1]}��
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
		// �����ƶ�
		for (int i = 0; i < num.length; i++) {
			if (!indexs.isEmpty() && indexs.peekFirst() + size <= i) {
				indexs.pollFirst();
			}
			// �����޳�����С��
			while (!indexs.isEmpty() && num[indexs.peekLast()] < num[i]) {
				indexs.pollLast();
			}
			// ��ӵ����
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
		// �����ƶ�
		for (int i = 0; i < num.length; i++) {
			if (i >= size) {
				res.add(num[indexs.peekFirst()]);
				if (indexs.peekFirst() + size <= i) {
					indexs.pollFirst();
				}
			}

			Integer LastIndex = indexs.peekLast();
			// �����޳�����С��
			while (LastIndex != null && num[LastIndex] < num[i]) {
				indexs.pollLast();
				LastIndex = indexs.peekLast();
			}
			// ��ӵ����
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
		// ��ó�ʼ����
		for (int i = 0; i < size; i++) {
			Integer lastIndex = indexs.peekLast();
			// �����޳�����С��
			while (lastIndex != null && num[lastIndex] < num[i]) {
				indexs.pollLast();
				lastIndex = indexs.peekLast();
			}
			// ��ӵ����
			indexs.addLast(i);
		}

		// �����ƶ�
		for (int i = size; i < num.length; i++) {
			al.add(num[indexs.peekFirst()]);

			if (indexs.peekFirst() + size <= i) {
				indexs.pollFirst();
			}

			Integer LastIndex = indexs.peekLast();
			// �����޳�����С��
			while (LastIndex != null && num[LastIndex] < num[i]) {
				indexs.pollLast();
				LastIndex = indexs.peekLast();
			}
			// ��ӵ����
			indexs.addLast(i);
		}
		if (indexs.peekFirst() + size <= num.length - 1) {
			indexs.pollFirst();
		}
		al.add(num[indexs.peekFirst()]);

		return al;
	}
}
