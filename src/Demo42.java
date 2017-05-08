import java.util.ArrayList;

/**
 * ����һ����������������һ������S���������в�����������ʹ�����ǵĺ�������S������ж�����ֵĺ͵���S������������ĳ˻���С�ġ�
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
