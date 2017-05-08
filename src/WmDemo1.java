import java.util.Arrays;
import java.util.Scanner;

public class WmDemo1 {
	public static class Data {
		public int money;
		public int count;
	}

	public static void main(String args[]) {
		Scanner sn = new Scanner(System.in);
		String str = sn.next();
		int money = sn.nextInt();
		String[] numStr = str.split(",");
		int[] ints = new int[numStr.length];
		int[] counts = new int[numStr.length];
		for (int i = 0; i < numStr.length; i++) {
			Integer num = Integer.valueOf(numStr[i]);
			ints[i] = num;
		}

		sort(ints);

		int i = 0;
		int lastIndex = ints.length - 1;
		Data data = new Data();
		data.money = money;
		digui(ints, 0, lastIndex, data);

		if (data.count > 0 && data.money == 0) {
			System.out.println(data.count);
		} else {
			System.out.println(-1);
		}
	}

	private static void digui(int[] ints, int start, int lastIndex, Data data) {
		if (start <= lastIndex) {
			int count = data.money / ints[start];
			for (int i = 0; i <= count; i++) {
				data.money -= count * ints[start];
				digui(ints, start - 1, lastIndex, data);
				data.money += count * ints[start];
			}
		}
	}

	private static void sort(int[] ints) {
		for (int i = 0; i < ints.length - 1; i++) {
			for (int j = i + 1; j < ints.length; j++) {
				if (ints[i] < ints[j]) {
					int temp = ints[i];
					ints[i] = ints[j];
					ints[j] = temp;
				}
			}
		}
	}
}