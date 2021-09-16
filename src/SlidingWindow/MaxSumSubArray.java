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

	private int getMaxSumSubArrayUsingBruteForce(int[] nums) {
		int max = nums[0];
		int cur_sum = nums[0];
		for(int index=0;index<nums.length;index++)
		{
			cur_sum = nums[index];
			max=Math.max(cur_sum, max);
			for(int loopIndex=index + 1;loopIndex<nums.length;loopIndex++)
			{	
				cur_sum=cur_sum+nums[loopIndex];
				max=Math.max(cur_sum, max);
			}
		}
		return max;
	}
	/*
	 * check whether the cur+sum + cur_element > cur_sum
	 * then add otherwise ignore previous elements and set cur_element as cur_sum
	 * keep setting the maximum element;
	 */

	private int getMaxSumSubArray(int[] nums) {
		int max = nums[0];
	    int cur_sum = nums[0];
		for(int index=1;index<nums.length;index++)
		{
			
			cur_sum=(cur_sum + nums[index]) > nums[index] ? cur_sum + nums[index]:nums[index];			
			max=Math.max(cur_sum, max);
		}
		return max;
	}

}
