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

	private boolean searchMatrix(int[][] input, int target) {
		if (input == null || input.length == 0 || input[0].length == 0) {
            return false;
        }
        int row = input.length;
        int col = input[0].length;
        int start = 0;
        int end = row * col - 1;
        int mid;

        while (start + 1 < end) {
            mid = start + (end - start)/2;
            int num = input[mid/col][mid%col];
            if (target == num) {
                return true;
            } else if (num < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return (input[start/col][start%col] == target || input[end/col][end%col] == target);
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
