package Math;

import org.junit.Assert;
import org.junit.Test;

public class NthDigit {
	@Test
	public void example1()
	{
		Assert.assertEquals(3, findNthDigit(3));
	}
	
	@Test
	public void example2()
	{
		Assert.assertEquals(0, findNthDigit(11));
	}
	
	@Test
	public void example3()
	{
		Assert.assertEquals(0, findNthDigit(100000));
	}
	
	
	private int findNthDigit(int n) {
		int start=1;int end=9;int len=1;
		while(n>end*len)
		{
			start=start*10;
			end=(start*10) - 1;
		}
		String res="";
		for(int index=start;index<=n;index++)
		{
			res+=index;
		}
		return Character.getNumericValue(res.charAt(n - start));
	}

	public int findNthDigitBF(int n) {
        String res="";
        for(int i=0;i<=n;i++)
        	res+=i;
        return Character.getNumericValue(res.charAt(n));
    }

}
