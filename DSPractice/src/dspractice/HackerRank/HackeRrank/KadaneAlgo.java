package com.mypractice.org.HackeRrank;

import java.io.File;
import java.util.Scanner;

public class KadaneAlgo {

    /**
     * @param args
     */
    public static void main(String[] args) {

	try {
	    KadaneAlgo kadane = new KadaneAlgo();
	    Scanner sc = new Scanner(new File("kadane.txt"));
	    int n = sc.nextInt();
	    for (int i = 0; i < n; i++) {
		int i1 = 0;
		int n1 = sc.nextInt();
		int[] a1 = new int[n1];
		while (i1 < n1) {
		    a1[i1] = Integer.parseInt(sc.next());
		    i1++;
		}
		// int maxSum1 = kadane.maxSumKadane(a1,n);
		System.out.println(kadane.maxSumKadane(a1, n1) + " "
			+ kadane.getMaxNonContiguous(a1, n1));
	    }
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
    }

    private int maxSumKadane(int[] a, int n) {
	try {
	    int max_end = 0;
	    int max_so_far = 0;
	    for (int i = 0; i < n; i++) {
		max_end += a[i];
		if (max_end < 0) {
		    max_end = 0;
		}
		if (max_end > max_so_far) {
		    max_so_far = max_end;
		}
	    }
	    return max_so_far;
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
	return Integer.MIN_VALUE;
    }

    private int getMaxNonContiguous(int[] a, int n) {
	try {
	    int max_end = 0;
	    int max_so_far = 0;
	    for (int i = 0; i < n; i++) {
		if (a[i] > 0) {
		    max_end += a[i];
		    if (max_end < 0) {
			max_end = 0;
		    }
		    if (max_end > max_so_far) {
			max_so_far = max_end;
		    }
		}
	    }
	    return max_so_far;
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
	return -1;
    }
}
