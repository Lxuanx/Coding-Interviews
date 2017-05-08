/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 
 */
public class Demo10 {
	public static void main(String[] args) {

	}

	public static int RectCover(int target) {
		if (target <= 0) {
			return 0;
		} else if (target == 1 || target == 2) {
			return target;
		}
		int[] ints = new int[target + 1];
		ints[1] = 1;
		ints[2] = 2;
		for (int i = 3; i < target + 1; i++) {
			ints[i] = ints[i - 1] + ints[i - 2];
		}
		return ints[target];
	}
}
