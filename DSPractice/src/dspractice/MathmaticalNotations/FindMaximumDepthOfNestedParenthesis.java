package com.aorg.MyPractice.DS.MathmaticalNotations;

public class FindMaximumDepthOfNestedParenthesis {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			String str = "(((X))(((Y))))";
			int max = new FindMaximumDepthOfNestedParenthesis().maxDepthOfStringParenth(str);
			System.out.println(max);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	
	private int maxDepthOfStringParenth(String str){
		try{
			int max = Integer.MIN_VALUE;
			int count = 0;
			for(int i=0;i<str.length();i++){
				if(str.charAt(i) == '('){
					count++;
					if(count > max){
						max = count;
					}
				}else if(str.charAt(i) == ')'){
					if(count>0){
						count--;
					}else{
						return -1;
					}
				}
			}
			return max;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	
}
