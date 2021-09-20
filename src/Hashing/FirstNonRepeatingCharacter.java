package Hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class FirstNonRepeatingCharacter {
	@Test
	public void example1()
	{
		Assert.assertEquals(0,findIndex("leetcode"));
	}
	
	@Test
	public void example2()
	{
		Assert.assertEquals(2,findIndex("loveleetcode"));
	}
	
	@Test
	public void example3()
	{
		Assert.assertEquals(-1,findIndex("aabb"));
	}

	/*O(n)*/
	private int findIndex(String input) {
		HashMap<Character,Integer> frequency=new HashMap<Character,Integer>();

		for(int index=0;index<input.length();index++)
		{
			if(frequency.containsKey(input.charAt(index)))
				frequency.put(input.charAt(index), -1);
			else
				frequency.put(input.charAt(index), index);
		}
		int min=Integer.MAX_VALUE;
		for(Map.Entry<Character,Integer> entry:frequency.entrySet())
		{
			if(entry.getValue()!=-1)
				min=Math.min(entry.getValue(), min);				
		}
		return min==Integer.MAX_VALUE? -1:min;
		
	}

	/* TC O(n2)*/
	private int findIndexUsingBruteForce(String input) {
		if(input.length()==0 || input.length()==1)
			return input.length() - 1;
		int output=-1;
		for(int index=0;index<input.length();index++)
		{
			boolean containsDuplicate=false;
			for(int loopIndex=0;loopIndex<input.length();loopIndex++)
			{
				if(index!=loopIndex && input.charAt(index) == input.charAt(loopIndex))
				{
					containsDuplicate=true;
					break;
				}
			}
			if(!containsDuplicate)
				return index;
		}
		return output;
	}
	
	

}
