/**
 * ����һ�Ŷ��������������ҳ����еĵ�k��Ľ�㡣���磬 5 / \ 3 7 /\ /\ 2 4 6 8 �У��������ֵ��С˳�����������ֵΪ4��
 * 
 * 
 */
public class Demo62 {
	public static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}

	int index = 0;

	TreeNode KthNode(TreeNode pRoot, int k) {
		if (pRoot == null) {
			return null;
		}

		TreeNode l = KthNode(pRoot.left, k);
		if (l != null) {
			return l;
		}

		index++;
		if (index == k) {
			return pRoot;
		}

		TreeNode r = KthNode(pRoot.right, k);
		if (r != null) {
			return r;
		}

		return null;
	}
}
