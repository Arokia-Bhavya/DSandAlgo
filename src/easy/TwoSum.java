package easy;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

public class TwoSum {
	
	@Test
	public void example1()
	{
		Assert.assertArrayEquals(new Integer[] {0,1}, twoSum(new Integer[] {2,7,11,15},9));
	}
	
	@Test
	public void example2()
	{
		Assert.assertArrayEquals(new Integer[] {1,2}, twoSum(new Integer[] {3,2,4},6));
	}
	
	@Test
	public void example3()
	{
		Assert.assertArrayEquals(new Integer[] {0,1}, twoSum(new Integer[] {3,3},6));
	}
	/*
    TC O(n2)
    SC O(1)
    */
    public Integer[] twoSum(Integer[] nums, int target) {
        for(int index=0;index<nums.length - 1;index++)
        {
            for(int innerindex=index+1;innerindex<nums.length;innerindex++)
            {
                if((nums[index] + nums[innerindex]) == target)
                    return new Integer[]{index,innerindex};
            }
        }
         return new Integer[]{-1,-1};
    }
    
    /*
    TC O(n)
    SC O(n)
    */
    public Integer[] twoSumUsingOnePass(Integer[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for (int index=0;index<nums.length;index++)
        {
            if(map.containsKey(nums[index]))
            {
                return new Integer[]{map.get(nums[index]),index}  ;                         
            }else
            {
                map.put(target - nums[index],index);                                
            }
                                             
        }
        
            return new Integer[]{-1,-1};
        
    }
    /*
    TC O(n)
    SC O(n)
    */
    public Integer[] twoSumUsing2Pass(Integer[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for (int index=0;index<nums.length;index++)
        {
            map.put(target - nums[index],index);
        }
        for (int index=0;index<nums.length;index++)
        {
            if(map.containsKey(nums[index]) && index!=map.get(nums[index]))
                return new Integer[] {map.get(nums[index]),index};
        }
            return new Integer[]{-1,-1};
        
    }
    }
