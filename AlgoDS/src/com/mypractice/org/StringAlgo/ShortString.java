package com.mypractice.org.StringAlgo;

public class ShortString {

	/**
	 * @param args
	 */
	 
	 
	 /*
	 * In this string shorting capital letter comes first becz shorting is 
	 * done on the bassis of ascii value of charecter
	 * 
	 */
	public static void main(String[] args) {
		String s = "hell_is_well";
		System.out.println(new ShortString().shortString(s));

	}
	
	private String shortString(String str)
	{
		try
		{
			char[] ch = str.toCharArray();
			int min=0;
			String s=new String();
			for(int i=0;i<ch.length;i++)
			{
				min=ch[i];
				int k=0;
				for(int j=i;j<ch.length;j++)
				{
					if(min>ch[j])
					{
						min=ch[j];
						k=j;
					}
				}
				
				char temp=ch[i];
				ch[i]=(char) min;
				s=s+ch[i];
				ch[k]=temp;
				//System.out.println(temp+" : "+ch[i]);
			}
			return s;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}

}
