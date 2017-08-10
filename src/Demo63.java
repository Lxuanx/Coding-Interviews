import java.util.Comparator;
import java.util.TreeSet;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，
 * 那么中位数就是所有数值排序之后中间两个数的平均值。
 * 
 */
public class Demo63 {

	public static void main(String[] args) {
		Demo63 demo63 = new Demo63();
		//5,2,3,4,1,6,7,0,8
		demo63.Insert(5);
		demo63.Insert(2);
		demo63.Insert(3);
		demo63.Insert(4);
		demo63.Insert(1);
		demo63.Insert(6);
		demo63.Insert(7);
		demo63.Insert(0);
		demo63.Insert(8);
		System.out.println(demo63.GetMedian());
		System.out.println(demo63.bigHeap);
		System.out.println(demo63.smallHeap);
	}

	TreeSet<Integer> smallHeap = new TreeSet<>(new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			int dif = o1 - o2;
			return dif != 0 ? dif : 1;
		}
	});
	
	TreeSet<Integer> bigHeap = new TreeSet<>(new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			int dif = o1 - o2;
			return dif != 0 ? -dif : 1;
		}
	});

	public void Insert(Integer num) {
		if (smallHeap.size() == 0) {
			smallHeap.add(num);
			return;
		}

		if (bigHeap.size() < smallHeap.size()) {
			Integer bigMaxSmall = smallHeap.pollFirst(); // 小堆最小的那个
			// 大数中最小的那个还比添加进来的树大
			if (bigMaxSmall > num) {
				smallHeap.add(bigMaxSmall);
				bigHeap.add(num);
			} else {
				smallHeap.add(num);
				bigHeap.add(bigMaxSmall);
			}
		} else {
			Integer smallMaxBig = bigHeap.first();
			if (smallMaxBig < num) {
				smallHeap.add(num);
			} else {
				smallHeap.add(bigHeap.pollFirst());
				bigHeap.add(num);
			}
		}
	}

	public Double GetMedian() {
		if (bigHeap.size() < smallHeap.size()) {
			return (double) smallHeap.first();
		} else {
			return ((double) smallHeap.first() + bigHeap.first()) / 2;
		}
	}
}
