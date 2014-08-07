package com.mypractice.org.StringAlgo;

public class FirstNonRepetedCharecter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String str ="geeksftworgeeksft";
		String[] s = new FirstNonRepetedCharecter().getFirstNonRepetedChar(str).split(",");
		System.out.println(s[0]+","+s[1]);
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
				for(int j=i;j<str.length();j++)
				{
					if(str.charAt(i)==str.charAt(j))
					{
						count++;
					}
				}
				arr[i]=count;
				if(count == 1)
				{
					ch=str.charAt(i);
					break;
				}
			}
			for(int l=0;l<arr.length;l++)
			{
				//System.out.println(arr[l]+","+str.charAt(l));
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
