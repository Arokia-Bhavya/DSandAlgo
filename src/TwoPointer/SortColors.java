package TwoPointer;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class SortColors {
	
	@Test
	public void example1()
	{
		Assert.assertArrayEquals(new int[] {0,0,1,1,2,2}, sortColors(new int[] {2,0,2,1,1,0}));
	}
	@Test
	public void example2()
	{
		Assert.assertArrayEquals(new int[] {0,1,2}, sortColors(new int[] {2,0,1}));
	}
	
	@Test
	public void example3()
	{
		Assert.assertArrayEquals(new int[] {0,1}, sortColors(new int[] {0,1}));
	}
	
	/*TC O(n) 1 pass*/
	private int[] sortColorsUsing1Pass(int[] input) {
		int start=0;
		int end=input.length -1;
		for(int index=0;index<=end && start<end;)
		{
			if(input[index]==0)
			{
				input[index]=input[start];
				input[start]=0;
				start++;
				index++;
			}else if(input[index]==1)
			{
				index++;
			}else
			{
				input[index]=input[end];
				input[end]=2;
				end--;	
			}
		}
		return input;
	} 
	
	/*TC O(n) 2 pass*/
	private int[] sortColorsUsing2Pass(int[] input) {
		int count0s=0;
		int count1s=0;
		int count2s=0;
		for(int index=0;index<input.length;index++)
		{
			if(input[index]==0)
				count0s++;
			else if(input[index]==1)
				count1s++;
			else
				count2s++;
		}
		for(int index=0;index<input.length;index++)
		{
			if(count0s-- >0)
				input[index]=0;
			else if(count1s-- >0)
				input[index]=1;
			else if(count2s-- >0)
				input[index]=2;
		}
		return input;
	}
	
	/*TC O(nlogn)*/
	private int[] sortColorsUsingBuiltInFunction(int[] input) {
		Arrays.sort(input);
		return input;
	}
	
	/*TC O(n2) bubble sort*/
	private int[] sortColorsUsingBruteForce(int[] input) {
		for(int index=0;index<input.length;index++)
		{
			for(int loopIndex=index+1;loopIndex<input.length;loopIndex++)
			{
				if(input[index]>input[loopIndex])
				{
					int tmp=input[index];
					input[index]=input[loopIndex];
					input[loopIndex]=tmp;
				}
			}
		}
		return input;
	}
	

}
