package SlidingWindow;

import org.junit.Assert;
import org.junit.Test;


public class MaxConsecutiveOnes {
	@Test
	public void example1()
	{
		Assert.assertEquals(3, findMaxConsecutiveOnes(new int[] {1,1,0,1,1,1}));
	}
	
	@Test
	public void example2()
	{
		Assert.assertEquals(2, findMaxConsecutiveOnes(new int[] {1,0,1,1,0,1}));
	}
	
	

	public int findMaxConsecutiveOnes(int[] nums) {
        int window_length=0;
        int maxlen=0;
        for(int count=0;count<nums.length;count++)
        {
            if(nums[count]!=1)
            {
                maxlen=Math.max(window_length,maxlen);
                window_length=0;
            }else
              window_length++;  
        }
        return Math.max(window_length,maxlen);
    }
}
