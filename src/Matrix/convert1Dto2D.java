package Matrix;

import org.junit.Assert;
import org.junit.Test;

public class convert1Dto2D {
	
	@Test
	public void example1()
	{
		Assert.assertArrayEquals(new int[][] {{1,2},{3,4}}, constructArray(new int[] {1,2,3,4},2,2));
	}
	
	@Test
	public void example2()
	{
		Assert.assertArrayEquals(new int[0][0], constructArray(new int[] {1,2},1,3));
	}

	
	@Test
	public void example3()
	{
		Assert.assertArrayEquals(new int[0][0], constructArray(new int[] {3},1,2));
	}

	
	@Test
	public void example4()
	{
		Assert.assertArrayEquals(new int[][] {{1,2,3}}, constructArray(new int[] {1,2,3},1,3));
	}


	private Object[] constructArray(int[] original,int m,int n) {
		int[][] output=new int[m][n];
        if(original.length != (m*n))
            return new int[0][0];
        for(int index=0;index<original.length;index++)
        {
        	output[index/n][index%n]=original[index];
        }
        return output;
	}

	/*O(m*n)*/
	private int[][] constructArrayUsingBruteForce(int[] original,int m,int n) {
		 int[][] output=new int[m][n];
	        if(original.length != (m*n))
	            return new int[0][0];
	        int index=0;
	        for(int r=0;r<m;r++)
	        {
	            for(int c=0;c<n;c++)
	            {
	                output[r][c]=original[index++];
	            }
	        }
	        return output;
	}

}
