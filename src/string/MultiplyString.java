package string;

import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Test;

public class MultiplyString {
	@Test
	public void example1()
	{
		Assert.assertEquals("6", multiply("2","3"));
	}
	
	@Test
	public void example2()
	{
		Assert.assertEquals("56088", multiply("123","456"));
	}

	private String multiply(String num1, String num2) {		
	return String.valueOf(Integer.parseInt(num1)*Integer.parseInt(num2));
	}
	
	

}
