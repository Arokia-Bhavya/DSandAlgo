package ArraysAndString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class MergeMeetingRange {

	@Test
	public void example1()
	{
		Assert.assertArrayEquals(new int[][] {{1,6},{8,10},{15,18}}, merge( new int[][] {{1,3},{2,6},{8,10},{15,18}}));
	}
	
	@Test
	public void example2()
	{
		Assert.assertArrayEquals(new int[][] {{1,5}}, merge( new int[][] {{1,4},{4,5}}));
	}
	
	@Test
	public void example3()
	{
		Assert.assertArrayEquals(new int[][] {{1,4}}, merge( new int[][] {{1,4},{2,3}}));
	}

	/*TC O(nlogn) SC O(n)*/
	private int[][] merge(int[][] input) {		
		Arrays.sort(input,(int[] o1,int[] o2)->o1[0] - o2[0]);
		List<int[]> outputList=new ArrayList<int[]>();
		outputList.add(input[0]);
		for(int index=1;index<input.length;index++)
		{
			if(input[index][0]<=outputList.get(outputList.size() -1)[1])
			{
				int[] removed=outputList.remove(outputList.size() -1);
				outputList.add(new int[] {removed[0],Math.max(removed[1],input[index][1])});
			}else
				outputList.add(input[index]);
		}
				
		return outputList.toArray(new int[outputList.size()][]);
	}
}
