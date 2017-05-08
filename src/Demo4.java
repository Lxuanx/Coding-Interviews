/**
 * ����ĳ��������ǰ���������������Ľ�������ؽ����ö����������������ǰ���������������Ľ���ж������ظ������֡���������ǰ���������{1,2,4,
 * 7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}�����ؽ������������ء�
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

		// Ѱ��ǰ�������е�һ��Ԫ��, �����ڵ�
		TreeNode rootNode = new TreeNode(pre[preStart]);

		// �ҵ��������е������ڵ�����, ���㻮����������Ϊ������
		int leftCount = findRootIndex(in, rootNode.val, inStart, inEnd);

		// ����������ѭ������, ���������ĸ��ڵ�
		rootNode.left = getRootNode(pre, preStart + 1, preStart + leftCount,
				in, inStart, inStart + leftCount - 1);

		// �Ҽ��������ѭ������, ���������ĸ��ڵ�
		rootNode.right = getRootNode(pre, preStart + leftCount + 1, preEnd, in,
				preStart + leftCount + 1, inEnd);

		// ���ظ��ڵ�
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
