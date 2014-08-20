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
			l.inserIntoHead(3);
			l.inserIntoHead(31);
			l.inserIntoHead(311);
			l.inserIntoHead(3111);
			l.insertNode(13);
			l.insertNode(14);
			l.insertNode(15);
			l.insertNodeAfterAnyNode(14, 21);
			l.insertNodeAfterAnyNode(21,22);
			l.insertNodeAfterAnyNode(22,23);
			l.print();
			//l.replaceOneNodeFromAnotherNode(21,39);
			
//			l.deleteNode(21);
//			l.deleteNode(12);
			//l.swapTwoDiffrentNode(3,5);
			//l.print();
			//l.reverseInSomeSpecificPart(4);
			//l.printHalfNode(21);
//			LinkListNode l1 = l.getNode(3);
//			System.out.println(l1.getNodeData());
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

	}

	
	
	private void inserIntoHead(int nodeVal)
	{
		try
		{
			LinkListNode tempNode = listNode;
			LinkListNode tempNode1 = new LinkListNode(nodeVal,null);
			tempNode1.setNextLink(tempNode);
			tempNode = tempNode1;
			listNode=tempNode;
			size++;
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
					size++;
				}
				tempNode=tempNode.getNextLink();
			}
			
			/*
			 * This commented code will work when u will enter node index inplace of node value
			 * In above code nodeIndex will take nodeValue
			 * 
			   LinkListNode l1 = this.getNode(nodeIndex); 
			   LinkListNode newNode = new LinkListNode(nodeVal,null);
			   newNode.setNextLink(l1.getNextLink());
			   l1.setNextLink(newNode);
			   
			 */
			
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
			/*
			 * Here if part will delete the head node from linkedList and else part will delete 
			 * the node from mid as well as from end of the linkedList
			 *
			 * NOTE : 
			 * 
			 * if we want delete node by some index e.g we want delete the node which is at index n
			 * then simply get the node(e.g suppose u got some node called 'ptr') at that index by 
			 * calling getNode(indexNumber) method (just billow deleteNode(int deletedNodeVal) method)
			 * and then in place of "deletedNodeVal" put the value of ptr.getNodeData(). 
			 * now u can delete node at that index...
			 * final code : LinkListNode tempNode2 =this.getNode(deletedNodeVal);
			 * 
			 */
			
			LinkListNode tempNode = listNode;
			LinkListNode tempNode1 = listNode;
			if(tempNode.getNodeData()==deletedNodeVal)
			{
				listNode = listNode.getNextLink();
				tempNode=null;
				size--;
			}
			else
			{
				while(tempNode!=null)
				{
					if(tempNode.getNextLink().getNodeData()==deletedNodeVal)
					{
						tempNode1 = tempNode.getNextLink();
						tempNode.setNextLink(tempNode1.getNextLink());
						tempNode=null;
						size--;
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
	
	/*This method will return the node from the beggning of the index n */
	
	private  LinkListNode getNode(int nodeIndex)
	{
		try
		{
			/*
			 *	This code will usefull when we r using to pointer for finding nth node from end
			 *  ALGO : Initially both pointer Node (i.e indexNode1 and indexNode2) will point the
			 *         head node (i.e listNode).
			 *         indexNode1 pointer will not move until nodeIndex-count<0
			 *         when above condition will satisfied, then both pointer move together
			 *         when indexNode2 will reach to end then indexPointer1 will point to nth node from
			 *         end.... for more clarification dry run in ur paper..
			 *
			 *  LinkListNode indexNode1=listNode;
			 *	LinkListNode indexNode2=null;
			 *	int count =0;
			 *	for(indexNode2=listNode;indexNode2!=null;)
			 *	{
			 *		count++;
			 *		if(nodeIndex-count<0)
			 *		{
			 *			indexNode1=indexNode1.getNextLink();
			 *		}
			 *		indexNode2=indexNode2.getNextLink();
			 *	}
			 * 
			 *
			 *
			 * If we want find the node from end of the linkedList then we can find the node from beggning  
			 * By using this formula : nodeIndex=size-nodeIndex;
			 * 
			 */
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
	
	
	private void replaceOneNodeFromAnotherNode(int olderNodeValOrNodeIndex,int newNodeVal)
	{
		try
		{
			LinkListNode tempNode1=listNode;
			int i=0;
			while(tempNode1!=null)
			{
				i++;
				if(tempNode1.getNextLink().getNodeData()==olderNodeValOrNodeIndex)
				{
					tempNode1.getNextLink().setNodeData(newNodeVal);
					break;
				}
				tempNode1=tempNode1.getNextLink();
			}
		}
		catch(Exception ex)
		{
			
		}
	}
	
	
	
	private LinkListNode reverseKthAlternateNode(LinkListNode listNode,int k)
	{
		try
		{
			LinkListNode current = listNode;
			LinkListNode next = null;
			LinkListNode previous = null;
			int count=0;
			while(current!=null&&count<3)
			{
				next=current.getNextLink();
				current.setNextLink(previous);
				previous = current;
				current = next;
				count++;
			}
			if(listNode!=null)
			{
				listNode.setNextLink(this.reverseKthAlternateNode(next, k));
			}
			
			return previous;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
	private LinkListNode reverseInSomeSpecificPart(LinkListNode listNode,int nodeIndex)
	{
		try
		{
			LinkListNode tempNode=null;
			/*
			 * The two variable tempNode1 and tempNode11 have major role for this action
			 * tempNode1--> initially it pointing to the second node of the listNode. becz at the time of reversing the head will get to null so for avoiding this one we are using 
			 * tempNode11 which is pointing to headNode; becz we have to take care for head node at the time of reversing some number of node. we can use tempNode1 also problem is 
			 * that we can miss head node also.
			 * 
			 * 
			 */
			
			LinkListNode tempNode2 = listNode;
			for(int i=0;i<nodeIndex;i++)
			{
				tempNode2=tempNode2.getNextLink();
			}
			LinkListNode tempNode1=listNode.getNextLink();
			LinkListNode tempNode11=listNode;
			int count=1;
			/*  This loop will reverse the linked list from 0 to nodeIndex and head of the reverse list will get store into tempNode
			 *  after reversing the linkList to nodeIndex, the remaning linkList i.e from nodeIndex+1 to till the end of original linkList 
			 *  , the head of that linkList will get store in to tempNode1.
			*/
			while(count<=nodeIndex)
			{
				tempNode11=tempNode11.getNextLink();
				count++;
			}
			count=1;
			while(tempNode1!=null&&count<=nodeIndex)
			{
				listNode.setNextLink(tempNode);
				tempNode=listNode;
				listNode=tempNode1;
				tempNode1=tempNode1.getNextLink();
				count++;
			}
			LinkListNode ll = tempNode;
			/*
			 * This loop will go to end of reversed linkList and then end of this link part will connect with head part of the tempNode1
			 * then ll1 which is denoting the  head part of the tempNode, will get assign to temoNOde1...
			*/
			while(ll.getNextLink()!=null)
			{
				ll=ll.getNextLink();
			}
			ll.setNextLink(tempNode11);
		    tempNode11=tempNode;
		    tempNode=tempNode11;
			return tempNode;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}
	
	
	private LinkListNode reverseLinkListNode(LinkListNode listNode)
	{
		try
		{
			int i=4;
			LinkListNode tempNode=null;
			LinkListNode tempNode1=listNode.getNextLink();
			int count=0;
			while(tempNode1!=null/*&&count<i*/) // Here if u remove the commented part then the reversal of the node will happen till the i'th from the beggning of the List 
			{
				listNode.setNextLink(tempNode);// Here we are making head node as tail node so head node of listNode is null becz tempNode=null (initially)
				tempNode=listNode;
				listNode=tempNode1;           // 
				tempNode1=tempNode1.getNextLink();
				count++;
				//System.out.println();
			}
			while(tempNode1!=null)
			{
				tempNode1=tempNode1.getNextLink();
			}
			
			listNode=tempNode;
			return listNode;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}
	
	
	private void swapTwoDiffrentNode(int node1Index,int node2Index)
	{
		try
		{
			LinkListNode tempNode = listNode;
			LinkListNode tempNode_pre = null;
			for(int i=0;i<node1Index-1;i++)
			{
				tempNode_pre=tempNode;
				tempNode=tempNode.getNextLink();
			}
			
			LinkListNode tempNode1=listNode;
			LinkListNode tempNode1_pre=null;
			
			for(int i=0;i<(size-node2Index);i++)
			{
				tempNode1_pre=tempNode1;
				tempNode1=tempNode1.getNextLink();
			}
			
			LinkListNode temp = tempNode_pre.getNextLink();
			tempNode_pre.setNextLink(tempNode1_pre.getNextLink());
			tempNode1_pre.setNextLink(temp);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	
	/*
	 * This method will copy the complete link list if we remove the if body , otherwise copy will be done before the nodeVal
	 * 
	 * 
	 * 
	 */
	private void printHalfNode(int nodeVal)
	{
		try
		{
			int i=0;
			int j=0;
			LinkListNode list = listNode;
			LinkListNode list2=null;
			while(list.getNextLink()!=null)
			{
				if(list.getNodeData()==nodeVal)
				{
					break;
				}
				else
				{
					LinkListNode ln = new LinkListNode(list.getNodeData(),null);
					if(list2==null)
					{
						ln.setNextLink(list2);
						list2=ln;
					}
					else
					{
						LinkListNode ln1 = list2;
						while(ln1.getNextLink()!=null)
						{
							ln1 = ln1.getNextLink();
						}
						ln1.setNextLink(ln);
					}
				}
				list=list.getNextLink();
			}			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	private void print()
	{
		//LinkListNode indexNode1=this.reverseInSomeSpecificPart(listNode,3);
		//LinkListNode indexNode1=this.reverseLinkListNode(listNode);
		LinkListNode indexNode1=this.reverseKthAlternateNode(listNode,1);
		while(indexNode1!=null)
		{
			System.out.print(indexNode1.getNodeData()+"-->");
			indexNode1=indexNode1.getNextLink();
		}
	}
}
