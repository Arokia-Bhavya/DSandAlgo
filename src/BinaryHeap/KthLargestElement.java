package BinaryHeap;

import java.util.Arrays;
import java.util.PriorityQueue;

import org.junit.Assert;
import org.junit.Test;

public class KthLargestElement {

	@Test
	public void example1()
	{
		Assert.assertEquals(5, findKthLargest(new int[] {3,2,1,5,6,4},2));
	}
	
	@Test
	public void example2()
	{
		Assert.assertEquals(4, findKthLargest(new int[] {3,2,3,1,2,4,5,5,6},4));
	}

	private int findKthLargest(int[] nums, int k) {
		
		PriorityQueue<Integer> pq=new PriorityQueue<Integer>((a,b)->b-a);
		for(int index=0;index<nums.length;index++)
		{
			pq.add(nums[index]);
		}
		while(--k>0)
		{
			pq.poll();
		}
		
		return pq.peek();
	}

	private int findKthLargestUsingSorting(int[] nums,int k) {

		Arrays.sort(nums);
		return nums[nums.length-k];
	}
	
}
