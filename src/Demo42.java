import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 
 */
public class Demo42 {
	public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		if(array == null || array.length < 2) {
			return al;
		}
		int i = 0;
		int j = array.length - 1;
		while(i < j){
			if(array[i] + array[j] == sum) {
				al.add(array[i]);
				al.add(array[j]);
				break;
			} else if(array[i] + array[j] > sum) {
				j--;
			} else {
				i++;
			}
		}
		return al;
	}
}
