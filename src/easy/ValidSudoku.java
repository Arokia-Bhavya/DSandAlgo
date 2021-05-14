package easy;

import java.util.HashMap;

import org.junit.Test;

import junit.framework.Assert;

public class ValidSudoku {
	
	@Test
	public void example1()
	{
		Assert.assertEquals(true, isValidSudoku(new char[][] 
				{{'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}}));
				
	}
	
	@Test
	public void example2()
	{
		Assert.assertEquals(false, isValidSudoku(new char[][] 
				{{'.','.','.','.','5','.','.','1','.'},
			   	 {'.','4','.','3','.','.','.','.','.'},
				 {'.','.','.','.','.','3','.','.','1'},
				 {'8','.','.','.','.','.','.','2','.'},
				 {'.','.','2','.','7','.','.','.','.'},				 
				 {'.','1','5','.','.','.','.','.','.'},
				 {'.','.','.','.','.','2','.','.','.'},
				 {'.','2','.','9','.','.','.','.','.'},
				 {'.','.','4','.','.','.','.','.','.'}}));
					
		}
/*
 * TC O(n2)
 * SC O(n)
 */
	private boolean isValidSudoku(char[][] board) {
		for(int index=0;index<board.length;index++)
        {
            HashMap<Character,Integer> map=new HashMap<Character,Integer>();
            for(int innerindex=0;innerindex<board.length;innerindex++)
            {
                if(map.containsKey(board[index][innerindex]) && board[index][innerindex]!='.')
                    return false;
                else
                    map.put(board[index][innerindex],1);
            }
            map.clear();
            
            for(int innerindex=0;innerindex<board.length;innerindex++)
            {

                if(map.containsKey(board[innerindex][index]) && board[innerindex][index]!='.')
                    return false;
                else
                    map.put(board[innerindex][index],1);
            }
        }
		
		  for (int row = 0 ; row < 9; row = row + 3) {
			    for (int col = 0; col < 9; col = col + 3) {
			    	
		            HashMap<Character,Integer> map=new HashMap<Character,Integer>();
		            System.out.println();
			    	for(int r=row;r<row+3;r++)
		            {
			    		for(int c=col;c<col+3;c++)
			            {
			    			if(map.containsKey(board[r][c]) && board[r][c]!='.')
			                    return false;
			                else
			                    map.put(board[r][c],1);
			            }
		            }
			    }
		  }
        return true;
	}

}
