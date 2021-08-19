package SlidingWindow;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;


public class MaxSumSubArray {
	
	@Test
	public void example1()
	{
		Assert.assertEquals(6,getMaxSumSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
	}
	
	@Test
	public void example2()
	{
		Assert.assertEquals(1,getMaxSumSubArray(new int[] {1}));

	}
	
	@Test
	public void example3()
	{
		Assert.assertEquals(23,getMaxSumSubArray(new int[] {5,4,-1,7,8}));

	}

	/*
	 * keep adding the elements 
	 */

	private int getMaxSumSubArray(int[] inputArray) {
		int total=0;
		int max=0;
		for(int index=0;index<inputArray.length;index++)
		{
			total=total+inputArray[index];
			max=Math.max(max, total);
		}
		return max;
	}

}
