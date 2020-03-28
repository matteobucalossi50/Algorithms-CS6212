package proj3package;

import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

//You are given an array a[1..n] of positive numbers and an integer k. You have to produce an array b[1..n], such that: 
//(i) For each j, b[j] is 0 or 1, (ii) Array b has adjacent 1s at most k times, and (iii) sum_{j=1 to n} a[j]*b[j] is maximized. 
//For example, given an array [100, 300, 400, 50] and integer k = 1, the array b can be: [0 1 1 0], which maximizes the sum to be 700. 
//Or, given an array [10, 100, 300, 400, 50, 4500, 200, 30, 90] and k = 2, the array b can be [1, 0, 1, 1, 0, 1, 1, 0, 1] which maximizes the sum to 5500.

public class main {
	
	// return array from 0 but algo explained using indexes from 1
	// method for the base case when k = 0
	public static int base(int []a, int i) {
		
		// initialize new array for DP with n length
		int [] b = new int[i+1];

		// populating b array with max sum possible value
		for (int x =0; x < b.length; x++) {
			// return value 0 when n = 0
			if (x == 0 ) {
				b[x] = 0;
			}
			
			// return value at a[0] when n = 1
			else if (x == 1) {
				b[x] = a[0];
			}
			
			// return value max betw a[0] and a[1] when n = 2
			else if (x == 2) {
				b[x] = Math.max(a[0], a[1]);
			}
			
			// base RR: return max value betw these 2 options 
			else {
				b[x] = Math.max(b[x-2], b[x-3] + a[x-1]);
			}
		}	
		return b[i]; 

	}
	
	// DP method for general case k > 0
	public static int method(int [] a, int i, int j) {
		
		// call base case when k = 0
		if (j == 0) {
			return base(a, i);
		}
		
		// bottom-up method
		
		// initialize 2d array b with dims n and k
		int [][] b = new int[i+1][j+1];
		
		// populating 2d array b with max possible value
		for (int r = 0; r <= i; r++) {
			for (int c = 0; c <= j; c++) {
				
				// base case if n=0 
				if (r == 0) {
					b[r][c] = 0;
				}
				
				// if n=1
				else if (r == 1) {
					b[r][c] = a[0];					
				}
				
				// if n=2
				else if (r == 2) {
					b[r][c] = a[0]+a[1];
				}
				
				// if k=0 call base case method
				else if (c == 0) {
					b[r][c] = base(a, r);
				}
				
				// get max sum value as from recurrence relation: 
				// M(n,k)=max⁡{M(n-1,k),M(n-1,k-1)+a[n],M(n-2,k)+a[n]}
				else {
					b[r][c] = Math.max(Math.max(b[r-1][c], b[r-1][c-1] + a[r-1]), b[r-2][c] + a[r-1]);
				}
			}
		}

		//System.out.println(Arrays.deepToString(b));
		return b[i][j];
		
		//	call if wanted to use bottom-up method:
		//	return  Math.max(Math.max(method(a, i-1, j), method(a, i-1, j-1) + a[i]), method(a, i-2, j) + a[i]);

	}	
	
	// method to generate random arrays
	public static int [] generateRandomArray(int n){
		int [] list = new int [n];
		Random random = new Random();

		for (int i = 0; i < n; i++)
		{
			list[i]= random.nextInt(1000);
		}
		return list;
	}  

	public static void main (String[] args) {

		//int arrA[] = {10, 100, 300, 400, 50, 4500, 200, 30, 90};   //result max sum: 5500
		int arrA[] = generateRandomArray(100000);
		int k = arrA.length/10;
		
		// recording run time
		Instant start = Instant.now();
		
		// calling algorithm
		System.out.println(method(arrA, arrA.length, k));

		Instant finish = Instant.now();
		
		long timeElapsed = Duration.between(start, finish).toMillis();
		
		System.out.println("Time elapsed = " + timeElapsed);
		
		// time complexity: O(nk)

	}

}					
