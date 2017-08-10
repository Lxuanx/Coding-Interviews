/**
 * ��һ������������У������ظ��Ľ�㣬��ɾ�����������ظ��Ľ�㣬�ظ��Ľ�㲻��������������ͷָ�롣 ���磬����1->2->3->3->4->4->5
 * �����Ϊ 1->2->5
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

			// ���һ������flagѭ�����
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
