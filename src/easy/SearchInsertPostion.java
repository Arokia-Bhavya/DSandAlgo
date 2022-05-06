package easy;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class SearchInsertPostion {
	@Test
	public void example1()
	{
		Assert.assertEquals(2,search(new int[] {1,3,5,6},5));
	}
	
	
	@Test
	public void example2()
	{
		Assert.assertEquals(1,search(new int[] {1,3,5,6},2));
	}
	
	@Test
	public void example3()
	{
		Assert.assertEquals(4,search(new int[] {1,3,5,6},7));
	}
	
	/* binary search recursive*/
	private int search(int[] nums , int target) {
		
		int start=0;
		int end=nums.length -1;
		return binarySearch(nums,target,start,end);
	}


	private int binarySearch(int[] nums, int target,int start, int end) {
		int  mid=(start + end)/2;
		while(start<=end)
		{
			if(nums[mid]==target)
				return mid;
			if(nums[mid]<target)
				return binarySearch(nums,target,mid+1,end);
			else
				return binarySearch(nums,target,start,mid-1);
		}
		return mid+1;
	}


	/* binary search iterative*/
	private int iterativeSearch(int[] nums, int target) {
		int start = 0;
	    int end = nums.length - 1;
	    int mid =0;
		while(start<=end)
		{
			mid = (start + end)/2;
			if(nums[mid]==target)
			{
				return mid;
			}
			if(nums[mid]<target)
			{
				start = mid + 1;			
			}else
			{
				end=mid-1;
			}
		}
		return mid+1;
	}


	/* using built in library TC O(logn)*/
	private int searchBuiltIn(int[] nums, int target) {
		int position=Arrays.binarySearch(nums, target);		
		return position<0?Math.abs(position) -1:position;
	}

	/* linear search TC O(n)*/
	private int linearsearch(int[] nums, int target) {
		for(int index=0;index<nums.length;index++)
        {
            if(nums[index]>=target)
                return index;
        }
        return nums.length;
	}

}
