package com.mypractice.org.LinkedListProgramm;

public class LinkedListImpl {

	/**
	 * @param args
	 */
	
	
	LinkListNode listNode;
	int size=0;
	public static void main(String[] args) {
		// 
		try
		{
			LinkedListImpl l= new LinkedListImpl();
			l.insertNode(12);
			l.insertNode(13);
			l.insertNode(14);
			l.insertNode(15);
			l.insertNodeAfterAnyNode(14, 21);
			l.print();
			l.deleteNode(14);
			l.print();
//			LinkListNode l1 = l.getNode(3,l);
//			System.out.println(l1.getNodeData());
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

	}

	
	
	private void insertNode(int nodeVal)
	{
		try
		{
			LinkListNode ln = new LinkListNode(nodeVal,null);
			if(listNode==null)
			{
				ln.setNextLink(listNode);
				listNode=ln;
				size++;
			}
			else
			{
				LinkListNode tempLn = listNode;
				while(tempLn.getNextLink()!=null)
				{
					tempLn=tempLn.getNextLink();
				}
				tempLn.setNextLink(ln);
				size++;
			}
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	private void insertNodeAfterAnyNode(int nodeIndex,int nodeVal)
	{
		try
		{
			LinkListNode newNode = new LinkListNode(nodeVal,null);
			LinkListNode tempNode = listNode;
			while(tempNode!=null)
			{
				if(tempNode.getNodeData()==nodeIndex)
				{
					newNode.setNextLink(tempNode.getNextLink());
					tempNode.setNextLink(newNode);
				}
				tempNode=tempNode.getNextLink();
			}
			
			/*This commented code will work when u will enter node index inplace of node value
			 * In above code nodeIndex will take nodeValue
			 * */
//			LinkListNode l1 = this.getNode(nodeIndex); 
//			LinkListNode newNode = new LinkListNode(nodeVal,null);
//			newNode.setNextLink(l1.getNextLink());
//			l1.setNextLink(newNode);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	private void deleteNode(int deletedNodeVal)
	{
		try
		{
			LinkListNode tempNode = listNode;
			LinkListNode tempNode1 = listNode;
			if(tempNode.getNodeData()==deletedNodeVal)
			{
				listNode = listNode.getNextLink();
				tempNode=null;
			}
			else
			{
				while(tempNode!=null)
				{
					if(tempNode.getNextLink().getNodeData()==deletedNodeVal)
					{
						tempNode1 = tempNode.getNextLink();
						tempNode.setNextLink(tempNode1);
						tempNode=null;
						break;
					}
					tempNode=tempNode.getNextLink();
				}
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	private  LinkListNode getNode(int nodeIndex)
	{
		try
		{
			LinkListNode indexNode1=listNode;
			if(nodeIndex<=size)
			{
				for(int i=0;i<nodeIndex;i++)
				{
					indexNode1=indexNode1.getNextLink();
				}
			}
			return indexNode1;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}
	
	
	
	private void print()
	{
		LinkListNode indexNode1=listNode;
		while(indexNode1!=null)
		{
			System.out.print(indexNode1.getNodeData()+"-->");
			indexNode1=indexNode1.getNextLink();
		}
		System.out.println();
		//System.out.println(this.getNode(3).getNodeData());
	}
	
	
}
