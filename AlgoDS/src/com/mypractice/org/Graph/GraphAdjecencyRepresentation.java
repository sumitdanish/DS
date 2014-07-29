package com.mypractice.org.Graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GraphAdjecencyRepresentation {

	static NodeVertex[] nodeVertex;
	
	public GraphAdjecencyRepresentation(String fileName)
	{
		try
		{
			Scanner sc = new Scanner(new File(fileName));
			nodeVertex = new NodeVertex[sc.nextInt()];
			for(int i=0;i<nodeVertex.length;i++)
			{
				nodeVertex[i]=new NodeVertex(sc.next(),null);
			}
			readEdge(nodeVertex, fileName,sc);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
	}
	
	
	private void readEdge(NodeVertex[] nv,String fileName,Scanner sc)
	{
		try
		{
			//Scanner sc = new Scanner(new File(fileName));
			while(sc.hasNext())
			{
				String s1 = sc.next();
				String s2 = sc.next();
				//System.out.println(s1+" : "+s2);
				int vertex1 = getVertexIndex(s1);
				int vertex2 = getVertexIndex(s2);
				System.out.println(vertex1+" : "+vertex2);
				nodeVertex[vertex1].setNeighborInfo(new NeighborInfo(vertex2,nodeVertex[vertex1].getNeighborInfo()));
				nodeVertex[vertex2].setNeighborInfo(new NeighborInfo(vertex1,nodeVertex[vertex2].getNeighborInfo()));
			}
			printAddjecencyList();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	private int getVertexIndex(String vertexName)
	{
		for(int i=0;i<nodeVertex.length;i++)
		{
			if(nodeVertex[i].getNodeName().equals(vertexName))
			{
				return i;
			}
		}
		return -1;
	}
	
	public void printAddjecencyList()
	{
		try
		{
			for(int i=0;i<nodeVertex.length;i++)
			{
				System.out.print(nodeVertex[i].getNodeName());
				NeighborInfo nif = nodeVertex[i].getNeighborInfo();
				while(nif!=null)
				{
					System.out.print("-->"+nodeVertex[nif.getNodeNumber()].getNodeName());
					nif = nif.getNeighborInfoNext();
				}
				System.out.println("\n");
				
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	
	public static void main(String[] args)
	{
		try
		{
			String fileName = "add.txt";
			GraphAdjecencyRepresentation graphAdd = new GraphAdjecencyRepresentation(fileName);
			//graphAdd.readEdge(nodeVertex, fileName); 
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
