package com.mypractice.org.StringAlgo;

import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class WordLaderPuzzleReadDicWord {
	private HashSet<String> hash = new HashSet<String>();
	private Scanner sc;
	private Queue<Stack<String>> que = new LinkedList<Stack<String>>();
	private int minLength=0;
	
	public WordLaderPuzzleReadDicWord(String fileName) {
		try
		{
			Scanner sc = new Scanner(new File(fileName));
			while(sc.hasNext())
			{
				String s = sc.next().toString();
				hash.add(s);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	private void wordLaderProblem(String s,String endWord,int length)
	{
		try
		{
			
			Stack<String> sta = new Stack<String>();
			sta.add(s);
			for(int i=0;i<s.length();i++)
			{
				StringBuilder sb = new StringBuilder(s);
				for(char c='a';c<='z';c++)
				{
					if(c==s.charAt(i))
					{
						continue;
					}
					sb.setCharAt(i,c);
					if(sb.toString().equals(endWord))
					{
						if(minLength==0||minLength>length+1)
						{
							minLength=length+1;
							System.out.println(minLength);
						}
					}
					else if(hash.contains(sb.toString())&&!sta.contains(sb.toString()))
					{
						//Stack<String> popSt = que.peek();
						Iterator<Stack<String>> it = que.iterator();
						while(it.hasNext())
						{
							if(!it.next().contains(sb.toString())) 
							{
								//sta.add(sb.toString());
								wordLaderProblem(sb.toString(),endWord,length+1);
							}
						}
						
					}
				}
				que.add(sta);
			}
			Iterator<String> st = sta.iterator();
			while(st.hasNext())
			{
				System.out.println(st.next());
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public int wordLaderLength(String startWord,String endWord,String fileName) throws Exception
	{
		try
		{
			//int  minLength=0;
			if(startWord.equals(endWord)||startWord.length()==0||endWord.length()==0)
			{
				return 0;
			}
			wordLaderProblem(startWord, endWord,1);
			return minLength;
			
		}
		catch(Exception ex)
		{
			throw ex;
		}
	}
	
}

