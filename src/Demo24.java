import java.util.ArrayList;

/*
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */

public class Demo24 {
	public static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(10);
		TreeNode treeNode1 = new TreeNode(5);
		TreeNode treeNode2 = new TreeNode(7);
		TreeNode treeNode3 = new TreeNode(4);
		TreeNode treeNode4 = new TreeNode(12);
		treeNode.left = treeNode1;
		treeNode1.left = treeNode2;
		treeNode1.right = treeNode3;
		treeNode.right = treeNode4;
		ArrayList<ArrayList<Integer>> findPath = FindPath(treeNode, 22);
		System.out.println(findPath);

	}

	public static ArrayList<ArrayList<Integer>> pathList = new ArrayList<ArrayList<Integer>>();
	public static ArrayList<Integer> al = new ArrayList<Integer>();

	public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root,
			int target) {
		if (root == null) {
			return pathList;
		}
		target -= root.val;
		al.add(root.val);
		if (target == 0 && root.left == null && root.right == null) {
			pathList.add(new ArrayList<Integer>(al));
		}
		FindPath(root.left, target);
		FindPath(root.right, target);
		al.remove(al.size() - 1);
		return pathList;
	}

	private static void findPath(TreeNode root, int sum, int target, int index) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			if (sum + root.val == target) {
				ArrayList<Integer> newList = new ArrayList<Integer>();
				for (int i : al) {
					newList.add(i);
				}
				newList.add(root.val);
				pathList.add(newList);
				return;
			}
		}
		al.add(root.val);
		findPath(root.left, sum + root.val, target, index + 1);
		findPath(root.right, sum + root.val, target, index + 1);
		al.remove(index);
	}
}
