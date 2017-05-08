public class Demo16 {
	public static class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {

	}

	public static ListNode Merge(ListNode list1, ListNode list2) {
		ListNode head = null;
		if (list1 == null) {
			return list2;
		} else if (list2 == null) {
			return list1;
		}
		ListNode cursor = null;
		while (list1 != null && list2 != null) {
			if (list1.val > list2.val) {
				if (head == null) {
					head = cursor = list2;
				} else {
					cursor.next = list2;
					cursor = cursor.next;
				}
				list2 = list2.next;
			} else {
				if (head == null) {
					head = cursor = list1;
				} else {
					cursor.next = list1;
					cursor = cursor.next;
				}
				list1 = list1.next;
			}
		}

		if (list1 != null) {
			cursor.next = list1;
		}
		if (list2 != null) {
			cursor.next = list2;
		}
		return head;
	}
}
