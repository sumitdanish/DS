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
			int[] a = {1,2,3,4,5,6};
			int temp=0;
			int[] a1 = new int[a.length];
			for(int i=0;i<a.length;i++)
			{
				a1[i]=0;
			}
			a1[0]=a[0];
			for(int i=0;i<a.length;i++)
			{
				int j=0;
				while(j<2)
				{
					if(a[i+j]!=a[j+1])
					{
						temp=a[i+j];
						a[i+j]=a[j+1];
						a[j+1]=temp;
					}
					j++;
				}
			}
			for(int i=0;i<a.length;i++)
			{
				System.out.print(a[i]+",");
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

	}

}
