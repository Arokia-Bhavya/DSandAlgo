package Matrix;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ReshapeMatrix {
	
	@Test
	public void example1()
	{
		Assert.assertArrayEquals(new int[][] {{1,2,3,4}}, reshape(new int[][] {{1,2},{3,4}},1,4));
	}
	
	
	@Test
	public void example2()
	{
		Assert.assertArrayEquals(new int[][] {{1,2},{3,4}}, reshape(new int[][] {{1,2},{3,4}},2,4));
	}


	private int[][] reshape(int[][] input, int rows, int cols) {
		if((input.length*input[0].length)!=(rows*cols))
			return input;
		int[][] output=new int[rows][cols];
		for(int count=0;count<rows*cols;count++)
			output[count/cols][count%cols]=input[count/input[0].length][count%input[0].length];
		return output;
	}


	/*
	 * TC O(m1*n1) + O(m2*n2)
	 * SC O(m1*n1)
	 */
	private int[][] reshapeUsingBruteForce(int[][] input, int rows, int cols) {

		if((input.length*input[0].length)!=(rows*cols))
		return input;
		int count=0;
		int[][] output=new int[rows][cols];
		List<Integer> inputElements=new ArrayList<Integer>();
		
		for(int r=0;r<input.length;r++)
		{
			for(int c=0;c<input[0].length;c++)
			{
				inputElements.add(count++, input[r][c]);
			}
		}
		count=0;
		for(int r=0;r<rows;r++)
		{
			for(int c=0;c<cols;c++)
			{
				output[r][c]=inputElements.get(count++);
			}
		}
		
		return output;
	}

}
