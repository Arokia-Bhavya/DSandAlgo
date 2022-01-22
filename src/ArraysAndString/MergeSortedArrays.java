package ArraysAndString;

import org.junit.Assert;
import org.junit.Test;

public class MergeSortedArrays {
	@Test
	public void example1()
	{
		Assert.assertArrayEquals(new int[] {1,2,2,3,5,6}, mergeArrays(new int[] {1,2,3},new int[] {2,5,6}));
	}
	
	@Test
	public void example2()
	{
		Assert.assertArrayEquals(new int[] {1}, mergeArrays(new int[] {1},new int[] {}));

	}
	@Test
	public void example3()
	{
		Assert.assertArrayEquals(new int[] {1}, mergeArrays(new int[] {},new int[] {1}));

	}

	/*TC O(m+n) SC O(m+n)*/
	private int[] mergeArrays(int[] input1, int[] input2) {
		if(input1.length==0)
			return input2;
		if(input2.length==0)
			return input1;
		int[] output=new int[input1.length + input2.length];
		int index=0;
		for(int n1=0,n2=0;index<output.length;)
		{
			if(n1>=input1.length)
				output[index++]=input2[n2++];
			else if(n2>=input2.length)
				output[index++]=input1[n1++];
			else if(input1[n1]<input2[n2])
				output[index++]=input1[n1++];
			else
				output[index++]=input2[n2++];
		}
		return output;
	}

}
