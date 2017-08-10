import java.util.ArrayList;
import java.util.LinkedList;

public class Demo60 {

	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		if (pRoot == null) {
			return new ArrayList<ArrayList<Integer>>();
		}
		ArrayList<ArrayList<Integer>> als = new ArrayList<ArrayList<Integer>>();
		LinkedList<TreeNode> list1 = new LinkedList<>();
		LinkedList<TreeNode> list2 = new LinkedList<>();
		LinkedList<TreeNode> current = list1;
		LinkedList<TreeNode> next = list2;

		ArrayList<Integer> al = null;
		list1.add(pRoot);

		while (current.size() != 0) {
			if (al == null) {
				al = new ArrayList<Integer>();
			}
			TreeNode node = current.pollFirst();
			if (node.left != null) {
				next.addLast(node.left);
			}
			if (node.right != null) {
				next.addLast(node.right);
			}
			al.add(node.val);

			if (current.size() == 0) {
				als.add(al);
				al = null;
				LinkedList<TreeNode> temp = current;
				current = next;
				next = temp;
			}
		}

		return als;
	}
}
