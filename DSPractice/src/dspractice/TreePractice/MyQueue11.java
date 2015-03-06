package com.aorg.MyPractice.DS.TreePractice;

import java.io.File;
import java.util.Scanner;

public class MyQueue11 {

	/**
	 * @param args
	 */
	static MyQ queue;
	public static void main(String[] args) {
		try{
			MyQueue11 myQ = new MyQueue11();
			queue = new MyQ();
			Scanner sc = new Scanner(new File("queue.txt"));
			String[] st = sc.next().split(",");
			for(String s : st){
				int data = Integer.parseInt(s);
				myQ.createQueue(queue,data);
			}
//			myQ.printNext(queue);
//			System.out.println();
//			myQ.printPre(queue);
//			MyDLL node = myQ.deQueue(queue);
//			System.out.println("\n"+node.getData());
//			System.out.println();
//			myQ.printNext(queue);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	public void printNext(MyQ queue){
		try{
			MyDLL q = queue.getFront();
			while(q!=null){
				System.out.print(q.getData()+",");
				q = q.getNext();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void printPre(MyQ queue){
		try{
			MyDLL q = queue.getRear();
			while(q!=null){
				System.out.print(q.getData()+",");
				q = q.getPre();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public MyQueue11(){
		
	}
	
	public boolean isEmpty(MyQ queue){
		try{
			if(queue.getFront() == null && queue.getRear() == null){
				return true;
			}
			return false;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}

	
	public boolean isFull(MyQ queue){
		try{
			if(queue.getFront() == queue.getRear()){
				return true;
			}
			return false;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	public void createQueue(MyQ queue,int data){
		try{
			MyDLL node = new MyDLL(data);
			if(isEmpty(queue)){
				node.setNext(null);
				node.setPre(null);
				queue.setFront(node);
				queue.setRear(node);
			}else{
				MyDLL dll = queue.getRear();
				while(dll.getNext() !=null){
					dll = dll.getNext();
				}
				node.setNext(null);
				dll.setNext(node);
				node.setPre(dll);
				dll = node;
				queue.setRear(dll);
				
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public MyDLL deQueue(MyQ queue){
		try{
			if(isEmpty(queue) == true){
				return null;
			}else{
				MyDLL node = queue.getFront();
				queue.setFront(node.getNext());
				queue.getFront().setPre(null);
				return node;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
}
class MyQ
{
	private MyDLL rear;
	private MyDLL front;
	private MyQ queue;
	
	public void setRear(MyDLL rear){
		this.rear = rear;
	}
	public void setFront(MyDLL front){
		this.front = front;
	}
	public void setQueue(MyQ queue){
		this.queue = queue;
	}
	
	public MyQ getQueue(){
		return queue;
	}
	public MyDLL getFront(){
		return front;
	}
	public MyDLL getRear(){
		return rear;
	}
	
}
class MyDLL
{
	int data;
	private MyDLL next;
	private MyDLL pre;
	public MyDLL(int data){
		this.data = data;
	}
	public void setNext(MyDLL next){
		this.next = next;
	}
	public void setPre(MyDLL pre){
		this.pre = pre;
	}
	public void setData(int data){
		this.data = data;
	}
	
	public int getData(){
		return data;
	}
	public MyDLL getNext(){
		return next;
	}
	public MyDLL getPre(){
		return pre;
	}
	
}