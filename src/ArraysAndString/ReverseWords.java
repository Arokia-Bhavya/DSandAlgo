package ArraysAndString;

import org.junit.Test;

import junit.framework.Assert;

public class ReverseWords {
	@Test
	public void example1()
	{
		Assert.assertEquals("blue is sky the", reverseWord("the sky is blue"));
	}
	
	@Test
	public void example2()
	{
		Assert.assertEquals("world hello", reverseWord("  hello world  "));
	}
	
	@Test
	public void example3()
	{
		Assert.assertEquals("example good a", reverseWord("a good   example"));
	}

	private String reverseWord(String input) {
    input=input.strip();
    for(int left=0,right=input.indexOf(" ");right<input.length();)
    {
    	
    }
    return input;
	}

}
