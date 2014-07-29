package com.mypractice.org.Graph;

public class PrimsAlgoritham {

	
	public static void main(String[] args)
	{
		int[][] graph = {{0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0},
               };

// Print the solution
		new PrimsAlgoritham().printPrimsMst(graph);
	}
	
	
	
	
	
	public void printPrimsMst(int[][] graphMatrix)
	{
		int[] key=new int[graphMatrix[0].length];
		boolean[] mst=new boolean[graphMatrix[0].length];
		int[] parent = new int[graphMatrix[0].length];
		for(int i=0;i<graphMatrix[0].length;i++)
		{
			key[i]=Integer.MAX_VALUE;
			mst[i]=false;
		}
		key[0]=0;
		parent[0]=1;
		for(int i=0;i<graphMatrix.length;i++)
		{
			int u = mstVertexFinder(key,mst);
			mst[u]=true;
			for(int k=0;k<graphMatrix[i].length;k++)
			{
				if(mst[k]==false&&graphMatrix[u][k]<key[k])
				{
					parent[k]=u;
					graphMatrix[u][k]=key[k];
				}
			}
		}
		printMST(parent,graphMatrix);
	}
	
	private void printMST(int[] parent, int[][] graph)
	{
	   
	   for (int i = 1; i < graph.length; i++)
	    //  printf("%d - %d    %d \n", parent[i], i, graph[i][parent[i]]);
	   {
		   System.out.println(parent[i]+"---"+ i +"-----"+ graph[i][parent[i]]);
	   }
	}
	
	
	
	
	
	
	private int mstVertexFinder(int[] key,boolean[] mst)
	{
		int min = Integer.MAX_VALUE;
		int minIndex = 0;
		for(int v=0;v<key.length;v++)
		{
			if(mst[v]==false&&min>key[v])
			{
				min=key[v];
				minIndex=v;
			}
		}
		return minIndex;
	}
	
	
}
