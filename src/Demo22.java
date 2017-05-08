import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class Demo22 {
	public static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(5);
		TreeNode treeNode1 = new TreeNode(2);
		TreeNode treeNode2 = new TreeNode(3);
		TreeNode treeNode3 = new TreeNode(4);
		TreeNode treeNode4 = new TreeNode(5);
		treeNode.left = treeNode1;
		treeNode1.left = treeNode2;
		treeNode.right = treeNode3;
		treeNode3.left = treeNode4;
		ArrayList<Integer> al = PrintFromTopToBottom(treeNode);
		System.out.println(al);
	}

	public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		if (root == null) {
			return al;
		}

		LinkedBlockingQueue<TreeNode> queue = new LinkedBlockingQueue<>();
		queue.offer(root);
		while (queue.size() != 0) {
			TreeNode node = queue.poll();
			al.add(node.val);
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
		}

		return al;
	}
}
