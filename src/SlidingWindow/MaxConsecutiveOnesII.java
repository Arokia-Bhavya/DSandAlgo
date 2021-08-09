package SlidingWindow;

import org.junit.Assert;
import org.junit.Test;


public class MaxConsecutiveOnesII {
	@Test
	public void example1()
	{
		Assert.assertEquals(4, findMaxConsecutiveOnes(new int[] {1,0,1,1,0},1));
	}
	
	@Test
	public void example2()
	{
		Assert.assertEquals(3, findMaxConsecutiveOnes(new int[] {1,0,1,0,1},1));
	}
	
	@Test
	public void example3()
	{
		Assert.assertEquals(6, findMaxConsecutiveOnes(new int[] {1,1,1,0,0,0,1,1,1,1,0},2));
	}
	
	@Test
	public void example4()
	{
		Assert.assertEquals(10, findMaxConsecutiveOnes(new int[] {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1},3));
	}
	

	public int findMaxConsecutiveOnes(int[] nums,int flipCount) {
        int zerosCount=0;
        int start=0;
        int end=0;
        int maxlen=0;
        for(;end<nums.length;end++)
        {
        	if(nums[end]==0)
        	{
        		zerosCount++;
        	}
        	
        	while(zerosCount > flipCount)
        	{
        		if(nums[start]==0)
        			zerosCount --;
        		start++;
        		
        	}
        	maxlen=Math.max(maxlen, (end - start) + 1);
        }
        
        return maxlen;
    }
}
