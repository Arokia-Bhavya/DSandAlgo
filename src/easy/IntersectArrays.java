package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class IntersectArrays {
	@Test
	public void example1()
	{
		Assert.assertArrayEquals(new Integer[] {2,2}, getIntersectArrays(new int[] {1,2,2,1},new int[] {2,2}));
	}
	
	@Test
	public void example2()
	{
		Assert.assertArrayEquals(new Integer[] {4,9}, getIntersectArrays(new int[] {4,9,5},new int[] {9,4,9,8,4}));
	}
	
	@Test
	public void example3()
	{
		Assert.assertArrayEquals(new Integer[] {2}, getIntersectArrays(new int[] {1,2,2,1},new int[] {2}));
	}
	/*
	 * 2 pointer approach
	 * TC : O(nlogn) O(m+n)
	 * SC : O(n)
	 */

	private Integer[] getIntersectArrays(int[] inputArray1, int[] inputArray2) {
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
		Integer[] arr = new Integer[outputlist.size()];        	
		
		return outputlist.toArray(arr);
	}

}
