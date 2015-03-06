package com.mypractice.org.HackeRrank;

import java.io.File;
import java.util.Scanner;

public class LCSInTwoArray {

    /**
     * @param args
     */
    public static void main(String[] args) {
	try{
	    LCSInTwoArray lcs = new LCSInTwoArray();
	    Scanner sc = new Scanner(new File("lcs1.txt"));
	    int i=0;
	    int n1 = sc.nextInt();
	    int n2 = sc.nextInt();
	    int[] x = new int[n2];
	    int[] y = new int[n1];
	    while(sc.hasNext()&&i<n1){
		y[i]=sc.nextInt();
		i++;
	    }
	    i=0;
	    while(sc.hasNext()&&i<n2){
		x[i]=sc.nextInt();
		i++;
	    }
	    int len = lcs.LCS(x, y);
	    System.out.println("\n"+len);
	}catch(Exception ex){
	    ex.printStackTrace();
	}

    }

    
    
    private int LCS(int[] x,int y[]){
	try{
	    int len1=0;
	    int len2=0;
	    if(x.length>=y.length){
		len1=x.length;
		len2=y.length;
	    }else{
		len1=y.length;
		len2=x.length;
	    }
	    int[][] c = new int[len1+1][len2+1];
	    int[] ele = new int[len1];
	    for(int i=0;i<len1;i++){
		c[i][0]=1;
	    }
	    for(int j=0;j<len2;j++){
		c[0][j]=1;
	    }
	    for(int i=1;i<len1;i++){
		for(int j=1;j<len2;j++){
		    if(x[i]==y[j]&&c[i][j]<=1+c[i-1][j-1]){
			c[i][j]=1+c[i-1][j-1];
		    }else{
			c[i][j] = max(c[i-1][j],c[j][i-1]);
		    }
		}
	    }
	    int i=0;
	    int len11=len1;
	    int len22=len2;
	    while(len1>0&&len2>0){
		if(x[len1-1]==y[len2-1]){
		    ele[i] = x[len1-1];
		    System.out.print(x[len1-1]+",");i++;
		    len1--;len2--;
		}else if(c[len1-1][len2]>c[len1][len2-1]){
		    len1--;
		}else{
		    len2--;
		}
	    }
//	    for(int i1=0;i1<len1;i1++){
//		if(ele[i1]!=0){
//		    System.out.print(ele[i1]+",");
//		}
//	    }
	    return c[len11-1][len22-1];
	    
	}catch(Exception ex){
	    ex.printStackTrace();
	}
	return -1;
    }
    
    private int max(int a,int b){
	try{
	    return a>b?a:b;
	}catch(Exception ex){
	    ex.printStackTrace();
	}
	return -1;
    }
}
