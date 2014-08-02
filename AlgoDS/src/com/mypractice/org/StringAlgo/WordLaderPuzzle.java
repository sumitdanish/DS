package com.mypractice.org.StringAlgo;

import java.util.HashSet;

public class WordLaderPuzzle {

	
	public static void main(String[] args)
	{
		try
		{
			String startWord = "smart";
			String endWord="roamss";
			//String endWord;
			WordLaderPuzzleReadDicWord wl = new WordLaderPuzzleReadDicWord("did.txt");
			//wl.wordLaderProblem(startWord,new HashSet<String>());
			System.out.println(wl.wordLaderLength(startWord, endWord,"did.txt"));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
   /*
    -----------------------------------------
	| scart | start | swart | smalt | smarm |
	| smart | smart | smart | smart | smart |
	-----------------------------------------
	
	---------------------------------------------------------
	| scant | scatt | scare | scarf | scarp | scars | scary |
	| scart | scart | scart | scart | scart | scart | scart |
	| smart | smart | smart | smart | smart | smart | smart |
	---------------------------------------------------------
	*/
	
}
