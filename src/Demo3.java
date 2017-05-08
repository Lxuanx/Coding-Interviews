import java.util.ArrayList;

/**
 * ����һ��������β��ͷ��ӡ����ÿ���ڵ��ֵ��
 * 
 */
public class Demo3 {

	public static void main(String[] args) {
		ListNode firstNode = new ListNode(2);
		ListNode currentNode = firstNode;
		for (int i = 0; i < 10; i++) {
			ListNode node = new ListNode(i);
			currentNode.next = node;
			currentNode = node;
		}
		ArrayList<Integer> list = printListFromTailToHead(null);
		for (Integer i : list) {
			System.out.println(i);
		}

	}

	public static class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		if (listNode == null) {
			return new ArrayList<Integer>();
		}

		ArrayList<Integer> newArrayList = new ArrayList<Integer>();

		ArrayList<Integer> oldArrayList = printListFromTailToHead(listNode.next);
		if (oldArrayList != null) {
			newArrayList.addAll(oldArrayList);
		}

		newArrayList.add(listNode.val);

		return newArrayList;
	}

}
