package com.mypractice.org.StringAlgo;

public class NaiveApprochStringSearchPattern {

	
	public static void main(String[] args)
	{
		String str="AABAACAADAABAAABAA";
		String pattern = "AABA";
		new NaiveApprochStringSearchPattern().getFirstIndex(str, pattern);
	}
	
	private void getFirstIndex(String str,String pattern)
	{
		//int firstIndex=0;
		try
		{
			for(int i=0;i<(str.length()-pattern.length());i++)
			{
				int j=0;
				for(j=0;j<pattern.length();j++)
				{
					if(pattern.charAt(j)!=str.charAt(i+j))
					{
						break;
					}
				}
				if(j==pattern.length())
				{
					System.out.println("Pattern Approach : "+i);
				}
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		//return firstIndex;
	}
	
}
