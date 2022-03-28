package Math;

import org.junit.Test;

import junit.framework.Assert;

public class FactorialTrailingZeroes {
	@Test
	public void example1()
	{
		Assert.assertEquals(0, trailingZeroes(3));
	}
	
	@Test
	public void example2()
	{
		Assert.assertEquals(1, trailingZeroes(5));
	}
	
	@Test
	public void example3()
	{
		Assert.assertEquals(0, trailingZeroes(0));
	}
	
	@Test
	public void example4()
	{
		Assert.assertEquals(1, trailingZeroes(7));
	}

	@Test
	public void example5()
	{
		Assert.assertEquals(2, trailingZeroes(13));
	}
	/*TC O(n) SC O(1)*/
	private int trailingZeroesBetterSolution(int num) {
		int countFives=0;
		for(int divider=5;num/divider >0;divider=divider+5)
		{
			int x=divider;
            while(x>0 && x%5==0)
            {
                ++countFives;
                x/=5;
            }
		}
		
		return countFives;
	}

	/* TC O(logn) SC O(1)*/
	private int trailingZeroes(int num) {
		int countFives=0;
		int divider = 5;
		 
        while ((num/divider) > 0) {
        	countFives = num/divider + countFives;
            divider = divider * 5;
        }

		return countFives;
	}

	/*TC O(n) SC O(n)*/
	private int trailingZeroesUsingBF(int num) {
		int count=0;
		int result=fact(num);
		if(result!=0)
		{
			String numStr=result+"";
			for ( int index=numStr.length() -1;index>=0;index--)
				if(numStr.charAt(index)=='0')
					count++;
				else
					break;
		}
		return count;
	}

	private int fact(int num) {
		if(num<=0)
			return 0;
		else if(num==1)
			return num;
		else 
			return num*fact(num-1);
	}

}
