package Math;

import org.junit.Test;

import junit.framework.Assert;

public class CountDigits {
	
	@Test
	public void example1()
	{
		Assert.assertEquals(3, getCountDigits(123));
	}
	
	@Test
	public void example2()
	{
		Assert.assertEquals(2, getCountDigits(24));
	}
	
	@Test
	public void example3()
	{
		Assert.assertEquals(1, getCountDigits(7));
	}

	private int getCountDigits(int N) {
		int count=0;		
		while(N>0)
		{
			count++;
			N=N/10;
		}
		return count;
	}

}
