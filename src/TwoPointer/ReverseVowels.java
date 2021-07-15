package TwoPointer;


import org.junit.Test;
import org.junit.Assert;


public class ReverseVowels {
	
	@Test
	public void example1()
	{
		Assert.assertEquals("holle", getReverseString("hello"));
	}


	@Test
	public void example2()
	{
		Assert.assertEquals("leotcede",  getReverseString("leetcode"));
	}
	
	
	
/*
 * TC O(n/2)
 * SC O(n)
 */
	private String getReverseString(String input) {
		
		char[] inputCharArray=input.toCharArray();
		for(int left=0,right=input.length() - 1;left<right;)
		{
			if(isVowel(inputCharArray[right]) && isVowel(inputCharArray[left]))
			{
				char temp=inputCharArray[left];
				inputCharArray[left]=inputCharArray[right];
				inputCharArray[right]=temp;
				left++;
				right--;
			}else if(!isVowel(inputCharArray[left]))
			{
				left++;
			}else if(!isVowel(inputCharArray[right]))
			{
				right--;
			}
		}
		
		return new String(inputCharArray);
	}
	private boolean isVowel(char value)
	{
		if(value=='a'||value=='e'||value=='i'||value=='o'||value=='u')
			return true;
		else
			return false;
	}
}
