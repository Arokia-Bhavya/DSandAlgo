package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ArrayIntersection {
	
	@Test
	public void example1()
	{
		Assert.assertArrayEquals(new Integer[] {2,2}, getArrayIntersection(new int[] {1,2,2,1},new int[] {2,2}));
		;
	}

	/*
	 * intialize left1,left2 to start of the array
	 * keep iterating till end of the respective array
	 * add to the output when both input1[left1]==input2[left2]
	 */
	private Integer[] getArrayIntersection(int[] input1, int[] input2) {
		
		int left1=0;
		int left2=0;
		Arrays.sort(input1);
		Arrays.sort(input2);
		List<Integer> outputlist=new ArrayList<Integer>();
		for(;left1<input1.length && left2 < input2.length;)
		{
			if(input1[left1] == input2[left2])
			{
				outputlist.add(input1[left1]);
				left1++;
				left2++;
			}else if(input1[left1] < input2[left2])
				left1++;
			else
				left2++;
		}
		Integer[] arr = new Integer[outputlist.size()];
		return outputlist.toArray(arr);
	}

}
