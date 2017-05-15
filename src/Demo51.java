/**
 * ����һ������A[0,1,...,n-1],�빹��һ������B[0,1,...,n-1],����B�е�Ԫ��B[i]=A[0]*A[1]*...*A[i-1]*A
 * [i+1]*...*A[n-1]������ʹ�ó�����
 * 
 */
public class Demo51 {
	public static void main(String[] args) {
		int[] ints = {1,2,3};
		int[] b = multiply(ints);
		for(int num: b){
			System.out.println(num);
		}
		
	}
	public static int[] multiply(int[] A) {
		int[] B = new int[A.length];
		if(B.length > 0){
			B[0] = 1;
			for (int i = 1; i < A.length; i++) {
				B[i] = B[i - 1] * A[i - 1];
			}
			int[] C = new int[A.length];
			C[A.length - 1] = 1;
			for (int i = A.length - 2; i >= 0; i--) {
				C[i] = C[i + 1] * A[i + 1];
			}
			for (int i = 0; i < A.length; i++) {
				B[i] = B[i] * C[i];
			}
		}
		return B;
	}
	
	/**
	 * ���ϸ��ŵ��㷨
	 */
	public static int[] multiply2(int[] A) {
		int[] B = new int[A.length];
		if(B.length > 0){
			B[0] = 1;
			for (int i = 1; i < A.length; i++) {
				B[i] = B[i - 1] * A[i - 1];
			}
			int temp = 1;
			for (int i = A.length - 2; i >= 0; i--) {
				temp *= A[i + 1];
				B[i] *= temp;
			}
		}
		return B;
	}
}
