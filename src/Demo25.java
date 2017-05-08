/**
 * ����һ����������ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬һ��ָ����һ���ڵ㣬��һ������ָ��ָ������һ���ڵ㣩�����ؽ��Ϊ���ƺ��������head����ע�⣬
 * ���������벻Ҫ���ز����еĽڵ����ã�������������ֱ�ӷ��ؿգ�
 * 
 */
public class Demo25 {
	public static class RandomListNode {
		int label;
		RandomListNode next = null;
		RandomListNode random = null;

		RandomListNode(int label) {
			this.label = label;
		}
	}

	public static void main(String[] args) {
		RandomListNode node1 = new RandomListNode(1);
		RandomListNode node2 = new RandomListNode(2);
		RandomListNode node3 = new RandomListNode(3);
		RandomListNode node4 = new RandomListNode(4);
		RandomListNode node5 = new RandomListNode(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node1.random = node3;
		node2.random = node5;
		node3.random = null;
		node4.random = node2;
		node5.random = null;
		System.out.println(node1);
		RandomListNode clone = Clone(node1);
		while (clone != null) {
			System.out.println(clone.label);
			clone = clone.next;
		}
	}

	public static RandomListNode Clone(RandomListNode pHead) {
		if (pHead == null) {
			return null;
		}

		RandomListNode currentNode = pHead;
		while (currentNode != null) {
			RandomListNode node = new RandomListNode(currentNode.label);
			node.next = currentNode.next;
			currentNode.next = node;
			currentNode = node.next;
		}

		currentNode = pHead;
		while (currentNode != null) {
			if (currentNode.random != null) {
				currentNode.next.random = currentNode.random.next;
			}
			currentNode = currentNode.next.next;
		}

		currentNode = pHead;
		RandomListNode newCurrentHead = pHead.next;
		RandomListNode newHead = pHead.next;
		while (currentNode != null) {
			currentNode.next = currentNode.next.next;
			if (newCurrentHead.next != null) {
				newCurrentHead.next = newCurrentHead.next.next;
			}
			currentNode = currentNode.next;
			newCurrentHead = newCurrentHead.next;
		}
		return newHead;
	}
}
