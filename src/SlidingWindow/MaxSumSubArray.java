package SlidingWindow;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;


public class MaxSumSubArray {
	
	@Test
	public void example1()
	{
		Assert.assertEquals(6,getMaxSumSubArrayBF2(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
	}
	
	@Test
	public void example2()
	{
		Assert.assertEquals(1,getMaxSumSubArrayBF2(new int[] {1}));

	}
	
	@Test
	public void example3()
	{
		Assert.assertEquals(23,getMaxSumSubArrayBF2(new int[] {5,4,-1,7,8}));

	}
	
	@Test
	public void example4()
	{
		Assert.assertEquals(1,getMaxSumSubArrayBF2(new int[] {-2,1}));

	}
	/*TC O(n3)*/
	private int getMaxSumSubArrayBF1(int[] nums)
	{
		int max=Integer.MIN_VALUE;	
		
		for(int index1=0;index1<nums.length;index1++)
		{
			
			for(int index2=index1;index2<nums.length;index2++)
			{
				int sum=0;
				for(int index3=index1;index3<=index2;index3++)
				{
					sum=sum+nums[index3];
					
				}
				max=Math.max(max, sum);
			}			
		}
		return max;
	}
	
	/*TC O(n2)*/
	private int getMaxSumSubArrayBF2(int[] nums)
	{
		int max=Integer.MIN_VALUE;	
		
		for(int index1=0;index1<nums.length;index1++)
		{
			int sum=0;	
			for(int index2=index1;index2<nums.length;index2++)
			{							
				sum=sum+nums[index2];
				max=Math.max(max, sum);
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
