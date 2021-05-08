package easy;

import org.junit.Assert;
import org.junit.Test;

public class RotateArray {
	
	@Test
	public void example1()
	{
		Assert.assertArrayEquals(new int[] {5,6,7,1,2,3,4}, rotateArray(new int[] {1,2,3,4,5,6,7},3));
	}
	
	@Test
	public void example2()
	{
		Assert.assertArrayEquals(new int[] {3,99,-1,-100}, rotateArray(new int[] {-1,-100,3,99},2));
	}
	
	@Test
	public void example3()
	{
		Assert.assertArrayEquals(new int[] {-1}, rotateArray(new int[] {-1},2));
	}
	
	/*
	 * reversing the elements
	 * TC O(N)
	 * SC O(1)
	 */
	private int[] rotateArray(int[] inputArray, int target) {
		target=target%inputArray.length;
		reverse(inputArray,0,inputArray.length);
		reverse(inputArray,0,target);
		reverse(inputArray,target,inputArray.length);
		return inputArray;
	}

	private void reverse(int[] inputArray, int start, int end) {
		
		for(;start<end;start++,end--)
		{
			int tmp=inputArray[start];
			inputArray[start]=inputArray[end - 1];
			inputArray[end - 1]=tmp;			
		}
		
	}

	/*
	 * Bruteforce
	 * move the element one at a time for number of target%length times
	 * TC O(N*K)
	 * SC O(1)
	 */
	private int[] rotateArrayUsingBF(int[] inputArray, int target) {
		target=target%inputArray.length;
		for(int index=0;index<target;index++)
		{
			int prev=inputArray[(inputArray.length - 1)];
			for(int innerindex=0;innerindex<inputArray.length;innerindex++)
			{
				int tmp=inputArray[innerindex];
				inputArray[innerindex]=prev;
				prev=tmp;
			}
		}
		return inputArray;
	}

	/*
	 * iterate the index till last element 
	 * (index+key)%nums.length
	 * TC O(N)
	 * SC O(N)
	 */
	
	private int[] rotateArrayUsingOnePass(int[] inputArray, int target) {
		int[] outputArray=new int[inputArray.length];
		for(int index=0;index<inputArray.length ;index++)
		{
		  outputArray[(index+target)%inputArray.length]=inputArray[index];
		}
		
		return outputArray;
	}

}
