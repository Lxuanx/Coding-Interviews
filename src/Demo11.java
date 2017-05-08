/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class Demo11 {

	public static void main(String[] args) {
		System.out.println(NumberOf1(100000));
	}

	public static int NumberOf1(int n) {
		//高效
		int count = 0;
		while (n != 0) {
			count++;
			n = n & (n - 1);
		}
		return count;
		//低效
//		int flag = 1;
//		int count = 0;
//		while (flag != 0) {
//			if ((flag & n) != 0) {
//				count++;
//			}
//			flag = flag << 1;
//		}
//		return count;
	}
	
}
