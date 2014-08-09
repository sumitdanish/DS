package com.mypractice.org.StringAlgo;

public class FirstNonRepetedCharecter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String str ="geeksforgeeks";
		String[] s = new FirstNonRepetedCharecter().getFirstNonRepetedChar(str).split(",");
		new FirstNonRepetedCharecter().indexInCharOfString(str);
		System.out.println(s[0]+","+s[1]);
	}

	private int[] indexInCharOfString(String str)
	{
		try
		{
			int[] ch = new int[256];
			for(int i=0;i<str.length();i++)
			{
				//if(ch[str.charAt(i)])
				ch[str.charAt(i)]++;
			}
			for(int k=0;k<ch.length;k++)
			{
				System.out.println(str.charAt(k)+"-->"+ch[str.charAt(k)]+",");
			}
			return ch;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}
	public String getFirstNonRepetedChar(String str)
	{
		try
		{
			int count =0;
			char ch='p';
			int[] arr=new int[str.length()];
			for(int i=0;i<str.length();i++)
			{
				count=0;
				for(int j=0;j<str.length();j++)
				{
					if(str.charAt(i)==str.charAt(j))
					{
						count++;
					}
				}
				if(count == 1)
				{
					ch=str.charAt(i);
					break;
				}
			}
			
			return count+","+String.valueOf(ch); 
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			//return null;
		}
		return null;
	}
	
	
}
