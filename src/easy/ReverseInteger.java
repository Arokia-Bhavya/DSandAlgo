package easy;

import org.junit.Test;

import junit.framework.Assert;

public class ReverseInteger {
	
@Test
public void example1()
{
	Assert.assertEquals(421, getReverseInteger(124));	
}

@Test
public void example2()
{
	Assert.assertEquals(21, getReverseInteger(120));	
}

@Test
public void example3()
{
	Assert.assertEquals(-321, getReverseInteger(-123));	
}

@Test
public void example4()
{
	Assert.assertEquals(0, getReverseInteger(1534236469));	
}

/*
 * TC O(log(x)) where x is number of digits
 * SC O(1)
 * 
 * Note there is possibility of integer overflow 
 */
private int getReverseInteger(int input) {
	int reversed=0;
	int remainder=0;
	boolean isNegativeSign = false;
	if(input < 0)
	{
		input = -1 * input;
		isNegativeSign = true;
	}
	while(input > 0)
	{
		remainder = input%10;		
		input=input/10;
		if(reversed > Integer.MAX_VALUE/10 || reversed == Integer.MAX_VALUE/10 && remainder>7)
			return 0;
		if(reversed < Integer.MIN_VALUE/10 || reversed == Integer.MIN_VALUE/10 && remainder<-8)
			return 0;
		reversed = reversed*10 + remainder;
		
	}
	if(reversed > Integer.MAX_VALUE)
		return 0;
	if(isNegativeSign)
		reversed = -1 * reversed;
	return reversed;
}

}
