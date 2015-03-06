package com.aorg.MyPractice.DS.LinkList;

import java.io.File;
import java.util.Scanner;

public class SwapNodeKthNode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			Scanner sc = new Scanner(new File("list.txt"));
			String[] st = sc.next().split(",");
			MList list = null;
			SwapNodeKthNode sw = new SwapNodeKthNode();
			for(String s : st){
				int data = Integer.parseInt(s);
				list = sw.createList(list, data);
			}
			sw.printResult(list);
			sw.swapNode(list,2);
			System.out.println();
			sw.printResult(list);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	private int getLen(MList list){
		try{
			MList list1 = list;
			int count = 1;
			while(list1 != null){
				count++;
				list1 = list1.getNext();
			}
			return count;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	
	private void swapNode(MList list,int kth){
		try{
			MList x = list;
			MList prev_x = null;
			MList prev_y = null;
			MList y = list;
			for(int i = 0;i<kth;i++){
				prev_x = x;
				x = x.getNext();
			}
			for(int i =0;i<getLen(list)-kth;i++){
				prev_y = y;
				y = y.getNext();
			}
			if(prev_x!=null && prev_x.getNext()!=null){
				prev_x.setNext(y);
			}
			if(prev_y!=null && prev_y.getNext()!=null){
				prev_y.setNext(x);
			}
			MList temp = x.getNext();
			x.setNext(y.getNext());
			y.setNext(temp);
			//return list;
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	private MList createList(MList list,int data){
		try{
			MList node  = new MList(data);
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
	
	private void printResult(MList list){
		try{
			MList list1 = list;
			while(list1 != null){
				System.out.print(list1.getData()+",");
				list1 = list1.getNext();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
