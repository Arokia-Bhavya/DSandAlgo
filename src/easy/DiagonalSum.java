package easy;
import org.junit.Assert;
import org.junit.Test;

public class DiagonalSum {
	@Test
	public void example1()
	{
		Assert.assertEquals(25, compute(new int[][] {{1,2,3},{4,5,6},{7,8,9}}));
	}
	
	@Test
	public void example2()
	{
		Assert.assertEquals(8, compute(new int[][] {{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}}));
	}
	
	@Test
	public void example3()
	{
		Assert.assertEquals(5, compute(new int[][] {{5}}));
	}

	private int compute(int[][] input) {
		
		int sum=0;
		for(int index=0;index<rows;index++)
		{
			for(int )
		}
		return null;
	}

}
