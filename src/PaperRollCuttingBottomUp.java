/**
 * SAMYUKTA SREEKANTH
 * R00170779
 * SDH2C
 */

/**
 * Reference 1: Dynamic Programming.pdf 
 * 				pseudo code: 'Code extension' slide 105
 */
/**
 * Reference 2: RodCuttingTopDown.java
 */


import java.util.Arrays;
import java.lang.Math;

public class PaperRollCuttingBottomUp {
	
	//n can be changed to any number
	private static int rodLength = 1;
	
//	private static double prices[] = { 0, 1.2, 3, 5.8, 0, 10.1 };
	
	private static double prices[];
	private static int cuts[] = new int[rodLength + 1];
	//optimal price
	private static double r[] = new double[rodLength + 1];

	//n --> length
	public static double BottonUpCutRod(double[] p, int n) {
		//2.Size 0 has revenue 0
		r[0] = 0;
		// 3.for j = 1 to n
		// Increment the problem size by 1 each time
		for (int j = 1; j <= n; j++) {
			// 4. q = - infinity
			double q = Integer.MIN_VALUE;
			// 5.for i = 1 to j
			// This loop gets the maximum among all possible cuts
			for (int i = 1; i <= j; i++) {
				// 6. q = max(q, p[i]+ r[j - i])
//				if(i == 4) {
//					continue;
//				}
//				if (j - i >= 0) {
//					q = Math.max(q, p[i] + r[j - i]);
//					cuts[j] = i;
//				}
				
				if(q <  p[i] + r[j - i]) {
					q =  p[i] + r[j - i];
					cuts[j] = i;
				}
			}
			r[j] = q;
		}
		
		return r[n];
	}

	public static void main(String[] args) {
		
		double prices[];
		if(rodLength > 5)
		{
			prices = new double[rodLength + 1];
		}
		
		else
		{
			prices = new double[6];

		}
		prices[0] = 0;
		prices[1] = 1.2;
		prices[2] = 3;
		prices[3] = 5.8;
		prices[4] = 0;
		prices[5] = 10.1;
		
		System.out.println("\nBEST PRICE= " + BottonUpCutRod(prices, rodLength) + " for a rod of length " + rodLength);
		while (rodLength > 0) {
			int item = cuts[rodLength];
			System.out.println("a piece of length " + item + " with price " + prices[item] );
			rodLength -= item;
		}
	}
}

