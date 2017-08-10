/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 * 
 * @author Administrator
 * 
 */
public class Demo61 {
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		t4.left = t1;
		t4.right = t2;
		t2.left = t3;
		Demo61 demo61 = new Demo61();
		String serialize = demo61.Serialize(t4);
		System.out.println(serialize);
		TreeNode deserialize = demo61.Deserialize(serialize);
		
	}
	public static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	String Serialize(TreeNode root) {
		if (root == null) {
			return "#";
		}
		StringBuilder sb = new StringBuilder();
		Serialize(root, sb);
		return sb.toString();
	}

	void Serialize(TreeNode root, StringBuilder sb) {
		if (root == null) {
			sb.append(",#");
			return;
		}
		if(sb.length()!=0){
			sb.append(',');
		}
		sb.append(root.val);
		Serialize(root.left, sb);
		Serialize(root.right, sb);
	}

	int index = -1;

	TreeNode Deserialize(String str) {
		if (str == null || str.length() == 1) {
			return null;
		}
		String[] strs = str.split(",");
		return Deserialize(strs);
	}

	private TreeNode Deserialize(String[] strs) {
		index++;
		TreeNode treeNode = null;
		if (index < strs.length && !strs[index].equals("#")) {
			treeNode = new TreeNode(Integer.valueOf(strs[index]));
			treeNode.left = Deserialize(strs);
			treeNode.right = Deserialize(strs);
		}
		return treeNode;
	}
}
