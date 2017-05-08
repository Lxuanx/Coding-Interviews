public class Demo36 {

	public static class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		if (pHead1 == null || pHead2 == null) {
			return null;
		}
		int length1 = 0, length2 = 0;
		ListNode p = pHead1;
		while (p != null) {
			p = p.next;
			length1++;
		}
		p = pHead2;
		while (p != null) {
			p = p.next;
			length2++;
		}
		ListNode shortNode = length1 < length2 ? pHead1 : pHead2;
		ListNode longNode = shortNode == pHead1 ? pHead2 : pHead1;
		int step = shortNode == pHead1 ? length2 - length1 : length1 - length2;
		while (step != 0) {
			step--;
			longNode = longNode.next;
		}
		while (shortNode != null && longNode != null) {
			if (shortNode == longNode) {
				return shortNode;
			}
			shortNode = shortNode.next;
			longNode = longNode.next;
		}
		return null;
	}
}
