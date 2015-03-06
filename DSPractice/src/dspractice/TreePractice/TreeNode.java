package com.aorg.MyPractice.DS.TreePractice;

public class TreeNode {

	
	private int data;
	private TreeNode next;
	private TreeNode left;
	private TreeNode right;
	private String strData;
	
	public TreeNode(){
		
	}
	public TreeNode(String strData){
		this.strData = strData;
	}
	public TreeNode(int data){
		this.data = data;
	}
	public void setStrData(String strData){
		this.strData = strData;
	}
	public void setLeft(TreeNode left){
		this.left = left;
	}
	public void setRight(TreeNode right){
		this.right = right;
	}
	public void setData(int data){
		this.data = data;
	}
	public void setNext(TreeNode next){
		this.next = next;
	}
	
	public String getStrDAta(){
		return strData;
	}
	public int getData(){
		return data;
	}
	public TreeNode getNext(){
		return next;
	}
	public TreeNode getRight(){
		return right;
	}
	public TreeNode getLeft(){
		return left;
	}
}
