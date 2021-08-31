package Hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

public class FindDuplicateNumber {

	@Test
	public void example1()
	{
		Assert.assertEquals(2, find(new int[] {1,3,4,2,2}));
	}
	
	

	@Test
	public void example2()
	{
		Assert.assertEquals(3, find(new int[] {3,1,3,4,2}));
	}
	
	@Test
	public void example3()
	{
		Assert.assertEquals(1, find(new int[] {1,1}));
	}
	
	@Test
	public void example4()
	{
		Assert.assertEquals(1, find(new int[] {1,1,2}));
	}
	
	@Test
	public void example5()
	{
		Assert.assertEquals(2, find(new int[] {2,2,2,2,2}));
	}
	@Test
	public void example6()
	{
		Assert.assertEquals(2, find(new int[] {8,7,1,10,17,15,18,11,16,9,19,12,5,14,3,4,2,13,18,18}));
	}
	/*
	 * 
	 * 
	 */
	
	private int find(int[] nums) {
		for(int index=0;index<nums.length;index++)
		{
			if(nums[index]!=(index+1))
			{
				int last=nums[index] - 1;
				if(nums[index]!=nums[last])
				{
					int tmp=nums[index];
					nums[index]=nums[last];
					nums[last]=tmp;
				}
				else
					return nums[index];
			}
		}
		return -1;
	}



	private int findUsingSort(int[] nums) {
		Arrays.sort(nums);
		int left=0;
		for(int right=1;right<nums.length;right++)
		{
			if(nums[left++]==nums[right])
				return nums[right];
		}
		
		return -1;
	}

	private int findUsingHashSet(int[] nums) {
		HashSet<Integer> set=new HashSet<Integer>();
		for(int num:nums)
		{
			if(set.contains(num))
				return num;
			else
				set.add(num);
		}
		
		return -1;
	}



	private int findUsingHashMap(int[] nums) {
		HashMap<Integer,Integer> frequencyMap=new HashMap<Integer,Integer>();
		int result=-1;
		for(int num:nums)
		{
			frequencyMap.put(num, frequencyMap.getOrDefault(num, 0)+1);
		}
		result=frequencyMap.entrySet().stream().filter(element->element.getValue() >=2)
		.map(element -> element.getKey()).findFirst().get();
		
		return result;
	}



	private int findUsingBF(int[] nums) {
		for(int num:nums)
		{
			int count=0;
			for(int duplicateNum:nums)
			{
				if(num==duplicateNum)
					count++;
			}
			if(count>=2)
				return num;
		}
		
		return -1;
	}
}
