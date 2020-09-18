/**
 * SAMYUKTA SREEKANTH
 * R00170779
 * SDH2C
 */

/**
 * Reference 1: Dynamic Programming.pdf 
 * 				Pseudo Code of the bottom-up (iterative) approach slide 127
 */

import java.util.Scanner;

public class RobotMoving {
	//n can be changed to any number
	private static int n = 10;
	private static float[][] T_matrix = new float[n+1][n+1];
	private static float cost;
	

	//finding the minimum of the 3 costs and returning it
	private static float minimum_of_them_all(float a_rht , float b_btm, float d_diag) {
		return Math.min(a_rht, Math.min(b_btm, d_diag));
	}
	

	private static float minCost(int n, float rht, float dwn, float diag) {

		
		T_matrix[0][0]=0;
		
		//Matrix Edges cost 
		
		// ---->
		// ####
		// ####
		// ####
		// ####
		for(int i=1; i<= n; i++) {
			T_matrix[0][i] = T_matrix[0][i-1] + rht;
		}
		
		// | ####
		// | ####
		// | ####
		// v ####
		for(int i=1; i<=n ; i++) {
			T_matrix[i][0] = T_matrix[i-1][0] + dwn;
		}

		
		// ####
		// ####
		// ####
		// ####
		// ---->
		for(int i=1; i<=n ; i++) {
			T_matrix[i][0] = T_matrix[i-1][0] + dwn;

			T_matrix[n-1][i] = T_matrix[n-1][i-1] + rht;
		}

		
		// #### |
		// #### |
		// #### |
		// #### v
		for(int i=1; i<= n; i++) {
			T_matrix[0][i] = T_matrix[0][i-1] + rht;
			T_matrix[i][n-1] = T_matrix[i-1][n-1] + dwn;

		}

		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				//everything but the edges
				
				//considering everything but the first row and first column
				if(!(i==0 ||  j==0 )) {
					float a_rht = T_matrix[i][j-1] + rht;
					float b_btm = T_matrix[i-1][j] + dwn;
					float d_diag = T_matrix[i-1][j-1] + diag;
					//implementing the minimum_of_them_all method
					T_matrix[i][j] = minimum_of_them_all(a_rht, b_btm, d_diag );
					cost = T_matrix[i][j];
					
				}
			}
		}
		 

		//printing the matrix
		for(int i=0; i<n; i++) {
			for(int j=0; j< n; j++) {
				//formatting it to two decimal places
				System.out.print(String.format("%.02f", T_matrix[i][j]) + "\t");
			}
			System.out.println();
		}

		return cost;
	}
	

    public static void main(String args[]) 
    { 
    
    	System.out.println("COST1");
        float rht1 = (float) 1.10;
        float dwn1 = (float) 1.30;
        float diag1 = (float) 2.50;
        float minCost1 = minCost(n , rht1, dwn1, diag1);

        System.out.println("the minimum cost is " + String.format("%.02f", minCost1));
        

        System.out.println("\nCOST2");
        float rht2 = (float) 1.50;
        float dwn2 = (float) 1.20;
        float diag2 = (float) 2.30;
        float minCost2 = minCost(n , rht2, dwn2, diag2);
        System.out.println("the minimum cost is " + String.format("%.02f", minCost2));
        

    }

}
