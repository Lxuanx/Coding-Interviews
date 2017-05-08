/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,
 * 7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class Demo4 {

	public static void main(String[] args) {
		int[] pre = new int[] { 1, 2, 4, 7, 3, 5, 6, 8 };
		int[] in = new int[] { 4, 7, 2, 1, 5, 3, 8, 6 };
		// int[] pre = new int[] { 1, 2 };
		// int[] in = new int[] { 2, 1 };
		TreeNode rootTree = reConstructBinaryTree(pre, in);
		display(rootTree);
	}

	public static void display(TreeNode tn) {
		if (tn == null) {
			return;
		}
		display(tn.left);
		System.out.println(tn.val);
		display(tn.right);
	}

	public class Solution {
		public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
			TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in,
					0, in.length - 1);
			return root;
		}

		private TreeNode reConstructBinaryTree(int[] pre, int startPre,
				int endPre, int[] in, int startIn, int endIn) {
			if (startPre > endPre || startIn > endIn)
				return null;
			TreeNode root = new TreeNode(pre[startPre]);
			for (int i = startIn; i <= endIn; i++)
				if (in[i] == pre[startPre]) {
					root.left = reConstructBinaryTree(pre, startPre + 1,
							startPre + i - startIn, in, startIn, i - 1);
					root.right = reConstructBinaryTree(pre, i - startIn
							+ startPre + 1, endPre, in, i + 1, endIn);
				}
			return root;
		}
	}

	public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {

		if (pre.length != in.length || pre == null || in == null) {
			return null;
		}

		TreeNode rootNode = getRootNode(pre, 0, pre.length - 1, in, 0,
				pre.length - 1);

		return rootNode;
	}

	private static TreeNode getRootNode(int[] pre, int preStart, int preEnd,
			int[] in, int inStart, int inEnd) {
		if (preStart > preEnd && inStart > inEnd) {
			return null;
		}

		// 寻找前序序列中第一个元素, 即根节点
		TreeNode rootNode = new TreeNode(pre[preStart]);

		// 找到中序序列的左树节点数量, 方便划分中序序列为左中右
		int leftCount = findRootIndex(in, rootNode.val, inStart, inEnd);

		// 左继续走这个循环内容, 返回左树的根节点
		rootNode.left = getRootNode(pre, preStart + 1, preStart + leftCount,
				in, inStart, inStart + leftCount - 1);

		// 右继续走这个循环内容, 返回右树的根节点
		rootNode.right = getRootNode(pre, preStart + leftCount + 1, preEnd, in,
				preStart + leftCount + 1, inEnd);

		// 返回根节点
		return rootNode;
	}

	private static int findRootIndex(int[] in, int value, int start, int end) {
		int count = 0;
		for (int index = start; index <= end; index++) {
			if (in[index] == value) {
				break;
			}
			count++;
		}
		return count;
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
