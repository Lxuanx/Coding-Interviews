/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
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
		// 如果temp有右树
		TreeLinkNode temp = pNode.right;
		if (temp != null) {
			while (temp.left != null) {
				temp = temp.left;
			}
			return temp;

		}
		 temp = pNode;
		// 假如它是父节点的左节点，则父节点是中序节点的后继节点 1
		TreeLinkNode parent = temp.next;
		if (parent != null && parent.left == temp) {
			return parent;
		}
		// 假如它是父节点的右节点，则父节点循环1步骤 2
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
		// 如果temp有右树
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
			// 假如它是父节点的左节点，则父节点是中序节点的后继节点 1
			if (parent.left == temp) {
				return parent;
			}
			// 假如它是父节点的右节点，则父节点循环1步骤 2
			temp = temp.next;
			parent = temp.next;
		}
		return null;
	}
}
