package TwoPointer;

import org.junit.Test;

import junit.framework.Assert;

public class PallindromicSubstrings {
	
	@Test
	public void example1()
	{
		Assert.assertEquals(3, countSubstrings("abc"));
	}
	
	@Test
	public void example2()
	{
		Assert.assertEquals(6, countSubstrings("aaa"));
	}
	
	@Test
	public void example3()
	{
		Assert.assertEquals(1, countSubstrings("x"));
	}
	
	@Test
	public void example4()
	{
		Assert.assertEquals(4, countSubstrings("aba"));
	}

	@Test
	public void example5()
	{
		Assert.assertEquals(7, countSubstrings("xabax"));
	}
	

	@Test
	public void example6()
	{
		Assert.assertEquals(6, countSubstrings("xabay"));
	}

	private int countSubstrings(String input) {
		int count=input.length();
		for(int start=0;start<input.length();start++)
		{
			for(int end=start+1;end<input.length();end++)
			{
				if(isPallidrome(input,start,end))
					count++;
			}
		}
		return count;
	}

	private boolean isPallidrome(String input, int start, int end) {
		int left=start;
		int right=end;
		while(left<right)
		{
			if(input.charAt(left)!=input.charAt(right))
				return false;
			left++;
			right--;
		}
		return true;
	}

}
