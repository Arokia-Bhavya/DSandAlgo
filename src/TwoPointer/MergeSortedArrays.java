package TwoPointer;

import org.junit.Assert;
import org.junit.Test;

public class MergeSortedArrays {
	
	@Test
	public void example1()
	{
		Assert.assertArrayEquals(new int[] {1,2,2,3,5,6}, merge(new int[] {1,2,3},new int[] {2,5,6}));
	}
	
	@Test
	public void example2()
	{
		Assert.assertArrayEquals(new int[] {1}, merge(new int[] {1},new int[] {}));
	}
	
	@Test
	public void example3()
	{
		Assert.assertArrayEquals(new int[] {1}, merge(new int[] {},new int[] {1}));
	}
	
	/*
	 * intialize the pointers to start of the array
	 * check value at 2 arrays are same,less,greater
	 * move the lesser value to the output array
	 * 1,2,3
	 * 2,5,6
	 */
	private int[] merge(int[] input1, int[] input2) {
		int[] output=new int[input1.length + input2.length];
		int count=0;
		
		for(int left1=0,left2=0;count<output.length;)
		{
			if(input1.length == 0 || left1==input1.length)
			{
				System.arraycopy(input2, left2, output, count, input2.length - left2);
				return output;
			}
			if(input2.length == 0 || left2==input2.length)
			{
				System.arraycopy(input1, left1,output , count, input1.length - left2);
				return output;
			}
			if (input1[left1]<input2[left2])
			{
				output[count++]=input1[left1++];
				//left1=left1<input1.length? left1+1:left1;
			}else
			{
				output[count++]=input2[left2++];
				//left2=left2<input2.length ? left2+1:left2;
			}
		}
		
		return output;
	}


}
