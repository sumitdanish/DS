package com.aorg.MyPractice.DS.TreePractice;

import java.io.File;
import java.util.Scanner;

public class BinaryTreeToDLL1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			Scanner sc = new Scanner(new File("tree.txt"));
			String[] st = sc.next().split(",");
			BinaryTreeToDLL1 bi = new BinaryTreeToDLL1();
			TreeNode tree = null;
			for(String s : st){
				int data = Integer.parseInt(s);
				tree = bi.createTree(tree, data);
			}
			bi.createDLL(tree);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	private void createDLL(TreeNode tree){
		try{
			TreeNode tr = createBTToDLL(tree);
			TreeNode t2 = printTreeToDLL(tr);
			printTree(t2);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private void printTree(TreeNode tree){
		try{
			TreeNode t = tree;
			while(t != null){
				System.out.print(t.getData()+",");
				t = t.getRight();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private TreeNode printTreeToDLL(TreeNode tree){
		try{
			TreeNode t = tree;
			while(t.getLeft() != null){
				//System.out.print(t.getData()+",");
				t = t.getLeft();
			}
			return t;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	
	private TreeNode createBTToDLL(TreeNode root){
		try{
			if(root == null){
				return root;
			}
			if(root.getLeft() != null){
				TreeNode tr1 = createBTToDLL(root.getLeft());
				for(;tr1.getRight()!=null;tr1 = tr1.getRight());
				tr1.setRight(root);
				root.setLeft(tr1);
			}
			if(root.getRight()!=null){
				TreeNode tr2 = createBTToDLL(root.getRight());
				for(;tr2.getLeft()!=null;tr2 = tr2.getLeft());
				tr2.setLeft(root);
				root.setRight(tr2);
			}
			return root;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	
	private TreeNode createTree(TreeNode tree,int data){
		try{
			TreeNode root = new TreeNode(data);
			if(tree == null){
				tree = root;
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
