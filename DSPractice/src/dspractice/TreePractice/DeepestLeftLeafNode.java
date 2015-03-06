package com.aorg.MyPractice.DS.TreePractice;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DeepestLeftLeafNode {

	/**
	 * @param args
	 */
	static int max = Integer.MIN_VALUE;
	static int count = 0;
	static TreeNode t1;
	public static void main(String[] args) {
		try{
			Scanner sc = new Scanner(new File("tree.txt"));
			String[] st = sc.next().split(",");
			DeepestLeftLeafNode dl = new DeepestLeftLeafNode();
			TreeNode tree = null;
			for(String s : st){
				int data = Integer.parseInt(s);
				tree = dl.crateTree(tree, data);
			}
			dl.printTree(tree);
			
			int count = 0;
			System.out.println("\n");
			dl.byLevelOrder(tree);
//			boolean isLeft = false;
//			dl.deepestLeftLeaf(tree,isLeft);
//			System.out.println(t1.getData());
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	public DeepestLeftLeafNode(){
		t1 = new TreeNode();
	}
	
	private void deepestLeftLeaf(TreeNode tree,boolean isLeft){
		try{
			if(tree == null){
				return;
			}
			count++;
			if(tree.getLeft() == null && tree.getRight() == null &&isLeft == true){
				
				//System.out.println(tree.getData());
				if(count > max){
					max = count;
					t1.setData(tree.getData());
				}
				return;
			}
			deepestLeftLeaf(tree.getLeft(),true);
			deepestLeftLeaf(tree.getRight(),false);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	
	private void printTree(TreeNode tree){
		try{
			if(tree != null){
				printTree(tree.getLeft());
				System.out.print(tree.getData()+",");
				printTree(tree.getRight());
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	private TreeNode crateTree(TreeNode tree,int data){
		try{
			  if(tree == null){
				  tree = new TreeNode(data);
				  return tree;
			  }
			  if(data < tree.getData()){
				  tree.setLeft(crateTree(tree.getLeft(), data));
			  }else if(data > tree.getData()){
				  tree.setRight(crateTree(tree.getRight(), data));
			  }
			  return tree;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	
	private void byLevelOrder(TreeNode tree){
		try{
			Queue<TreeNode>  q1 = new LinkedList<TreeNode>();
			Queue<Integer>   q2 = new LinkedList<Integer>();
			TreeNode t3 = null;
			int lev = 0;
			boolean isLeft = false;
			q2.add(lev);
			q1.add(tree);
			while(!q1.isEmpty() && !q2.isEmpty()){
				TreeNode t1 = q1.peek();q1.poll();
				lev = q2.peek();q2.poll();
				if(t1.getLeft()!=null){
					q1.add(t1.getLeft());
					q2.add(lev+1);
					isLeft = true;
					t3 = t1.getLeft();
				}
				if(t1.getRight() != null){
					q1.add(t1.getRight());
					q2.add(lev+1);
				}
			}
			if(isLeft == true){
				System.out.println(t3.getData());
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
}
