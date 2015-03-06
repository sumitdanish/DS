package com.aorg.MyPractice.DS.LinkList;



public class MyLRU {

	/**
	 * @param args
	 */
	
	static MyQueue queue;
	static MyHash hash;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	
	public boolean isQueueIsFull(MyQueue queue){
		return queue.getCount() == queue.getNumberOfFrames();
	}
	
	public boolean isQueueEmpty(MyQueue queue){
		return (queue.getFront() == null && queue.getRear() == null);
	}
	
	
	
	public boolean isFull(MyQueue queue){
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
	
	public void createQueue(MyQueue queue,int data){
		try{
			if(isFull(queue)){
				hash.getHash()[queue.getRear().getPagenumber()] = null;
				deQueue(queue);
			}
			DLLRU node = new DLLRU(data);
			if(isQueueEmpty(queue)){
				node.setNext(null);
				node.setPrevious(null);
				queue.setFront(node);
				queue.setRear(node);
				
			}else{
				DLLRU dll = queue.getRear();
				while(dll.getNext() !=null){
					dll = dll.getNext();
				}
				node.setNext(null);
				dll.setNext(node);
				node.setPrevious(dll);
				dll = node;
				queue.setRear(dll);
			}
			hash.getHash()[queue.getRear().getPagenumber()] = node;
			queue.setCount(queue.getCount()+1);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public DLLRU deQueue(MyQueue queue){
		try{
			if(isQueueEmpty(queue) == true){
				return null;
			}else{
				DLLRU node = queue.getFront();
				queue.setFront(node.getNext());
				queue.getFront().setPrevious(null);
				return node;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
}
class MyQueue
{
	private DLLRU front;
	private DLLRU rear;
	private int numberOfFrames;
	private int count;
	
	public void setFront(DLLRU front){
		this.front = front;
	}
	public void setRear(DLLRU rear){
		this.rear = rear;
	}
	public void setNumberOfFrames(int numberOfFrames){
		this.numberOfFrames = numberOfFrames;
	}
	public void setCount(int count){
		this.count = count;
	}
	public int getNumberOfFrames(){
		return numberOfFrames;
	}
	public DLLRU getFront(){
		return front;
	}
	public DLLRU getRear(){
		return rear;
	}
	public int getCount(){
		return count;
	}
	
}
class MyHash
{
	private DLLRU[] hash;
	private int capacity;
	public MyHash(){
		
	}
	public MyHash(int capacity){
		this.capacity = capacity;
		hash = new DLLRU[capacity];
		for(int i=0;i<capacity;i++){
			hash[i] = new DLLRU();
		}
	}
	public void setHash(DLLRU[] hash){
		this.hash = hash;
	}
	public void setCapacity(int capacity){
		this.capacity = capacity;
	}
	
	public DLLRU[] getHash(){
		return hash;
	}
	public int getCapacity(){
		return capacity;
	}
}
class DLLRU
{
	private int pageNumber;
	private DLLRU next;
	private DLLRU previous;
	public DLLRU(){
		
	}
	public DLLRU(int pageNumber){
		this.pageNumber = pageNumber;
	}
	
	public void setNext(DLLRU next){
		this.next = next;
	}
	public void setPrevious(DLLRU previous){
		this.previous = previous;
	}
	public void setPagenumber(int pageNumber){
		this.pageNumber = pageNumber;
	}
	
	
	public DLLRU getNext(){
		return next;
	}
	public DLLRU getPrevious(){
		return previous;
	}
	public int getPagenumber(){
		return pageNumber;
	}
}