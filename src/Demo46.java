/**
 * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:首先,
 * 让小朋友们围成一个大圈
 * 。然后,他随机指定一个数m,让编号为0的小朋友开始报数。每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中
 * ,从他的下一个小朋友开始
 * ,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦
 * !!^_^)。请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 * 
 */
public class Demo46 {
	public static void main(String[] args) {
		System.out.println(LastRemaining_Solution(3, 3));
	}

	public static int LastRemaining_Solution(int n, int m) {
		if (n <= 0 || m <= 0) {
			return -1;
		}
		int[] ints = new int[n];
		int index = 0;
		int step = m;
		int currentPersonCount = n;
		while (currentPersonCount != 1) {
			while (ints[index] == -1) {
				index = (index + 1) % n;
			}
			step--;
			if (step == 0) {
				ints[index] = -1;
				currentPersonCount--;
				step = m;
			}
			index = (index + 1) % n;
		}
		for (int i = 0; i < ints.length; i++) {
			if (ints[i] == 0) {
				return i;
			}
		}
		return 0;
	}

	/**
	 * 运行时间：452ms占用内存：528k
	 */
	public static int LastRemaining_Solution1(int n, int m) {
		if (n <= 0 || m <= 0) {
			return 0;
		}
		boolean[] isLive = new boolean[n];
		for (int i = 0; i < isLive.length; i++) {
			isLive[i] = true;
		}
		int index = 0;
		int current = m;
		int currentCount = n;
		while (currentCount != 1) {
			while (isLive[index] == false) {
				index = (index + 1) % n;
			}
			current--;
			if (current == 0) {
				isLive[index] = false;
				currentCount--;
				current = m;
			}
			index = (index + 1) % n;
		}
		for (int i = 0; i < isLive.length; i++) {
			if (isLive[i] == true) {
				return i;
			}
		}
		return 0;
	}
}
