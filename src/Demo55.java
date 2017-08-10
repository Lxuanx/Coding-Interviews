/**
 * 一个链表中包含环，请找出该链表的环的入口结点。
 * 
 * @author Administrator
 * 
 */
public class Demo55 {

	public static class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public ListNode EntryNodeOfLoop1(ListNode pHead) {
		if(pHead == null){
			return null;
		}
		
		ListNode slowp = pHead, fastp = pHead;
		while(slowp != null && fastp != null){
			slowp = slowp.next;
			fastp = fastp.next;
			if(fastp != null){
				fastp = fastp.next;
			}
			if(fastp == slowp) {
				break;
			}
		}
		if(fastp == null) {
			return null;
		}
		
		ListNode tempNode = fastp.next;
		int sweepNum = 1;
		while(tempNode != fastp){
			tempNode = tempNode.next;
			sweepNum++;
		}

		slowp = pHead;
		fastp = pHead;
		for(int i = 0; i < sweepNum; i++){
			fastp = fastp.next;
		}
		
		while(fastp != slowp){
			fastp = fastp.next;			
			slowp = slowp.next;			
		}
		
		return slowp;
	}
	
	public ListNode EntryNodeOfLoop(ListNode pHead) {
		if(pHead == null){
			return null;
		}
		
		ListNode slowp = pHead, fastp = pHead;
		while(slowp != null && fastp != null){
			slowp = slowp.next;
			fastp = fastp.next;
			if(fastp != null){
				fastp = fastp.next;
			}
			if(fastp == slowp) {
				break;
			}
		}
		if(fastp == null) {
			return null;
		}
		
		slowp = pHead;
		while(fastp != slowp){
			fastp = fastp.next;			
			slowp = slowp.next;
		}
		
		return slowp;
	}
}
