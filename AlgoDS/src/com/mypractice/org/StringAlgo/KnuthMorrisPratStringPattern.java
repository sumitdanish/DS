package com.mypractice.org.StringAlgo;

public class KnuthMorrisPratStringPattern {

	public static void main(String[] args) {
		
		
		String pattern="abcabdabc";
		String text="abcabdabcabdabcabdabdabc";
		new KnuthMorrisPratStringPattern().searchPattern(text, pattern);
	}
	
	
	/*Note: Why a prefix should match suffix of the pattern? its because when we shift the pattern its the prefix of P
	which comes towards the suffix. And also the key idea is that if we have successfully matched prefix P[1...i-1] of 
	the pattern with the substring T[j-(i-1)...j-1] of the input string and P(i)!=T(j), then we dont need to reprocess
	of the suffix T[j-(i-1)...j-1] since we know this portion of the text string is the prefix of the pattern that we 
	have just matched.*/
	
	
	private int[] getPreprocessing(String pattern)
	{
		int[] b=new int[pattern.length()+1];
		int j=-1;
		int i=0;
		b[0]=-1;
		while(i<pattern.length())
		{
			while(j>=0&&pattern.charAt(i)!=pattern.charAt(j))
			{
				j=b[j];
			}
			i++;
			j++;
			b[i]=j;
		}
		return b;
	}
	private void searchPattern(String str,String pattern)
	{
		try
		{
			int i=0;
			int[] b = new int[pattern.length()+1];
			b=getPreprocessing(pattern);
			int j=0;
			while(i<str.length())
			{
				while(j>=0&&str.charAt(i)!=pattern.charAt(j))
				{
					j=b[j];
				}
				j++;
				i++;
				if(j==pattern.length())
				{
					System.out.println("found : "+i);
					j=b[j];
				}
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
