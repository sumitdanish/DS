package com.mypractice.org.HackeRrank;

import java.io.File;
import java.util.Scanner;

public class MarkAndToys {

    /**
     * @param args
     */
    public static void main(String[] args) {

	try {
	    Scanner sc = new Scanner(new File("arr.txt"));
	    // int sum = sc.nextInt();
	    int n = sc.nextInt();
	    int[] ar = new int[n];
	    for (int i = 0; i < n; i++) {
		ar[i] = sc.nextInt();
	    }
	    QuickSort q = new QuickSort(ar);
	    q.quickSort(0, n - 1);
	    int[] a = q.getQuick();
	    int result = 0;
	    int i = 0;
	    // for(int e:a)
	    // {
	    // System.out.print(e+",");
	    // }
	    // System.out.println();
	    // for(int s : a)
	    // {
	    // result+=s;
	    // if(result>sum)
	    // {
	    // break;
	    // }
	    // i++;
	    // }
	    // System.out.println(i);
	} catch (Exception ex) {
	    ex.printStackTrace();
	}

    }

}

class QuickSort {
    private int[] quick;

    public QuickSort(int[] quick) {
	this.quick = quick;
    }

    public int[] getQuick() {
	return quick;
    }

    public void setQuick(int[] quick) {
	this.quick = quick;
    }

    public void quickSort(int len, int high) {
	try {
	    int i = len;
	    int j = high;
	    int p = this.quick[high];
	    while (i <= j) {
		while (p > this.quick[i]) {
		    i++;
		}
		while (p < this.quick[j]) {
		    j--;
		}
		if (i <= j) {
		    int temp = this.quick[i];
		    this.quick[i] = this.quick[j];
		    this.quick[j] = temp;
		    i++;
		    j--;
		}
		if (i < high) {
		    quickSort(i, high);
		}
		if (j > len) {
		    quickSort(len, j);
		}
	    }
	    int[] a = getQuick();
	    for (int e : a) {
		System.out.print(e + ",");
	    }
	    System.out.println();
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
    }
}