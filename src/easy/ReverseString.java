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
	 * TC O(n/2)
	 * SC O(1)
	 */
	private char[] reverseStringUsing2pointerApproach(char[] s) {
		for(int left=0,right=s.length -1 ;left<right;left++,right--)
        {
            char tmp=s[left];
            s[left]=s[right];
            s[right]=tmp;
        }
		return s;
	}

	/*
	 * Using Recursion
	 * TC O(n/2)
	 * SC O(1)
	 */
	private char[] reverseString(char[] input)
	{
		return helper(0,input.length - 1,input);
	}

	private char[] helper(int left, int right, char[] input) {
		
		if(left>=right)
			return input;
		char tmp=input[left];
		input[left++]=input[right];
		input[right--]=tmp;
		
		return helper(left,right,input);
	}
}
