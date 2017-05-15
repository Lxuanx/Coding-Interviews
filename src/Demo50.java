/**
 * ��һ������Ϊn����������������ֶ���0��n-1�ķ�Χ�ڡ�
 * ������ĳЩ�������ظ��ģ�����֪���м����������ظ��ġ�Ҳ��֪��ÿ�������ظ����Ρ����ҳ�����������һ���ظ������֡�
 * ���磬������볤��Ϊ7������{2,3,1,0,2,5,3}����ô��Ӧ��������ظ�������2����3��
 * 
 */
public class Demo50 {
	// Parameters:
	// numbers: an array of integers
	// length: the length of array numbers
	// duplication: (Output) the duplicated number in the array number,length of
	// duplication array is 1,so using duplication[0] = ? in implementation;
	// Here duplication like pointor in C/C++, duplication[0] equal *duplication
	// in C/C++
	// ����Ҫ�ر�ע��~���������ظ���һ������ֵduplication[0]
	// Return value: true if the input is valid, and there are some duplications
	// in the array number otherwise false
	public boolean duplicate(int numbers[], int length, int[] duplication) {
		int index = 0;
		while (index < length) {
			if (numbers[index] == index) {
				index++;
			} else if (numbers[index] == numbers[numbers[index]]) {
				duplication[0] = numbers[index];
				return true;
			} else {
				swap(numbers, numbers[index], index);
			}
		}
		return false;
	}

	private void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}
