import java.util.ArrayList;
import java.util.Stack;

/**
 * ��ʵ��һ����������֮���δ�ӡ������������һ�а��մ����ҵ�˳���ӡ���ڶ��㰴�մ��������˳���ӡ�������а��մ����ҵ�˳���ӡ���������Դ����ơ�
 * 
 */
public class Demo59 {
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
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		Stack<TreeNode> current = s1;
		Stack<TreeNode> next = s2;

		ArrayList<Integer> al = null;
		current.add(pRoot);

		while (current.size() != 0 || next.size() != 0) {
			if (al == null) {
				al = new ArrayList<Integer>();
			}
			TreeNode node = current.pop();
			if (current == s1) {
				if (node.left != null) {
					next.add(node.left);
				}
				if (node.right != null) {
					next.add(node.right);
				}
			} else {
				if (node.right != null) {
					next.add(node.right);
				}
				if (node.left != null) {
					next.add(node.left);
				}
			}
			al.add(node.val);

			if (current.size() == 0) {
				als.add(al);
				al = null;
				Stack<TreeNode> temp = current;
				current = next;
				next = temp;
			}
		}

		return als;
	}
}
