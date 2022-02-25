package ArraysAndString;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;

public class MissingNumber {

	@Test
	public void example1()
	{
		Assert.assertEquals(2, missingNumber(new int[] {3,0,1}));
	}
	
	@Test
	public void example2()
	{
		Assert.assertEquals(2, missingNumber(new int[] {0,1}));
	}
	
	@Test
	public void example3()
	{
		Assert.assertEquals(8, missingNumber(new int[] {9,6,4,2,3,5,7,0,1}));
	}
	
	/*TC O(n) SC O(1)*/
	public int missingNumber(int[] nums) {
        int n=nums.length;
        int expectedSum=(n*(n+1))/2;
        int actualSum=0;
        for(int num:nums)
        {
            actualSum=actualSum+num;
        }
        return expectedSum -  actualSum;
    }
	/*TC O(n) SC O(n)*/
	public int missingNumberUsingHashing(int[] nums)
    {
        Set<Integer> num_set = new HashSet<Integer>();
        for(int num:nums)
        {
            num_set.add(num);
        }
        for(int index=0;index<=nums.length;index++)
        {
            if(!num_set.contains(index))
                return index;
        }
        return -1;
    }
	/*TC O(nlogn)*/
    public int missingNumberUsingSorting(int[] nums)
    {
        Arrays.sort(nums);
        for(int index=0;index<nums.length;index++)
        {
            if(index!=nums[index])
                return index;
        }
        return nums.length;
    }
    /*TC O(n2)*/
    public int missingNumberUsingBruteForce(int[] nums) {
        
        for(int index=nums.length;index>=0;index--)
        {
            boolean missingNumberFound=true;
            for(int loopIndex=0;loopIndex<nums.length;loopIndex++)
            {
                if(index==nums[loopIndex])
                {
                    missingNumberFound=false;
                    break;
                }
            }
            if(missingNumberFound)
                return index;
        }
        return -1;
        
    }
}
