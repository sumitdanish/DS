package com.aorg.MyPractice.DS.LinkList;

import java.io.File;
import java.util.Scanner;

public class OperationsOnMiddleElement {

	/**
	 * @param args
	 */
	static MidOperation midOper;
	public static void main(String[] args) {
		try{
			 Scanner sc = new Scanner(new File("list.txt"));
			 String[] st = sc.next().split(",");
			 OperationsOnMiddleElement  op = new OperationsOnMiddleElement();
			 DLLNode mid = null;
			 for(String s : st){
				 int data = Integer.parseInt(s);
				 op.push(data);
			 }
			// mid = op.getMidNode();
			// System.out.println("MId Element > "+mid.getData());
			DLLNode h = op.pop();
			 //System.out.println(h.getData());
			op.printList();
			mid = op.getMidNode();
			System.out.println("\n Mid Element > "+mid.getData());
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}
	public OperationsOnMiddleElement(){
		midOper = new MidOperation();
	}
	public void push(int data){
		try{
			int cou = 0;
			DLLNode node = new DLLNode(data);
			if(midOper.getHead() == null){
				midOper.setHead(node);
				cou = midOper.getCount();
				midOper.setMid(node);
				midOper.setCount(cou++);
			}else{
				node.setNext(midOper.getHead());
				midOper.getHead().setPre(node);
				cou = midOper.getCount();
				cou++;
				midOper.setCount(cou);
				if(cou%2 !=0){
					midOper.setMid(midOper.getMid().getPre());
				}
				midOper.setHead(node);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	private DLLNode pop(){
		try{
			int count = midOper.getCount();
			if(count == 0){
				System.out.println("NO Element");
				return null;
			}
			DLLNode head = midOper.getHead();
			midOper.setHead(head.getNext());
			midOper.getHead().setPre(null);
			count--;
			midOper.setCount(count);
			if(count %2 ==0){
				midOper.setMid(midOper.getMid().getNext());
			}
			return head;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	

	private void printList(){
		try{
			DLLNode list = midOper.getHead();
			while(list!=null){
				System.out.print(list.getData()+",");
				list = list.getNext();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private DLLNode getMidNode(){
		try{
			DLLNode node = midOper.getMid();
			return node;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
}
class MidOperation{
	private int count = 0;
	private DLLNode head;
	private DLLNode mid;
	public MidOperation(){
		
	}
	public void setMid(DLLNode mid){
		this.mid = mid;
	}
	
	public void setHead(DLLNode head){
		this.head = head;
	}
	
	public void setCount(int count){
		this.count = count;
	}
	public DLLNode getHead(){
		return head;
	}
	public DLLNode getMid(){
		return mid;
	}
	public int getCount(){
		return count;
	}
}