package SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;


public class FindLongestSubString {

	@Test
	public void example1()
	{
		Assert.assertEquals(3,lengthOfLongestSubstring("abcabcbb"));
	}
	@Test
	public void example2()
	{
		Assert.assertEquals(1,lengthOfLongestSubstring("bbbbb"));
	}
	@Test
	public void example3()
	{
		Assert.assertEquals(3,lengthOfLongestSubstring("pwwkew"));
	}
	
	@Test
	public void example4()
	{
		Assert.assertEquals(3,lengthOfLongestSubstring("aabaab!bb"));
	}
	
	@Test
	public void example5()
	{
		Assert.assertEquals(7,lengthOfLongestSubstring("bpfbhmipx"));
	}
	/*
	 * intialize wstart as 0 and keep adding the elements into set 
	 * when u hit a condition where ur element is not adding & calculate new length
	 * remove the elements from set till wstart
	 * change the wstart position to current one and repeat
	 * 
	 */
	 public int lengthOfLongestSubstring(String s) {
	        int max_len=0;	        
	        int wstart=0;
	        Set<Character> dup=new HashSet<Character>();
	        for(int count=0;count<s.length();count++)
	        {
	            if(!dup.add(s.charAt(count)))   
	            {
	                 max_len=Math.max(max_len,dup.size());
	                 int duplicateCharacterPosition=s.lastIndexOf(s.charAt(count),count-1);
	                 while(wstart<=duplicateCharacterPosition)
	                 {
	                     dup.remove(s.charAt(wstart++));
	                 }
	                 dup.add(s.charAt(count));
	             }
	         }
	        return Math.max(max_len,dup.size());
	    }
}
