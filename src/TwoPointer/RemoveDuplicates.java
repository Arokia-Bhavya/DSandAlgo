package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class RemoveDuplicates {

	@Test
	public void example1()
	{
		int[] input=new int[] {1,1,2};		
		input=Arrays.copyOf(input,removeDuplicates(input));
		Assert.assertArrayEquals(new int[] {1,2}, input);
	}
	@Test
	public void example2()
	{
		int[] input=new int[] {0,0,1,1,1,2,2,3,3,4};
		input=Arrays.copyOf(input,removeDuplicates(input));
		Assert.assertArrayEquals(new int[] {0,1,2,3,4}, input);	
	}
	/*
	 * TC O(n) SC O(1)
	 */
	
	private int removeDuplicates(int[] inputArray) {		
		if(inputArray.length == 0 || inputArray.length == 1)
			return inputArray.length;
		int len=1;
		for(int left=1;left<inputArray.length -1;left++)
		{
			if(inputArray[left]!=inputArray[left+1])
			{
				inputArray[len++]=inputArray[left+1];
			}
		}
		return len;
	}
}
