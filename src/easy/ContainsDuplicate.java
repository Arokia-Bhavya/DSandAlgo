package easy;

import java.util.Arrays;
import java.util.HashMap;

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

	/*
	 * TC O(N) SC O(N)
	 */
	private boolean containsDuplicate(int[] inputArray) {
		HashMap<Integer,Integer> distinctMap=new HashMap<Integer,Integer>();
		boolean isDuplicate=false;

		for(int index=0;index<inputArray.length;index++)
		{
			if(distinctMap.containsKey(inputArray[index]))
				return true;
			else
				distinctMap.put(inputArray[index], 1);
		}
		return isDuplicate;
	}

	/*
	 * TC O(NlogN) SC O(1)
	 */
	private boolean containsDuplicateUsingSort(int[] inputArray) {
		Arrays.sort(inputArray);
		boolean isDuplicate=false;
		for(int index=1;index<inputArray.length;index++)
		{
			if(inputArray[index] == inputArray[index - 1])
				return true;
		}
		return isDuplicate;
	}

	/*
	 * BruteForce
	 * TC O(N2) SC O(1)
	 */
	private boolean containsDuplicateUsingBF(int[] inputArray) {
		boolean isDuplicate=false;
		for(int index=0;index<inputArray.length;index++)
		{
			for(int innerindex=index+1;innerindex<inputArray.length;innerindex++)
			{
				if(inputArray[index] == inputArray[innerindex])
				{
					return true;
				}
			}
		}
		return isDuplicate;
	}
	
	
}
