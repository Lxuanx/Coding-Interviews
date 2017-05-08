/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 
 */
public class Demo26 {

	public static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	public TreeNode realHead = null;
	public TreeNode head = null;

	public TreeNode Convert(TreeNode pRootOfTree) {
		Convert1(pRootOfTree);
		return realHead;
	}

	public TreeNode Convert1(TreeNode pRootOfTree) {
		if (pRootOfTree == null) {
			return null;
		}
		Convert(pRootOfTree.left);
		if (head == null) {
			head = pRootOfTree;
			realHead = pRootOfTree;
		} else {
			head.right = pRootOfTree;
			pRootOfTree.left = head;
			head = pRootOfTree;
		}
		Convert(pRootOfTree.right);
		return pRootOfTree;
	}
}
