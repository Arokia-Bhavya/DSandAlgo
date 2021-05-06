package easy;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class RemoveDuplicatesSortedArray {
	
	@Test
	public void example1()
	{
		Assert.assertEquals(2, removeDuplicates(new int[] {1,1,2}));
	}

	@Test
	public void example2()
	{
		Assert.assertEquals(5, removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4}));
	}
	
	public int removeDuplicates( int[] nums)
	{
		int left=0;
		for(int right=1;right<nums.length;right++)
		{
			if(nums[left]!=nums[right])
			{	
				left++;
				nums[left]=nums[right];					
			}
		}
		return left+1;
	}
}
