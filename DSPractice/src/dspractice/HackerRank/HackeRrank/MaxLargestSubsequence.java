package com.mypractice.org.HackeRrank;

import java.io.File;
import java.util.Scanner;

public class MaxLargestSubsequence {

    /**
     * @param args
     */
    public static void main(String[] args) {

	try {
	    MaxLargestSubsequence maxLcs = new MaxLargestSubsequence();
	    Scanner sc = new Scanner(new File("lcs.txt"));
	    int n = sc.nextInt();
	    int[] a = new int[n];
	    int i = 0;
	    while (sc.hasNext()) {
		a[i] = sc.nextInt();
		i++;
	    }
	    int lcs = maxLcs.getlcs(a, n, 0);
	    System.out.println(lcs);
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
    }

    private int getlcs(int[] a, int i, int max_so_far) {
	try {
	    int rest = 1;
	    if (i == 1) {
		return 1;
	    }
	    int max = Integer.MIN_VALUE;
	    for (int j = 1; j < i; j++) {
		rest = getlcs(a, j, max_so_far);
		if (a[j - 1] < a[i - 1] && rest + 1 > max) {
		    max = rest + 1;
		}
	    }
	    if (max_so_far < max) {
		max_so_far = max;
	    }
	    return max_so_far;
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
	return -1;
    }

    private int getLCS1(int[] a) {
	try {
	    int[] lcs = new int[a.length];
	    for (int i = 0; i < a.length; i++) {
		lcs[i] = 1;
	    }
	    for (int i = 1; i < a.length; i++) {
		// lcs[i]=1;
		for (int j = 0; j <= i; j++) {
		    if (a[i] > a[j] && lcs[i] <= lcs[j] + 1) {
			lcs[i] = lcs[j] + 1;
		    }
		}
		// System.out.print(lcs[i]+",");
	    }
	    int max = 0;
	    for (int i = 0; i < a.length; i++) {
		if (max <= lcs[i]) {
		    max = lcs[i];
		}
	    }
	    return max;
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
	return -1;
    }

}
