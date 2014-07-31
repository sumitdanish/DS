package com.mypractice.org.Graph;

import java.util.Scanner;
import java.util.Stack;

public class DfsSearchAlgo {

	
	
	private Stack<Integer> stack;
	
	
	public DfsSearchAlgo()
	{
		stack = new Stack<Integer>();
	}
	
	public void dfSearch(int[][] addJecencyMattrix,int source)
	{
		int numberOfNode = addJecencyMattrix[source].length-1;
		int element = source;
		int i=element;
		int[] visited = new int[addJecencyMattrix[source].length];
		visited[i]=1;
		stack.push(source);
		while(!stack.isEmpty())
		{
			element = stack.peek();
			i=element;
			while(i<=numberOfNode)
			{
				if(addJecencyMattrix[element][i]==1&&visited[i]==0)
				{
					stack.push(i);
					element=i;
					visited[i]=1;
					i=1;
					System.out.print(element+"\t");
					continue;
				}
				i++;
			}
			stack.pop();
		}
	}
	
	
	
	
	public static void main(String[] args) {
		// 
		
		try
		{
			int numberOfNode=0;
			int source=0;
			int[][] addJecencyMattrix;
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter No. Of Node's");
			numberOfNode = sc.nextInt();
			addJecencyMattrix = new int[numberOfNode+1][numberOfNode+1];
			System.out.println("Enter Addjenceny Mattrix");
			for(int i=1;i<=numberOfNode;i++)
			{
				for(int j=0;j<=numberOfNode;j++)
				{
					addJecencyMattrix[i][j]=sc.nextInt();
				}
			}
			System.out.println("Enter Source Node-->");
			source = sc.nextInt();
			DfsSearchAlgo dfsSearchAlgo = new DfsSearchAlgo();
			dfsSearchAlgo.dfSearch(addJecencyMattrix, source); 
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

	}

}
