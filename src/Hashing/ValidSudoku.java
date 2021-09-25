package Hashing;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class ValidSudoku {
	
	@Test
	public void example1()
	{
		Assert.assertEquals(true, isValidSudoku(new char[][] {
			{'5','3','.','.','7','.','.','.','.'}
		   ,{'6','.','.','1','9','5','.','.','.'}
		   ,{'.','9','8','.','.','.','.','6','.'}
			,{'8','.','.','.','6','.','.','.','3'}
			,{'4','.','.','8','.','3','.','.','1'}
			,{'7','.','.','.','2','.','.','.','6'}
			,{'.','6','.','.','.','.','2','8','.'}
			,{'.','.','.','4','1','9','.','.','5'}
			,{'.','.','.','.','8','.','.','7','9'}}));
	}
	
	@Test
	public void example2()
	{
		Assert.assertEquals(false, isValidSudoku(new char[][] {
			{'8','3','.','.','7','.','.','.','.'}
		   ,{'6','.','.','1','9','5','.','.','.'}
		   ,{'.','9','8','.','.','.','.','6','.'}
		   ,{'8','.','.','.','6','.','.','.','3'}
			,{'4','.','.','8','.','3','.','.','1'}
			,{'7','.','.','.','2','.','.','.','6'}
			,{'.','6','.','.','.','.','2','8','.'}
			,{'.','.','.','4','1','9','.','.','5'}
			,{'.','.','.','.','8','.','.','7','9'}}));
	}
	
	@Test
	public void example3()
	{
		Assert.assertEquals(false, isValidSudoku(new char[][]{			
		{'.','.','.','.','5','.','.','1','.'},
		{'.','4','.','3','.','.','.','.','.'},
		{'.','.','.','.','.','3','.','.','1'},
		{'8','.','.','.','.','.','.','2','.'},
		{'.','.','2','.','7','.','.','.','.'},
		{'.','1','5','.','.','.','.','.','.'},
		{'.','.','.','.','.','2','.','.','.'},
		{'.','2','.','9','.','.','.','.','.'},
		{'.','.','4','.','.','.','.','.','.'}}));
	}

	private boolean isValidSudoku(char[][] input) {
		for(int row=0;row<input.length;row++)
		{
			Set<Character> rowSet=new HashSet<Character>();
			Set<Character> colSet=new HashSet<Character>();
			Set<Character> boxSet=new HashSet<Character>();
			System.out.println();
			for(int col=0;col<input.length;col++)
			{
				if(input[row][col] !='.' && (!rowSet.add(input[row][col])))								
						return false;	
				if(input[col][row] !='.' && (!colSet.add(input[col][row])))
						return false;
				int rowIndex=3*(row/3)+(col/3);
				int colIndex=3*(row%3)+(col%3);
				System.out.print("["+rowIndex+","+colIndex+"]");
				if(input[rowIndex][colIndex] !='.' && (!boxSet.add(input[rowIndex][colIndex])))
					return false;
			}
		}
		return true;
			
	}

	private Object isValidSudokuUsingStrings(char[][] input) {
		Set<String> set=new HashSet<String>();		
		for(int row=0;row<input.length;row++)
		{
			for(int col=0;col<input.length;col++)
			{
				char current_val=input[row][col];
				if(current_val!='.')
				{
					if(!set.add(current_val+"found in row"+row)||
					!set.add(current_val+"found in col"+col)||
					!set.add(current_val+"found in box"+(row/3)+"-"+(col/3)))
							return false;
				}
			}
		}
		return true;
	}

	/*
	 * O(m*n)2
	 */
	private boolean isValidSudokuBruteForce(char[][] input) {		
		for(int row=0;row<input.length;row++)
		{
			Set<Character> rowSet=new HashSet<Character>();
			Set<Character> colSet=new HashSet<Character>();
			for(int col=0;col<input.length;col++)
			{
				if(input[row][col] !='.')
				{
					if(!rowSet.add(input[row][col]))
						return false;
				}
				
				if(input[col][row] !='.')
				{
					if(!colSet.add(input[col][row]))
						return false;
				}
			}
		}
			
			for(int row=0;row<input.length;row=row+3)
			{
				for(int col=0;col<input.length;col=col+3)
				{
					/*[0,0],[0,1],[0,2],[1,0],[1,1],[1,2],[2,0],[2,1],[2,2]
					 *[0,3],[0,4],[0,5],[1,3],[1,4],[1,5],[2,3],[2,4],[2,5]
					 *[0,6],[0,7],[0,8],[1,6],[1,7],[1,8],[2,6],[2,7],[2,8]
					 *[3,0],[3,1],[3,2],[4,0],[4,1],[4,2],[5,0],[5,1],[5,2]
					 *
					 */
					Set<Character> boxSet=new HashSet<Character>();
					for(int r=row;r<row+3;r++)
					{
						for(int c=col;c<col+3;c++)
						{
							if(input[r][c] !='.')
							{
								if(!boxSet.add(input[r][c]))
									return false;
							}
						}						
					}
				}		
				
			
		}
		
		return true;
	}

}
