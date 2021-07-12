package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class IntersectArrays {
	@Test
	public void example1()
	{
		Assert.assertArrayEquals(new int[] {2,2}, getIntersectArrays(new int[] {1,2,2,1},new int[] {2,2}));
	}
	
	@Test
	public void example2()
	{
		Assert.assertArrayEquals(new int[] {9,4}, getIntersectArrays(new int[] {4,9,5},new int[] {9,4,9,8,4}));
	}
	
	@Test
	public void example3()
	{
		Assert.assertArrayEquals(new int[] {2}, getIntersectArrays(new int[] {1,2,2,1},new int[] {2}));
	}
	/*
	 * 2 pointer approach
	 * TC : O(nlogn) O(m+n)
	 * SC : O(n)
	 */

	private int[] getIntersectArraysUsing2PointerApproach(int[] inputArray1, int[] inputArray2) {
		List<Integer> outputlist=new ArrayList<Integer>();
		Arrays.sort(inputArray1);
		Arrays.sort(inputArray2);
		for(int left1=0,left2=0;left1<inputArray1.length && left2<inputArray2.length;)
		{
			if(inputArray1[left1]==inputArray2[left2])
			{
				outputlist.add(inputArray1[left1]);
				left1++;
				left2++;
			}else if(inputArray1[left1]<inputArray2[left2])
				left1++;
			else
				left2++;
		}
		int[] output = new int[outputlist.size()];    
		int count=0;
		for(int num:outputlist)
		{
			output[count++]=num;
		}
		
		return output;
	}
	
	/*
	 * TC:
	 * SC:
	 */
	private int[] getIntersectArrays(int[] inputArray1, int[] inputArray2)
	{
		List<Integer> outputlist=new ArrayList<Integer>();

		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		for(int num:inputArray1)
		{
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		
		for(int index=0;index<inputArray2.length;index++)
		{
			if(map.containsKey(inputArray2[index]))
			{
				if(map.get(inputArray2[index])>1)
					map.put(inputArray2[index], map.get(inputArray2[index]) - 1);
				else
				{
					map.remove(inputArray2[index]);
					
				}
				outputlist.add(inputArray2[index]);
			}
		}
		
		
		int[] output = new int[outputlist.size()];    
		int count=0;
		for(int num:outputlist)
		{
			output[count++]=num;
		}   	

		return output;
	}

}
