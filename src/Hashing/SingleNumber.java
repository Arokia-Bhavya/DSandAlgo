package Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

public class SingleNumber {
	@Test
	public void example1()
	{
		Assert.assertEquals(1, singleNumber(new int[] {2,2,1}));
	}
	
	@Test
	public void example2()
	{
		Assert.assertEquals(4, singleNumber(new int[] {4,1,2,1,2}));
	}
	
	@Test
	public void example3()
	{
		Assert.assertEquals(1, singleNumber(new int[] {1}));
	}

	/* TC O(N) SC O(1)*/
    public int singleNumber(int[] inputArray) {
        int output=0;
		for (int num : inputArray) {
	        output ^= num;
	      }
	    return output;

    }
    
    /*
	 * TC O(n) SC O(n)
	 */
	private int getSingleNumberUsingMath(int[] inputArray) {
		HashSet<Integer> set=new HashSet<Integer>();
		int sumOfNum=0;
		int sumOfSet=0;
		for (int num:inputArray)
		{
			if(set.add(num))
				sumOfSet+=num;
			sumOfNum+=num;
		}
		
		return 2*sumOfSet - sumOfNum;
	}

	/*
	 * TC O(n) SC O(n)
	 */
	private int getSingleNumberUsingHashing(int[] inputArray) {
		HashMap<Integer,Integer> frequencyMap=new HashMap<Integer,Integer>();
		for(int num:inputArray)
		{
			frequencyMap.put(num, frequencyMap.getOrDefault(num, 0)+1);
				
		}
		for(Map.Entry<Integer,Integer> map:frequencyMap.entrySet())
		{
			if(map.getValue() == 1)
				return map.getKey();
		}
		return -1;
	}

	/*
	 * TC O(n2) SC O(n)
	 */
	private int getSingleNumberUsingBF(int[] inputArray) {
		ArrayList<Integer> inputList=new ArrayList<Integer>();
		for(int num:inputArray)
		{
			if(inputList.contains(num))
				inputList.remove(new Integer(num));
			else
				inputList.add(num);
		}
		return inputList.get(0);
	}
}
