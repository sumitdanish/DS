package com.aorg.MyPractice.DS.TreePractice;

import java.lang.reflect.Array;
import java.util.Arrays;

public class PostOrderPrintFromGivenInorderPreOrder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			 int[] in = { 4, 2, 5, 1, 3, 6 };
			 int[] pre = {1, 2, 4, 5, 3, 6 };
			 new PostOrderPrintFromGivenInorderPreOrder().printPost(pre, in, in.length);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	private void printPost(int[] pre,int[] ino,int ind){
		try{
			int root = getIndex(ino,pre[0],ind);
			if(root != -1){
				int[] pre1 = Arrays.copyOfRange(pre,1,pre.length-1);
				printPost(pre1, ino, root);
			}
			if(root != ind-1){
				int[] ino1 = Arrays.copyOfRange(ino,root+1,ino.length-1);
				int[] pre1 = Arrays.copyOfRange(pre, root+1,pre.length-1);
				printPost(pre1, ino1, ind-root-1);
			}
			System.out.print(pre[0]+",");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	
	
	private int getIndex(int[] inOr,int key,int n){
		try{
			for(int i=0;i<n;i++){
				if(inOr[i] == key){
					return i;
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	
}
