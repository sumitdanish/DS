package com.aorg.MyPractice.DS.Array;

public class CountNumberOfIsland {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			int row = 6;
			int col = 3;
			char[][] mat=  {
								{'X', 'O', 'O', 'O', 'O', 'O'},
								{'X', 'O', 'X', 'X', 'X', 'X'},
								{'O', 'O', 'O', 'O', 'O', 'O'},
								{'X', 'X', 'X', 'O', 'X', 'X'},
								{'X', 'X', 'X', 'O', 'X', 'X'},
								{'O', 'O', 'O', 'O', 'X', 'X'},
		             		};
			int count = new CountNumberOfIsland().count(mat, row, col);
			System.out.println(count);
		
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	private int count(char[][] mat,int row,int col){
		try{
			int i=0;
			int j=0;
			int count = 0;
			for(i = 0;i<row;i++){
				for(j =0;j<col;j++){
					if(mat[i][j] == 'X'){
						if((j == 0 || mat[i][j-1] == 'O') &&
						   (i == 0 || mat[i-1][j] == 'O')){
							count++;
						}
					}
				}
			}
			return count;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	
}
