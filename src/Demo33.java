public class Demo33 {

	public static void main(String[] args) {
		System.out.println(GetUglyNumber_Solution(10));
	}

	public static int GetUglyNumber_Solution(int index) {
		if(index == 0){
			return 0;
		}
		int[] uglyNumbers = new int[index];
		int ugly2 = 0, ugly3 = 0, ugly5 = 0;
		int i = 0;
		uglyNumbers[i] = 1;
		while (i < index - 1) {
			int temp = uglyNumbers[i];
			while (temp >= uglyNumbers[ugly2] * 2) {
				ugly2++;
			}
			while (temp >= uglyNumbers[ugly3] * 3) {
				ugly3++;
			}
			while (temp >= uglyNumbers[ugly5] * 5) {
				ugly5++;
			}
			int min = Math.min(
					Math.min(uglyNumbers[ugly2] * 2, uglyNumbers[ugly3] * 3),
					uglyNumbers[ugly5] * 5);
			uglyNumbers[++i] = min;
		}
		
		return uglyNumbers[i];
	}
}
