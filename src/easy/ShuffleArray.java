package easy;

import org.junit.Assert;
import org.junit.Test;

public class ShuffleArray {
	
	@Test
	public void example1()
	{
		Assert.assertArrayEquals(new int[] {2,3,5,4,1,7}, shuffle(new int[] {2,5,1,3,4,7},3));
	}
	
	@Test
	public void example2()
	{
		Assert.assertArrayEquals(new int[] {1,4,2,3,3,2,4,1}, shuffle(new int[] {1,2,3,4,4,3,2,1},4));
	}
	
	@Test
	public void example3()
	{
		Assert.assertArrayEquals(new int[] {2,3,5,4,1,7}, shuffle(new int[] {2,5,1,3,4,7},3));
	}

	/*SC O(n) TC O(n/2)*/
	private int[] shuffleUsingExtraSpace(int[] nums, int n) {
		int[] output=new int[nums.length];
        int index=0;
        for(int left1=0,left2=n;left1<nums.length && left2<nums.length;)
        {
           output[index++]=nums[left1++];
           output[index++]=nums[left2++];  
        }
        return output;
	}
	
	/*TC O(n)*/
	private int[] shuffle(int[] nums, int n) {		
        for(int index=n;index<nums.length;index++)
        {
        	nums[index] =(nums[index] *1024) + nums[index - n];
        }
        
        for(int index=0,pair=n;index<nums.length;pair++)
        {
        	nums[index++]=nums[pair]%1024;
        	nums[index++]=nums[pair]/1024;  
        }
        
       
        return nums;
	}

}
