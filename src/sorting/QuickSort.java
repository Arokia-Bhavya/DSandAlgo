package sorting;

import org.junit.Assert;
import org.junit.Test;

public class QuickSort {
	
	@Test
	public void example1()
	{
		Assert.assertArrayEquals(new int[] {3,10,20,25,50}, sort(new int[] {10,25,3,50,20}));
	}

	private int[] sort(int[] input) {
		return quicksort(input,0,input.length -1);
	}

	private int[] quicksort(int[] input, int start, int end) {
		if(start<end)
		{
			int pIndex= partition(input,start,end);
			quicksort(input,start,pIndex-1);
			quicksort(input,pIndex+1,end);
		}
		return input;
	}

	private int partition(int[] input,int start,int end) {
		int pivotElement=input[end];
		int pIndex=start;
		for(int index=start;index<end;index++)
		{
			if(input[index]<pivotElement)
			{
				swap(input,index,pIndex);
				pIndex++;
			}
		}
		swap(input,end,pIndex);
		return pIndex;
	}

	private void swap(int[] input, int start, int end) {
		int tmp=input[start];
		input[start]=input[end];
		input[end]=tmp;
	}

}
