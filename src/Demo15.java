/**
 * 输入一个链表，反转链表后，输出链表的所有元素。
 */
public class Demo15 {
	public static class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {

	}

	public static ListNode ReverseList1(ListNode head) {
		if (head == null) {
			return null;
		}
		if(head.next == null){
			return head;
		}
		ListNode pre = head;
		ListNode mid = pre.next;
		ListNode post = mid.next;;
        
		pre.next = null;
        
		while(post != null) {
			mid.next = pre;
			pre = mid;
			mid = post;
			post = post.next;
		}
		
		mid.next = pre;
		
		return mid;
	}

	public static ListNode ReverseList2(ListNode head) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return head;
		}

		ListNode ReverseHeadNode = ReverseList2(head.next);
		head.next = null;

		ListNode node = ReverseHeadNode;
		while (node.next != null) {
			node = node.next;
		}
		node.next = head;

		return ReverseHeadNode;
	}

}
