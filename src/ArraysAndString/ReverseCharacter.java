package ArraysAndString;

import org.junit.Assert;
import org.junit.Test;

public class ReverseCharacter {
	@Test
	public void example1()
	{
		Assert.assertArrayEquals(new char[]{'o','l','l','e','h'}, reverse(new char[]{'h','e','l','l','o'}));
	}
	
	
	@Test
	public void example2()
	{
		Assert.assertArrayEquals(new char[]{'h','a','n','n','a','H'}, reverse(new char[]{'H','a','n','n','a','h'}));

	}
	
	private char[] reverse(char[] input) {
		int left=0;
		int right=input.length - 1;
		while(left<right)
		{
			char temp=input[left];
			input[left]=input[right];
			input[right]=temp;
			left++;
			right--;
		}
		
		return input;
	}

}
