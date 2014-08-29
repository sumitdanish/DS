package com.mypractice.org.LinkedListProgramm;

public class DoublyLinkListNodeImpl {

	/**
	 * @param args
	 */
	
	DoublyLinkListNode doublyLinkListNode;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			DoublyLinkListNodeImpl dl = new DoublyLinkListNodeImpl();
			dl.insertNode(4);
			dl.insertNode(5);
			dl.insertNode(6);
			dl.insertIntoHead(10);
			dl.insertIntoHead(11);
			dl.insertIntoHead(12);
			dl.insertInBetweenNode(10,16);
			dl.print();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

	}

	
	private void insertIntoHead(int nodeVal)
	{
		try
		{
			DoublyLinkListNode tempNode = doublyLinkListNode;
			DoublyLinkListNode tempNode1 = new DoublyLinkListNode(null,null,nodeVal);
			tempNode.setLeftPointer(tempNode1);
			tempNode1.setRightPointer(tempNode);
			tempNode1.setLeftPointer(null);
			doublyLinkListNode = tempNode1;
			
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
			DoublyLinkListNode tempNode = new DoublyLinkListNode(null,null,nodeVal);
			if(doublyLinkListNode==null)
			{
				tempNode.setRightPointer(null);
				tempNode.setLeftPointer(null);
				doublyLinkListNode=tempNode;
			}
			else
			{
				DoublyLinkListNode tempNode1 = doublyLinkListNode;
				while(tempNode1.getRightPointer()!=null)
				{
					tempNode1 = tempNode1.getRightPointer();
				}
				tempNode1.setRightPointer(tempNode);
				tempNode.setLeftPointer(tempNode1);
				tempNode1=tempNode;
				tempNode.setRightPointer(null);
				tempNode.setLeftPointer(null);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	
	private void insertInBetweenNode(int oldNodeVal,int newNodeVal)
	{
		try
		{
			DoublyLinkListNode temp = doublyLinkListNode;
			while(temp!=null)
			{
				if(temp.getNodeData()==oldNodeVal)
				{
					DoublyLinkListNode temp2 = temp.getRightPointer();
					DoublyLinkListNode temp1 = new DoublyLinkListNode(null,null,newNodeVal);
					temp.setRightPointer(temp1);
					temp1.setLeftPointer(temp);
					temp1.setRightPointer(temp2);
					temp2.setLeftPointer(temp1);
					temp1 = temp2;
					temp=temp1;
				}
				temp=temp.getRightPointer();
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	
	
	private DoublyLinkListNode deleteNode(DoublyLinkListNode doublyLinkListNode,int nodeVal)
	{
		try
		{
			DoublyLinkListNode dl = doublyLinkListNode;
			if((dl.getNodeData()==nodeVal)&&(dl.getLeftPointer()==null&&dl.getRightPointer()==null))
			{
				dl=null;
			}
			else if(dl.getNodeData()==nodeVal)
			{
				doublyLinkListNode = doublyLinkListNode.getRightPointer();
				dl.setLeftPointer(null);
				dl.setRightPointer(null);
				dl=null;
			}
			else
			{
				while(dl.getRightPointer()!=null)
				{
					if(dl.getRightPointer().getNodeData()==nodeVal)
					{
						DoublyLinkListNode dl1 = dl.getLeftPointer();
						dl.setRightPointer(dl.getRightPointer().getRightPointer());
						dl.getRightPointer().setLeftPointer(dl);
						dl1=null;
					}
					dl=dl.getRightPointer();
				}
			}
			return doublyLinkListNode;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
	
	
	private void print()
	{
		try
		{
			DoublyLinkListNode dl = doublyLinkListNode;//this.deleteNode(doublyLinkListNode,4);
//			while(dl!=null)
//			{
//				dl=dl.getRightPointer();
//			}
			while(dl!=null)
			{
				System.out.print(dl.getNodeData()+"-->");
				dl=dl.getRightPointer();
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	
}
