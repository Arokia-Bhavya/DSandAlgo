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
        int window_length=0;
        int maxlen=0;
        int localFlipCount=flipCount;
        for(int count=0;count<nums.length;count++)
        {
            if(nums[count]!=1 && localFlipCount==0)
            {
                maxlen=Math.max(window_length,maxlen);
                window_length=1;
                localFlipCount=flipCount - 1;
            }else if(nums[count]!=1 && localFlipCount>0)
            {
            	localFlipCount--;
            	window_length++; 
            }
            else
              window_length++;  
        }
        return Math.max(window_length,maxlen);
    }
}
