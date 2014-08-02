package com.mypractice.org.StringAlgo;

import java.io.File;
import java.util.Scanner;

public class WordLaderPuzzleReadDicWord {

	
	public static void main(String[] args)
	{
		try
		{
			Scanner sc = new Scanner(new File("did.txt"));
			int i=0;
			while(sc.hasNext())
			{
				
				System.out.println(sc.next());
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	
}
