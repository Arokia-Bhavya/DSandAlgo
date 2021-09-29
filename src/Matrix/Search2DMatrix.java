package Matrix;

import org.junit.Test;

import junit.framework.Assert;

public class Search2DMatrix {
	@Test
	public void example1()
	{
		Assert.assertEquals(false, searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}},13));
	}
	
	@Test
	public void example2()
	{
		Assert.assertEquals(true,searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}},3));
	}

	@Test
	public void example3()
	{
	Assert.assertEquals(true,searchMatrix(new int[][]{{1}},1));
	}
	
	@Test
	public void example4()
	{
	Assert.assertEquals(false,searchMatrix(new int[][]{{1},{3}},0));
	}

	/*O(logN)*/
	private boolean searchMatrix(int[][] input, int target) {
		if (input == null || input.length == 0 || input[0].length == 0) {
            return false;
        }
        int rows = input.length;
        int cols = input[0].length;
        int left = 0;
        int right = rows * cols - 1;
        int mid;

        while (left<=right) {
            mid = left + (right - left)/2;
            int num = input[mid/cols][mid%cols];
            if (target == num) {
                return true;
            } else if (num < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
	}
	
	

	

	/*O(m*n)*/
	private boolean searchMatrixUsingLinearSearch(int[][] input, int target) {
		for(int row=0;row<input.length;row++)
		{
			for(int col=0;col<input[row].length;col++)
			{
				if(input[row][col] == target)
					return true;
			}
		}
		
		return false;
	}

}
