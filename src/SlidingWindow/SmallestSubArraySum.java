package SlidingWindow;
import org.junit.Assert;
import org.junit.Test;

public class SmallestSubArraySum {
	@Test
	public void example1()
	{
		Assert.assertEquals(2, minSubArrayLen(7,new int[]{2,3,1,2,4,3}));
	}
	
	@Test
	public void example2()
	{
		Assert.assertEquals(1, minSubArrayLen(4,new int[]{1,4,4}));
	}
	
	@Test
	public void example3()
	{
		Assert.assertEquals(0, minSubArrayLen(11,new int[]{1,1,1,1,1,1,1,1}));
	}
	
	@Test
	public void example4()
	{
		Assert.assertEquals(2, minSubArrayLen(7,new int[]{4,1,5,2,4,1}));
	}
	
	/*
	 * Keep adding the elements and check whether it equals the target
	 * then set the min value of the length of array between left and right pointer
	 * if it exceeds the target subtract the left pointer
	 */
public int minSubArrayLen(int target, int[] nums) {
	 int min=Integer.MAX_VALUE;
	 int left=0;
	 int current_sum=nums[left];
	 for(int right=1;right<=nums.length - 1 && left<=nums.length - 1;)
	 {
		 if(current_sum == target)
		 {
			 min=Math.min(min, right - left);
			 current_sum = current_sum - nums[left++];
		 }else if(current_sum > target)
		 {
			 current_sum = current_sum - nums[left++];
			 
		 }else
		 {
			 current_sum = current_sum + nums[right++];			 
		 }
       
    }
	 
	 return min==Integer.MAX_VALUE? 0:min;
	}
}
