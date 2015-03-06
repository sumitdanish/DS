package com.aorg.MyPractice.DS.Array;

public class IsLandProblem {

	/**
	 * @param args
	 */
	static int row = 5;
	static int col = 5;
	public static void main(String[] args) {
		try{
			int[][] mat = {
					{ 1, 1, 0, 0, 0 }, 
					{ 0, 1, 0, 0, 1 },
					{ 1, 0, 0, 1, 1 }, 
					{ 0, 0, 0, 0, 0 }, 
					{ 1, 0, 1, 0, 1 } 
				 };
			int count = new IsLandProblem().getCount(mat);
			System.out.println(count);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	private int getCount(int[][] mat){
		try{
			int count = 0;
			boolean[][] visited = new boolean[row][col];
			for(int i=0;i<row;i++){
				for(int j=0;j<col;j++){
					visited[i][j] = false;
				}
			}
			for(int i=0;i<row;i++){
				for(int j=0;j<col;j++){
					if(mat[i][j] ==1 && visited[i][j] == false){
						getIsLandVisited(i, j, visited, mat);
						count++;
					}
				}
			}
			return count;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	
	private void getIsLandVisited(int r,int c,boolean[][] visited,int[][] mat){
		try{
			int[] x = {1,1,1,0,-1,-1,-1,0};
			int[] y = {1,0,-1,-1,-1,0,1,0};
			visited[r][c] = true;
			for(int i=0;i<x.length;i++){
				if(x[i]+c >=0&&x[i]+c<col && y[i]+r>=0&& y[i]+r<row && isValid(y[i]+r, x[i]+c, mat, visited)){
					getIsLandVisited(y[i]+r, x[i]+c, visited, mat);
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	private boolean isValid(int r,int c,int[][] mat,boolean[][] visited){
		try{
				if(r < row && c < col && mat[r][c] == 1 && visited[r][c] == false){
					return true;
				}
				return false;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
}
