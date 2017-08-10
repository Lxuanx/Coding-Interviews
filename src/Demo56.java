/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5
 * 处理后为 1->2->5
 * 
 */
public class Demo56 {
	public static class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public ListNode deleteDuplication(ListNode pHead) {
		if (pHead == null) {
			return null;
		}

		ListNode current = pHead, preNode = null, lastNode = null;

		while (current != null) {
			boolean isClear = false;
			int value = current.val;
			if (current.next != null && value == current.next.val) {
				isClear = true;
			}

			// 如果一样立个flag循环清除
			if (isClear) {
				while (current != null && current.val == value) {
					current = current.next;
					if (preNode != null) {
						lastNode.next = current;
					}
				}
			} else {
				if (preNode == null) {
					preNode = current;
				}
				lastNode = current;
				current = current.next;
			}
		}
		return preNode;
	}
}
