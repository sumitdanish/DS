package com.aorg.MyPractice.DS.LinkList;

import java.io.File;
import java.util.Scanner;

public class RotateALinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			Scanner sc = new Scanner(new File("list.txt"));
			RotateALinkedList rotateList = new RotateALinkedList();
			MList list = null;
			String[] st = sc.next().split(",");
			for(String s : st){
				int data = Integer.parseInt(s);
				list = rotateList.createList(list, data);
			}
			rotateList.printList(list);
			System.out.println();
			int k = 5;
			MList l = rotateList.rotateList(list, k);
			rotateList.printList(l);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	private MList rotateList(MList head,int k){
		try{
			MList list = head;
			MList list1 = null;
			int i=0;
			while(i < k && list != null){
				list1 = list;
				list = list.getNext();
				i++;
			}
			list1.setNext(null);
			MList temp = list;
			while(temp.getNext() != null){
				temp = temp.getNext();
			}
			temp.setNext(head);
			head = list;
			return head;
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	
	private void printList(MList list){
		try{
			MList li = list;
			while(li!=null){
				System.out.print(li.getData()+",");
				li = li.getNext();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	private MList createList(MList list,int data){
		try{
			MList node = new MList(data);
			if(list == null){
				list = node;
				return list;
			}
			list.setNext(createList(list.getNext(), data));
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	
}
