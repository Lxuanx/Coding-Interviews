/**
 * �������ö�����A��B���ж�B�ǲ���A���ӽṹ����ps������Լ��������������һ�������ӽṹ��
 * 
 */
public class Demo17 {
	public static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;
		}

	}

	public static void main(String[] args) {

	}

	public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
		if (root2 == null) {
			return false;
		}
		if (root1 == null) {
			return false;
		}
		boolean result = false;
		if (root1.val == root2.val) {
			result = isSubTree(root1, root2);
		}
		if (!result) {
			result = HasSubtree(root1.left, root2);
		}
		if (!result) {
			result = HasSubtree(root1.right, root2);
		}
		return result;
	}

	private static boolean isSubTree(TreeNode root1, TreeNode root2) {
		if (root2 == null) {
			return true;
		}
		if (root1 == null) {
			return false;
		}

		if (root1.val == root2.val) {
			return isSubTree(root1.left, root2.left)
					&& isSubTree(root1.right, root2.right);
		} else {
			return false;
		}
	}
}
