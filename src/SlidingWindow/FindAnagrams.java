package SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class FindAnagrams {
	
	@Test
	public void example1()
	{
		List<Integer> expectedOutput=new ArrayList<Integer>();
		expectedOutput.add(0);
		expectedOutput.add(6);
		List<Integer> actualOutput=getStartIndicesAnagram("cbaebabacd","abc");		
		Assert.assertTrue(actualOutput.containsAll(expectedOutput));
	}

	
	@Test
	public void example2()
	{
		List<Integer> expectedOutput=new ArrayList<Integer>();
		expectedOutput.add(0);
		expectedOutput.add(1);
		expectedOutput.add(2);		
		List<Integer> actualOutput=getStartIndicesAnagram("abab","ab");
		Assert.assertTrue(actualOutput.containsAll(expectedOutput));
	}
	
	@Test
	public void example3()
	{
		List<Integer> expectedOutput=new ArrayList<Integer>();		
		expectedOutput.add(1);			
		List<Integer> actualOutput=getStartIndicesAnagram("baa","aa");
		Assert.assertTrue(actualOutput.containsAll(expectedOutput));
	}
	
	private List<Integer> getStartIndicesAnagram(String input, String anagram) {
		List<Integer> output=new ArrayList<Integer>();
		int target = anagram.length();
		int[] anagramArr=new int[26];
		for(char value:anagram.toCharArray())
		{
			anagramArr[value - 'a']++;
		}
		int[] current_window=new int[26];
		for(int count=0;count<target;count++)
		{
			current_window[input.charAt(count) - 'a']++;
		}
		if(isAnagramMatch(current_window,anagramArr))
			output.add(0);
		for(int count=0;count<input.length() - target;count++)
		{
				current_window[input.charAt(count) - 'a']--;
				current_window[input.charAt(count+target) - 'a']++;				
				if(isAnagramMatch(current_window,anagramArr))
					output.add(count+1);
		}
		return output;
	}
	private boolean isAnagramMatch(int[] current_window, int[] anagramArr) {
		
		return Arrays.equals(current_window, anagramArr);
	}


	/*
	 * get the current window and check whether it s anagram
	 * keep removing character from left and adding character in right
	 * when found anagram add the index to output
	 * Iterate till u meet the length - target
	 */
	private List<Integer> getStartIndicesAnagramUsingSubstring(String input, String anagram) {
		List<Integer> output=new ArrayList<Integer>();
		int target = anagram.length();
		for(int count=0;count<=input.length() - target;count++)
		{
			
				String current_window=input.substring(count, count + target);
				if(isValidAnagram(current_window,anagram))
					output.add(count);
				
			
		}
		return output;
	}


	private boolean isValidAnagram(String current_window, String anagram) {
		char[] currentArray=current_window.toCharArray();
		char[] anagramArray=anagram.toCharArray();
		Arrays.sort(currentArray);
		Arrays.sort(anagramArray);
		return Arrays.equals(currentArray,anagramArray);
	}

}
