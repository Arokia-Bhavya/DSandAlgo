package TwoPointer;

import org.junit.Assert;
import org.junit.Test;

public class TwoSumSorted {
	
	@Test
	public void example1()
	{
		Assert.assertArrayEquals(new int[] {1,2}, findIndices(new int[] {2,7,11,15},9));
	}
	
	@Test
	public void example2()
	{
		Assert.assertArrayEquals(new int[] {1,3}, findIndices(new int[] {2,3,4},6));	}
	
	@Test
	public void example3()
	{
		Assert.assertArrayEquals(new int[] {1,2}, findIndices(new int[] {-1,0},-1));
	}
	/*
	 * 2 pointer
	 * O(n)
	 */

	private int[] findIndices(int[] numbers, int target) {
		int start=0;
        int end=numbers.length - 1;
        for(;start<end;)
        {
            if(numbers[start]+numbers[end]==target)
            {
                
                return new int[] {start+1,end+1};
            }else if(numbers[start]+numbers[end]<target)
                 start++;
             else
                end--;
        }
        return new int[] {-1,-1};
	}
	

}
