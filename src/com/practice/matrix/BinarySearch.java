package com.practice.matrix;

public class BinarySearch {
	
	public static void main(String[]args){
		 int mat[][] ={{10, 20, 30, 40},{15, 25, 35, 45},{27, 29, 37, 48},{32, 33, 39, 50}};
		 findNumber(mat, 100);
	}
	
	/* start with i=0, j=n-1 where n is number of columns
	 * compare key with element i,j if key is less then j--, if key is more i++
	 * if equal print
	 * 
	 * Complexity O(n)
	 * */
	public static void findNumber(int[][]M,int key){
		if(M.length>0){
		int m = M.length;
		int n = M[0].length;
		
		int i =0, j=n-1;
		
		while(i<m && j>=0){
			
			//compare key with element at i,j
			if(M[i][j]==key){
				
				System.out.println("Number is at "+i+","+j);
				return;
			}
			if(M[i][j]<key){
			//number is not in this row
				i++;
				
			}
			else{
				//Number might be in this row and other column
				j--;
			}
			
		}
		
		System.out.println("Number not found");
		
		}
		
	}

}
