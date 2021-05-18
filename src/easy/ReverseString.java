package easy;

import org.junit.Assert;
import org.junit.Test;

public class ReverseString {
	
	@Test
	public void example1()
	{
		Assert.assertArrayEquals(new char[] {'h','e','l','l','o'}, reverseString(new char[] {'o','l','l','e','h'}));
	}
	
	@Test
	public void example2()
	{
		Assert.assertArrayEquals(new char[] {'H','a','n','n','a','h'}, reverseString(new char[] {'h','a','n','n','a','H'}));
	}

	/*
	 * 2 Pointer Approach
	 * TC O(n)
	 * SC O(1)
	 */
	private char[] reverseString(char[] s) {
		for(int left=0,right=s.length -1 ;left<right;left++,right--)
        {
            char tmp=s[left];
            s[left]=s[right];
            s[right]=tmp;
        }
		return s;
	}

}
