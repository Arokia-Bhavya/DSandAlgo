package Hashing;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Test;

import junit.framework.Assert;

public class ContainsDuplicate {
	
	@Test
	public void example1()
	{
		Assert.assertEquals(true, containsDuplicate(new int[] {1,2,3,1}));
	}
	
	@Test
	public void example2()
	{
		Assert.assertEquals(false, containsDuplicate(new int[] {1,2,3,4}));

	}
	
	@Test
	public void example3()
	{
		Assert.assertEquals(true, containsDuplicate(new int[] {1,1,1,3,3,4,3,2,4,2}));

	}
	public boolean containsDuplicate(int[] nums)
    {
        Arrays.sort(nums);
        for(int count=0;count<nums.length - 1;count++)
        {
            if(nums[count]==nums[count+1])
                return true;
        }
        return false;
    }
	
	public boolean containsDuplicateUsingHashing(int[] nums)
    {
        HashSet<Integer> unique=new HashSet<Integer>();
        for(int num:nums)
        {
            if(unique.contains(num))
                return true;
            else
                unique.add(num);
        }
        return false;
    }
	
	public boolean containsDuplicateUsingBruteForce(int[] nums) {
        for(int count=0;count<nums.length;count++)
        {
            for(int innerCount=0;innerCount<nums.length;innerCount++)
            {
                if(count!=innerCount && nums[count]==nums[innerCount])
                {
                    return true;
                }
            }
        }
        return false;
    }

}
