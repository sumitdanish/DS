package com.aorg.MyPractice.DS.TreePractice;

import java.io.File;
import java.util.Scanner;
import java.util.Stack;

public class IterativePostOrderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			Scanner sc = new Scanner(new File("tree.txt"));
			String[] st = sc.next().split(",");
			IterativePostOrderTraversal it = new IterativePostOrderTraversal();
			TreeNode root = null;
			for(String s : st){
				int data = Integer.parseInt(s);
				root = it.createTree(root, data);
			}
			it.printPostOrder1(root);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	
	/*By Using two stack*/
	
	private void printPostOrder(TreeNode tn){
		try{
			Stack<TreeNode> st = new Stack<TreeNode>();
			Stack<TreeNode> st1 = new Stack<TreeNode>();
			TreeNode root = tn;
			st.push(root);
			while(!st.isEmpty()){
				TreeNode temp = st.pop();
				st1.push(temp);
				if(temp.getRight() != null){
					st.push(temp.getRight());
				}
				if(temp.getLeft() != null){
					st.push(temp.getLeft());
				}
			}
			while(!st1.isEmpty()){
				System.out.print(st1.pop().getData()+",");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private void printPostOrder1(TreeNode tree){
		try{
			Stack<TreeNode> st1 = new Stack<TreeNode>();
			TreeNode tn = tree;
			do{
				while(tn !=null){
					if(tn.getRight() != null){
						st1.push(tn.getRight());
					}
					st1.push(tn);
					tn = tn.getLeft();
				}
				tn = st1.pop();
				if(!st1.isEmpty()&&tn.getRight() != null && st1.peek() == tn.getRight()){
				 st1.pop();
					st1.push(tn);
					tn = tn.getRight();
				}else{
					System.out.print(tn.getData()+",");
					tn = null;
				}
			}while(!st1.isEmpty());
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
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
