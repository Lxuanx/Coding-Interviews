/**
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * 
 */
public class Demo38 {

	public static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(1);
		System.out.println(TreeDepth(treeNode));
	}

	public static int max = 0;

	public static int TreeDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(TreeDepth(root.left) + 1, TreeDepth(root.right) +1);
	}

	private static void getTreeDepth(TreeNode root, int length) {
		if (root.left == null && root.right == null) {
			if (length + 1 > max) {
				max = length + 1;
			}
			return;
		}
		if (root.left != null) {
			getTreeDepth(root.left, length + 1);
		}
		if (root.right != null) {
			getTreeDepth(root.right, length + 1);
		}
	}
}
