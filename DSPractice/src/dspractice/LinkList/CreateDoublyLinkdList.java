package com.aorg.MyPractice.DS.LinkList;

import java.io.File;
import java.util.Scanner;

public class CreateDoublyLinkdList {

	/**
	 * @param args
	 */
	static DLLNode dllListHead = null;
	static DLLNode dllListTail = null;
	public static void main(String[] args) {
		try{
			Scanner sc = new Scanner(new File("list.txt"));
			String[] st = sc.next().split(",");
			DLLNode list = null;
			CreateDoublyLinkdList dll = new CreateDoublyLinkdList();
			for(String s : st){
				int data = Integer.parseInt(s);
				list=dll.createList(data);
			}
			dll.quickSort(dllListHead, dllListTail);
			dll.printRev();
			System.out.println();
			dll.print();
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	private void print(){
		try{
			DLLNode li = dllListHead;
			while(li!=null){
				System.out.print(li.getData()+",");
				li = li.getNext();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	private void printRev(){
		try{
			DLLNode li = dllListTail;
			while(li!=null){
				System.out.print(li.getData()+",");
				li = li.getPre();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private DLLNode createList(int data){
		try{
			DLLNode node = new DLLNode(data);
			if(dllListHead == null && dllListTail == null){
				dllListHead = node;
				dllListTail = null;
			}else{
				DLLNode d = dllListHead;
				while(d.getNext() != null){
					d = d.getNext();
				}
				d.setNext(node);
				node.setPre(d);
				node.setNext(null);
				dllListTail = node;
				//dllList = d;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	private void quickSort(DLLNode head,DLLNode tail){
		try{
			if(head!=null && head!=tail&&head!=tail.getNext()){
				DLLNode pivot = pivot(head, tail);
				quickSort(head, pivot);
				quickSort(pivot.getNext(), tail);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private DLLNode pivot(DLLNode head,DLLNode tail){
		try{
			DLLNode l = head;
			DLLNode r = tail;
			int x = head.getData();
			while(l!=r && l!=r.getNext()){
				while(x>l.getData()){
					l = l.getNext();
				}
				while(x < r.getData()){
					r = r.getPre();
				}
				if(l!=r && l!=r.getNext()){
					int temp = l.getData();
					l.setData(r.getData());
					r.setData(temp);
					l = l.getNext();
					r = r.getPre();
				}
			}
			return l;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
}
