package TwoPointer;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class RemoveAllOccurences {

	@Test
	public void example1()
	{
		int[] input=new int[] {10,30,40,10,10};
		input=Arrays.copyOf(input,removeElement(input,10));
		Assert.assertArrayEquals(input,new int[] {30,40});
	}
	@Test
	public void example2()
	{
		int[] input=new int[] {30,30,30,30,30,30};
		input=Arrays.copyOf(input,removeElement(input,30));
		Assert.assertArrayEquals(input,new int[] {});
	}
	@Test
	public void example3()
	{
		int[] input=new int[] {10,50,30,17};
		input=Arrays.copyOf(input,removeElement(input,5));
		Assert.assertArrayEquals(input,new int[] {10,50,30,17});
	}
	@Test
	public void example4()
	{
		int[] input=new int[] {4,7,6,7,8,7,7};
		input=Arrays.copyOf(input,removeElement(input,7));
		Assert.assertArrayEquals(input,new int[] {4,6,8});
	}
	@Test
	public void example5()
	{
		int[] input=new int[] {0,0,0,0,1,0,0};
		input=Arrays.copyOf(input,removeElement(input,0));
		Assert.assertArrayEquals(input,new int[] {1});
	}
	
	/*TC O(n) SC O(n) */
	private int removeElement(int[] input, int val) {
		int len=0;
		for(int left=0;left<input.length;left++)
		{
			if(input[left]!=val)
			{
				input[len++]=input[left];				
			}
		}
		return len;
	}
}
