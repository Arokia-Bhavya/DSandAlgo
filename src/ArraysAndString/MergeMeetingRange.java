package ArraysAndString;

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

	private int[][] merge(int[][] input) {
		// TODO Auto-generated method stub
		return null;
	}
}
