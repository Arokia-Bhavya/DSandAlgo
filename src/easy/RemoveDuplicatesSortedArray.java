package easy;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class RemoveDuplicatesSortedArray {
	
	@Test
	public void example1()
	{
		Assert.assertEquals(2, removeDuplicatesUsingExtraSpace(new int[] {1,1,2}));
	}

	@Test
	public void example2()
	{
		Assert.assertEquals(5, removeDuplicatesUsingExtraSpace(new int[] {0,0,1,1,1,2,2,3,3,4}));
	}
	/*
	 * Time Complexity : O(N)
	 * Space Complexity : O(N)
	 */
	
	public int removeDuplicatesUsingExtraSpace( int[] nums)
	{
		int output_index=0;
		int[] output_array=new int[nums.length];
		output_array[output_index] = nums[output_index];
		for(int index=1;index<nums.length;index++)
		{
			if(nums[index - 1]!=nums[index])
			{	
				output_index++;
				output_array[output_index]=nums[index];					
			}
		}
		System.arraycopy(output_array, 0, nums, 0, nums.length);
		return output_index+1;
	}
	
	/*
	 * Time Complexity : O(N)
	 * Space Complexity : O(1)
	 */
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
