package SlidingWindow;

import org.junit.Assert;
import org.junit.Test;

public class MaxSumSubArray {
	
	@Test
	public void example1()
	{
		Assert.assertEquals(11,getMaxSumSubArray(3,new int[] {1, 5, -1, 6, 3, 2}));
	}
	
	@Test
	public void example2()
	{
		Assert.assertEquals(8,getMaxSumSubArray(2,new int[] {4, 2, 3, 5, 1}));
	}
	
	@Test
	public void example3()
	{
		Assert.assertEquals(104,getMaxSumSubArray(3,new int[] {23, 10, 5, 12, 3, 89, -10}));
	}
	
	@Test
	public void example4()
	{
		Assert.assertEquals(37,getMaxSumSubArray(4,new int[] {2, 4, 8, 1, 5, 8, 9, 11, 7, 10}));
	}
	
	@Test
	public void example5()
	{
		Assert.assertEquals(20,getMaxSumSubArray(2,new int[] {2, 4, 8, 1, 5, 8, 9, 11, 7, 10}));
	}

	/* intialize window sum and then set the max as window sum 
	 * keep adding the values towards right and subtracting from left
	 * set the max value between max and window sum 
	 * TC O(n) SC O(1)
	 */
	private int getMaxSumSubArray(int target, int[] inputArray) {
		int count=0;
		int window_sum=0;
		int max=0;
		while (count < target)
		{
			window_sum=window_sum + inputArray[count++];
		}
		max=window_sum;
		for(;count<inputArray.length;count++)
		{
			window_sum=window_sum - inputArray[count - target] + inputArray[count];
			max=Math.max(max, window_sum);
		}
		return max;
	}
	/* TC O(n*m) SC O(1)*/

	private int getMaxSumSubArrayUsingBF(int[] nums) {
        int max=Integer.MIN_VALUE;
        for(int outerLoop=0;outerLoop<nums.length;outerLoop++)
        {
            int sum=0;
            for(int innerLoop=outerLoop;innerLoop<nums.length;innerLoop++)
            {
                sum=sum+nums[innerLoop];
                if(sum>max)
                    max=sum;
            }
        }
        
        return max;
    }
}
