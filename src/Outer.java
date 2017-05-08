import java.util.ArrayList;

public class Outer {

	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		al.add("fasdf");
		System.out.println(al.size());
//		al.trimToSize();
		Object[] array = al.toArray();
		System.out.println(array.length);
	}

	private static void testInterClass() {
		final Outer outer2 = new Outer();
		class inter{
			
		}
		inter inter = new inter(){
			private void demo1() {
			}
			
		};
		inter inter2 = new inter(){
			private void demo2() {
			}
		};
	}

	/**
	 * 研究线程wait方法
	 */
	private static void demo2() {
		Thread thread = new Thread() {
			@Override
			public synchronized void run() {
				try {
					wait(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				for (int i = 0; i < 1000; i++) {
					try {
						Thread.sleep(2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(i);
				}
			}
		};
		thread.start();
		try {
			Thread.sleep(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		synchronized (thread) {
			thread.notify();
		}
	}

	/**
	 * 研究byte变量问题
	 */
	private static void demo1() {
		byte b1 = 1, b2 = 2, b3, b6;
		final byte b4 = 4, b5 = 6;
		b6 = b4 + b5;
		b3 = (byte) (b1 + b2);
		System.out.println(b3 + " " + b6);
	}

}
