/**
 * ����һ�������������е�һ����㣬���ҳ��������˳�����һ����㲢�ҷ��ء�ע�⣬���еĽ�㲻�����������ӽ�㣬ͬʱ����ָ�򸸽���ָ�롣
 * 
 */
public class Demo57 {
	public static class TreeLinkNode {
		int val;
		TreeLinkNode left = null;
		TreeLinkNode right = null;
		TreeLinkNode next = null;

		TreeLinkNode(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {

	}

	public TreeLinkNode GetNext1(TreeLinkNode pNode) {
		if (pNode == null) {
			return null;
		}
		// ���temp������
		TreeLinkNode temp = pNode.right;
		if (temp != null) {
			while (temp.left != null) {
				temp = temp.left;
			}
			return temp;

		}
		 temp = pNode;
		// �������Ǹ��ڵ����ڵ㣬�򸸽ڵ�������ڵ�ĺ�̽ڵ� 1
		TreeLinkNode parent = temp.next;
		if (parent != null && parent.left == temp) {
			return parent;
		}
		// �������Ǹ��ڵ���ҽڵ㣬�򸸽ڵ�ѭ��1���� 2
		while (parent != null && parent.left != temp) {
			temp = temp.next;
			parent = temp.next;

			if (parent != null && parent.left == temp) {
				return parent;
			}
		}
		return null;
	}
	
	public TreeLinkNode GetNext(TreeLinkNode pNode) {
		if (pNode == null) {
			return null;
		}
		// ���temp������
		TreeLinkNode temp = pNode.right;
		if (temp != null) {
			while (temp.left != null) {
				temp = temp.left;
			}
			return temp;
			
		}
		temp = pNode;
		TreeLinkNode parent = temp.next;
		while (parent != null) {
			// �������Ǹ��ڵ����ڵ㣬�򸸽ڵ�������ڵ�ĺ�̽ڵ� 1
			if (parent.left == temp) {
				return parent;
			}
			// �������Ǹ��ڵ���ҽڵ㣬�򸸽ڵ�ѭ��1���� 2
			temp = temp.next;
			parent = temp.next;
		}
		return null;
	}
}
