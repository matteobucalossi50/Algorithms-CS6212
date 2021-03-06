package proj1package;

import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

// pretty random algorithm running in O(n^3)
public class Project1 {

	public static void main (String[] args) {

// do not run n < 20!

		int n = 100000;
//
//		int n1 = 100;
//		int n2 = 10000;
//		int n3 = 100000;

		Instant start = Instant.now();
		
		// call algorithm
		method2(n);

		Instant finish = Instant.now();

		long timeElapsed = Duration.between(start, finish).toMillis();

		System.out.println("Time elapsed = " + timeElapsed);

	}

	public static void method(int n) {

		int[] a = new int[n];
		int[] b = new int[n];
		int[] c = new int[n];

		for (int m = 0; m < n; m++) {
			a[m] = m + 3;
			b[m] = m + 6;
			c[m] = m + 9;
		}

		int j = 0;
		double sum = 0;
		int k = 0;

		for (int i = 1; i < n; i++) {
			j = i;
			while (j < n) {
				k = j;
				while (k < n) {
					sum += a[i]*b[i]*c[i];
					k += Math.log(Math.log(n));
					System.out.println(k);
				}

			j += Math.log(j + 10);
			System.out.println(j);
		}
			System.out.println(i);
	}
	}
	
	public static void method2(int n) {

		int[] a = new int[n];
		int[] b = new int[n];

		for (int m = 0; m < n; m++) {
			a[m] = m + 3;
			b[m] = m + 6;
		}

		int j = 1;
		double sum = 0;
		int k = 0;

		while (j<n) {
			k = j;
			while (j < n) {
				sum += a[k]*b[k];
				k += k;
				System.out.println(k);
			}

			j += 0.25*n;
			System.out.println(j);
		}
	}


}
