package com.aorg.MyPractice.DS.TreePractice;

import java.util.Arrays;

public class CalculateTheDigitCombination {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			int[] a = {1,2,1,2,4,1,7,5,9,1};
			TreeNode tn =null;
			CalculateTheDigitCombination cal = new CalculateTheDigitCombination();
			cal.printCombination(cal.createDigit(a,0,new String()));
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	private TreeNode createDigit(int[] a,int data,String str){
		try{
			if(data > 26){
				return null;
			}
			String s = new String();
			if(data != 0){
				s = str+String.valueOf(data)+",";
			}
			TreeNode tn = new TreeNode(s);
			if(a.length != 0){
				data = a[0];
				int[] newArray = Arrays.copyOfRange(a,1,a.length);
				tn.setLeft(createDigit(newArray, data, s));
				if(a.length > 1){
					data = a[0]*10+a[1];
					newArray = Arrays.copyOfRange(a,2,a.length);
					tn.setRight(createDigit(newArray, data, s));
				}
			}
			return tn;
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	private void printCombination(TreeNode tn){
		try{
			if(tn == null){
				return;
			}
			if(tn.getLeft() == null && tn.getRight() == null){
				System.out.println(tn.getStrDAta());
			}
			printCombination(tn.getLeft());
			printCombination(tn.getRight());
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
}
