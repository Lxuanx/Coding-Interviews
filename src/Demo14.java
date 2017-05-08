/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 
 */
public class Demo14 {

	public static class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}

	}

	public static void main(String[] args) {
		ListNode node = new ListNode(5);
		System.out.println(FindKthToTail(node, 1));
	}

	public static ListNode FindKthToTail(ListNode head, int k) {
		if (head == null || k <= 0) {
			return null;
		}
		ListNode last = head;
		int i = 0;
		while (i != k ) {
			if (last == null) {
				return null;
			}
			last = last.next;
			i++;
		}
		
		ListNode pre = head;
		while (last != null) {
			last = last.next;
			pre = pre.next;
		}
		return pre;
	}

}
