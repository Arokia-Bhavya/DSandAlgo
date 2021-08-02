package SlidingWindow;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;


public class SubStringSize {
	@Test
	public void example1()
	{
		Assert.assertEquals(1, countGoodSubStrings("xyzzaz",3));
	}
	
	@Test
	public void example2()
	{
		Assert.assertEquals(4, countGoodSubStrings("aababcabc",3));
	}
	
	
	/* O(n*k)*/

	private int countGoodSubStrings(String input, int target) {
		int output=0;
		char[] inputCharArray=input.toCharArray();
		for(int count=0;count<=input.length() -target;count++)
		{
			if(isNonRepeating(inputCharArray,count,count+target,target))
				output++;
			
		}
		return output;
	}

	private boolean isNonRepeating(char[] inputCharArray, int start, int end,int target) {
		Set<Character> dup=new HashSet<Character>();
		while(start<end)
		{
			dup.add(inputCharArray[start++]);
		}
		return dup.size()==target?true:false;
	}
}
