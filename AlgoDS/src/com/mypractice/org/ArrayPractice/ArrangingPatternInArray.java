package com.mypractice.org.ArrayPractice;

public class ArrangingPatternInArray {

	/**
	 * @param args
	 * Given an array convert it to another array such that the following condition holds:
		a < b > c < d > e < f > g < h
		where the modified array is {a,b,c,d,e,f,g,h}
		Input:
		1,2,3,4,5,6
		Output:
		1,3,2,5,4,6
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try
		{
			int[] a = {1,2,3,4,5,6,7,8};
			for(int i : new ArrangingPatternInArray().getDesiredOutPut(a))
			{
				System.out.print(i+",");
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

	}
	
	
	private int[] getDesiredOutPutWithOutShorted(int[] a)
	{
		try
		{
			//int temp=0;
			return a;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
	// When Array Is Allready Shorted Tyhen That Logic Will Work time complexity O(n)
	private int[] getDesiredOutPut(int[] a)
	{
		try
		{
			//int temp=0;
			for(int i=0;i<a.length-2;i++)
			{
				if(a[i]<a[i+1]&&a[i+2]>a[i+1]&&a[i+2]>a[i])
				{
					int temp=a[i+2];
					a[i+2]=a[i+1];
					a[i+1]=temp;
				}
				
			}
			return a;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}

}
