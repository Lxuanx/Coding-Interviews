
public class Demo39 {
	public static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	public static boolean IsBalanced_Solution(TreeNode root) {
		if (root == null) {
			return true;
		}
		int leftLength = getTreeDepth(root.left);
		int rightLength = getTreeDepth(root.right);
		int differ = leftLength - rightLength;
		boolean current = (differ <= 1 && differ >= -1);
		return current && IsBalanced_Solution(root.left)
				&& IsBalanced_Solution(root.right);
	}

	private static int getTreeDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(getTreeDepth(root.left) + 1,
				getTreeDepth(root.right) + 1);
	}
}
