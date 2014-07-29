package com.mypractice.org.DynamicProrammingPractice;

public class MinimumJumpToReachEndOfArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={2,3,1,1,4};
		System.out.println(new MinimumJumpToReachEndOfArray().minimunDistance(a,a.length)); 

	}
	
	public int minimunDistance(int[] a,int length)
	{
		int i=0; 
		int count=0;
		int min=0;
		for(i=0;i<length;i++)
		{
			count++;
			min=0;
			for(int j=0;j<a[i];j++)
			{
				if(min<=j+a[j])
				{
					min=j+a[j];
				}
			}
			if(min==0)
			{
				return Integer.MAX_VALUE;
			}
			i=i+min;
		}
		System.out.println(i+" : "+min+" : "+count);
		return count+1;
	}
	
	
}
