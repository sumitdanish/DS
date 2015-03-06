package com.aorg.MyPractice.DS.TreePractice;

import java.io.File;
import java.util.Scanner;

public class BSTToDLL2nd {

	/**
	 * @param args
	 */
	static TreeNode dll = null;
	public static void main(String[] args) {
		try{
			Scanner sc = new Scanner(new File("tree.txt"));
			BSTToDLL2nd bstToDll = new BSTToDLL2nd();
			TreeNode tree = null;
			String[] st = sc.next().split(",");
			for(String s : st){
				int data = Integer.parseInt(s);
				tree = bstToDll.createTree(tree, data);
			}
			TreeNode dll = bstToDll.convertBStToDLL(tree);
			bstToDll.printDLL(dll);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	
	private void printDLL(TreeNode dll){
		try{
			TreeNode tn = dll;
			while(tn!=null){
				System.out.print(tn.getData()+",");
				tn = tn.getRight();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	private TreeNode convertBStToDLL(TreeNode tn){
		try{
			if(tn == null){
				return tn;
			}
			fixLeftOrPre(tn);
			return fixRightOrNext(tn);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	
	
	private void fixLeftOrPre(TreeNode tn){
		try{
			if(tn == null){
				return;
			}
			fixLeftOrPre(tn.getLeft());
			tn.setLeft(dll);
			dll = tn;
			fixLeftOrPre(tn.getRight());
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private TreeNode fixRightOrNext(TreeNode tn){
		try{
			if(tn == null){
				return null;
			}
			TreeNode pre = null;
			while(tn!=null && tn.getRight() != null){
				tn = tn.getRight();
			}
			while(tn!=null && tn.getLeft() != null){
				pre = tn;
				tn = tn.getLeft();
				tn.setRight(pre);
			}
			return tn;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	private TreeNode createTree(TreeNode tree,int data){
		try{
			TreeNode tn = new TreeNode(data);
			if(tree == null){
				tree = tn;
				return tree;
			}
			if(data > tree.getData()){
				tree.setRight(createTree(tree.getRight(), data));
			}
			if(data < tree.getData()){
				tree.setLeft(createTree(tree.getLeft(), data));
			}
			return tree;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	
}
