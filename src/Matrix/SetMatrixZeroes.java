package Matrix;

import org.junit.Assert;
import org.junit.Test;

public class SetMatrixZeroes {
	@Test
	public void example1()
	{
		Assert.assertArrayEquals(new int[][] {{1,0,1},{0,0,0},{1,0,1}}, setMatrixZero(new int[][] {{1,1,1},{1,0,1},{1,1,1}}));
	}

	@Test
	public void example2()
	{
		Assert.assertArrayEquals(new int[][] {{0,0,0,0},{0,4,5,0},{0,3,1,0}}, setMatrixZero(new int[][] {{0,1,2,0},{3,4,5,2},{1,3,1,5}}));
	}
	
	@Test
	public void example3()
	{
		Assert.assertArrayEquals(new int[][] {{0,0}}, setMatrixZero(new int[][] {{0,1}}));
	}
	
	private int[][] setMatrixZero(int[][] matrix) {		
	      for(int r=0;r<matrix.length;r++)
	        for(int c=0;c<matrix[0].length;c++)
	        	if(matrix[r][c]==0)
	                setNegativeOnes(matrix,r,c);	               
	        
	      for(int r=0;r<matrix.length;r++)
	       	for(int c=0;c<matrix[0].length;c++)
	           if(matrix[r][c]==-1)
	              matrix[r][c]=0;
	      return matrix;
	               
	}
	public void setNegativeOnes(int[][] matrix,int i ,int j) {
		int rows = matrix.length, cols = matrix[0].length;
		int ind = i - 1;
        while (ind >= 0) {
            if (matrix[ind][j] != 0) {
                matrix[ind][j] = -1;
            }
            ind--;
        }
        ind = i + 1;
        while (ind < rows) {
            if (matrix[ind][j] != 0) {
                matrix[ind][j] = -1;
            }
            ind++;
        }
        ind = j - 1;
        while (ind >= 0) {
            if (matrix[i][ind] != 0) {
                matrix[i][ind] = -1;

            }
            ind--;
        }
        ind = j + 1;
        while (ind < cols) {
            if (matrix[i][ind] != 0) {
                matrix[i][ind] = -1;

            }
            ind++;
        }
    }


}
