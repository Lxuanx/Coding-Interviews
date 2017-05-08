import java.util.Scanner;

public class WmDemo2 {
	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		int number = sn.nextInt();
		int[] prices = new int[number];
		int[] weights = new int[number];
		double[] priceWei = new double[number];
		for (int i = 0; i < number; i++) {
			prices[i] = sn.nextInt();
		}
		for (int i = 0; i < number; i++) {
			weights[i] = sn.nextInt();
			priceWei[i] = prices[i] / weights[i];
		}
		int currrentWeight = sn.nextInt();

		sortByPW(prices, weights, priceWei);
		
		int minWeight = getMinWeight(weights);
		int i = 0;
		int currentMoney = 0;
		while(currrentWeight >= minWeight && i < number){
			if(currrentWeight >= weights[i]) {
				currentMoney += prices[i];
				currrentWeight -= weights[i];
			}
			i++;
		}
		
		System.out.println(currentMoney);
	}

	private static int getMinWeight(int[] weights) {
		int min = Integer.MIN_VALUE;
		for(int i = 0; i < weights.length; i++) {
			if(min > weights[i]){
				min = weights[i];
			}
		}
		return min;
	}

	private static void sortByPW(int[] prices, int[] weights, double[] priceWei) {
		for (int i = 0; i < priceWei.length - 1; i++) {
			for (int j = i + 1; j < priceWei.length; j++) {
				if (priceWei[i] < priceWei[j]) {
					double tempD = priceWei[i];
					priceWei[i] = priceWei[j];
					priceWei[j] = tempD;

					int tempI = weights[i];
					weights[i] = weights[j];
					weights[j] = tempI;

					tempI = prices[i];
					prices[i] = prices[j];
					prices[j] = tempI;
				}
			}
		}
	}
}
