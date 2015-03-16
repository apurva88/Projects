package com.practice.matrix;

//Print a matrix in spiral form
public class SpiralPrint {

	//Complexity: O(n)
	public static void main(String []args){
		
		 int mat[][] ={{10, 20, 30, 40},{15, 25, 35, 45},{27, 29, 37, 48},{2,4,6,7}};

		 int m =mat.length;
		 int n=mat[0].length;
		 
		 //Last row and column
		 int rowIndex = m-1, colIndex=n-1;
		 
		 //First row and column
		 int i =0, j=0;
		 
		 
		 while(i<=rowIndex && j<=colIndex){
			 
			//print the first row
			 for(int k =j;k<=colIndex;k++){
				 System.out.print(mat[i][k]+" ");
				 
			 }
			 
			 //Increase the first row number
			 i++;
			 
			 //Print the last column
			 for(int l=i;l<=rowIndex;l++){
				 System.out.print(mat[l][colIndex]+" ");
			 }
			 colIndex--;
			 
			 //Print the bottom row
			 if(rowIndex>i){
			 for(int o = colIndex; o>=j;o--){
				 System.out.print(mat[rowIndex][o]+" ");
			 }
			 rowIndex--;
			 }
			 
			//Print the first column
			 if (colIndex>j) {
				for (int p = rowIndex; p >= i; p--) {
					System.out.print(mat[p][j] + " ");
				}
				//Increase the first column number
				j++;
			}
		 }
	}

}
