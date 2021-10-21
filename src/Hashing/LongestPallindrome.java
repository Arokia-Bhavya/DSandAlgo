package Hashing;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

public class LongestPallindrome {

	@Test
	public void example1()
	{
		Assert.assertEquals(7, findMaxLength("abccccdd"));
	}
	
	@Test
	public void example2()
	{
		Assert.assertEquals(1, findMaxLength("a"));
	}
	
	@Test
	public void example3()
	{
		Assert.assertEquals(2, findMaxLength("bb"));
	}

	private int findMaxLength(String input) {
		HashMap<Character,Integer> frequency=new HashMap<Character,Integer>();
		for (char value:input.toCharArray())
		{
			frequency.put(value, frequency.getOrDefault(value, 0) + 1);
		}
		int length=0;
		for(Map.Entry<Character,Integer> entry:frequency.entrySet())
		{
			
			 length += entry.getValue() / 2 * 2;
	         if (length % 2 == 0 && entry.getValue() % 2 == 1)
	            	length++;
		}
		return length;
	}
}
