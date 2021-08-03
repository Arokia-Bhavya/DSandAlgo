package SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
	
	@Test
	public void example3()
	{
		Assert.assertEquals(0, countGoodSubStrings("x",3));
	}
	
	
	/*O(n)*/

	private int countGoodSubStrings(String input, int target) {
		int output=0;
		char[] inputCharArray=input.toCharArray();
		int wstart=0;
		Map<Character,Integer> dup=new HashMap<Character,Integer>();
		if(input.length() < target)
			return output;
		while(wstart<target)
		{
			dup.put(inputCharArray[wstart],dup.getOrDefault(inputCharArray[wstart],0)+1);
			wstart++;
		}
		if(dup.size() == target)
			output++;
		for(;wstart<input.length();wstart++)
		{
			
			dup.put(inputCharArray[wstart - target],dup.getOrDefault(inputCharArray[wstart - target],0)-1);
			if(dup.get(inputCharArray[wstart - target]) == 0)
				dup.remove(inputCharArray[wstart - target]);
			dup.put(inputCharArray[wstart],dup.getOrDefault(inputCharArray[wstart],0)+1);		
			
			if(dup.size() == target)
				output++;			
		}
		return output;
	}

	/* TC O(n*k) SC O(1)*/
	private int countGoodSubStringsUsingBF(String input, int target) {
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
