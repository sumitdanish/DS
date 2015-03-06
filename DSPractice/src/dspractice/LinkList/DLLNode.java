package com.aorg.MyPractice.DS.LinkList;

public class DLLNode {

	private int data;
	private DLLNode next;
	private DLLNode pre;
	public DLLNode(int data){
		this.data = data;
	}
	
	public void setNext(DLLNode next){
		this.next = next;
	}
	public void setPre(DLLNode pre){
		this.pre = pre;
	}
	public void setData(int data){
		this.data = data;
	}
	
	public int getData(){
		return data;
	}
	public DLLNode getNext(){
		return next;
	}
	public DLLNode getPre(){
		return pre;
	}

}
