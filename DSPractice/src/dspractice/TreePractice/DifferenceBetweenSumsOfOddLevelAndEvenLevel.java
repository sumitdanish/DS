package com.aorg.MyPractice.DS.TreePractice;

import java.io.File;
import java.util.Scanner;

public class DifferenceBetweenSumsOfOddLevelAndEvenLevel {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			Scanner sc = new Scanner(new File("tree.txt"));
			String[] st = sc.next().split(",");
			DifferenceBetweenSumsOfOddLevelAndEvenLevel diff = new DifferenceBetweenSumsOfOddLevelAndEvenLevel();
			TreeNode tn = null;
			for(String s : st){
				int data = Integer.parseInt(s);
				tn = diff.crateTree(tn, data);
			}
			int di = diff.getDiff(tn);
			System.out.println(di);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	private int getDiff(TreeNode tn){
		try{
			if(tn == null){
				return 0;
			}
			return tn.getData() - (getDiff(tn.getLeft())+getDiff(tn.getRight()));
	}catch(Exception  ex){
		ex.printStackTrace();
	} 
		return -1;
	}
	
	private TreeNode crateTree(TreeNode tn,int data){
		try{
			
			if(tn == null){
				TreeNode tree = new TreeNode(data);
				tn = tree;
				return tn;
			}
			if(data > tn.getData()){
				tn.setRight(crateTree(tn.getRight(), data));
			}
			if(data < tn.getData()){
				tn.setLeft(crateTree(tn.getLeft(), data));
			}
			return tn;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
}
