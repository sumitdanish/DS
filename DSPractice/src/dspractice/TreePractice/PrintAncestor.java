package com.aorg.MyPractice.DS.TreePractice;

import java.io.File;
import java.util.Scanner;
import java.util.Stack;

public class PrintAncestor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			Scanner sc = new Scanner(new File("tree.txt"));
			String[] st = sc.next().split(",");
			PrintAncestor pr = new PrintAncestor();
			TreeNode tree = null;
			for(String s : st){
				int data = Integer.parseInt(s);
				tree = pr.createTree(tree, data);
			}
			 pr.printAncestorUsingStack(tree,new TreeNode(14));
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	private boolean printAncestorRecur(TreeNode tn,TreeNode targetNode){
		try{
			if(tn == null){
				return false;
			}
			if(tn.getData() == targetNode.getData()){
				return true;
			}
			if(printAncestorRecur(tn.getLeft(), targetNode) || printAncestorRecur(tn.getRight(), targetNode)){
				System.out.print(tn.getData()+",");
				return true;
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	
	private void printAncestorUsingStack(TreeNode tn,TreeNode targetData){
		try{
			Stack<TreeNode> st = new Stack<TreeNode>();
			TreeNode root = tn;
			while(true){
				while(root!=null && root.getLeft()!=null){
					st.push(root);
					root = root.getLeft();
				}
				if(root!=null&&root.getData() == targetData.getData()){
					break;
				}
				if(st.peek().getRight() == null){
					root = st.pop();
					while(!st.isEmpty() && st.peek().getRight() == root){
						root = st.pop();
					}
				}
				root = st.isEmpty()?null:st.peek().getRight();
			}
			while(!st.isEmpty()){
				System.out.print(st.pop().getData()+",");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private TreeNode createTree(TreeNode tn,int data){
		try{
			TreeNode root = new TreeNode(data);
			if(tn == null){
				tn = root;
				return tn;
			}
			if(data > tn.getData()){
				tn.setRight(createTree(tn.getRight(), data));
			}
			if(data < tn.getData()){
				tn.setLeft(createTree(tn.getLeft(), data));
			}
			return tn;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	
}
