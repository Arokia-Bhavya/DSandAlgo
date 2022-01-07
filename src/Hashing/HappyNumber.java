package Hashing;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class HappyNumber {
	
	@Test
	public void example1()
	{
		Assert.assertEquals(true, isHappy(19));
	}
	
	@Test
	public void example2()
	{
		Assert.assertEquals(false, isHappy(2));
	}
	
	@Test
	public void example3()
	{
		Assert.assertEquals(true, isHappy(7));
	}

	private boolean isHappy(int n) {
		
		Set<Integer> seen=new HashSet<Integer>();
		n=sumOfSquareDigits(n);
		while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = sumOfSquareDigits(n);
        }
        return n == 1;
	}

	private int sumOfSquareDigits(int n) {
		int totalSum=0;
		while(n>0)
		{
			int d = n % 10;
            totalSum += d * d;
            n = n / 10;
		}
		return totalSum;
	}

}
