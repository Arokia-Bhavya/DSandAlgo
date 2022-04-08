package Math;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;

import org.junit.Test;

import junit.framework.Assert;

public class SimpleFraction {
	@Test
	public void example1()
	{
		Assert.assertEquals("0.5", fractionToDecimal(1,2));
	}
	
	@Test
	public void example2()
	{
		Assert.assertEquals("2", fractionToDecimal(2,1));
	}
	
	@Test
	public void example3()
	{
		Assert.assertEquals("0.(012)", fractionToDecimal(4,333));
	}
	
	@Test
	public void example4()
	{
		Assert.assertEquals("-6.25", fractionToDecimal(-50,8));
	}
	
	@Test
	public void example5()
	{
		Assert.assertEquals("0.0000000004656612873077392578125", fractionToDecimal(-1,-2147483648));
	}
	@Test
	public void example6()
	{
		Assert.assertEquals("-0.58(3)", fractionToDecimal(7,-12));
	}
	
	@Test
	public void example7()
	{
		Assert.assertEquals("-2147483648", fractionToDecimal(-2147483648,1));
	}

	@Test
	public void example8()
	{
		Assert.assertEquals("0", fractionToDecimal(0,-5));
	}
	
	 public String fractionToDecimal(int numerator, int denominator) {	
		 long num=numerator;
		 long den=denominator;
		 boolean isNeg=false;
		 if(numerator<0)
		 {
			 num=num*-1;
			 isNeg=true;
		 }
		 if(denominator<0)
		 {
			 den=den*-1;
			 isNeg=isNeg?false:true;
		 }
		 long rem=num%den;
		 String res=""+num/den;
		 if(rem!=0)
		 {
			 res=res+".";
			 HashMap<Long,Integer> remainderMap=new HashMap<Long,Integer>();
			 while (rem!=0 && !remainderMap.containsKey(rem) )
			 {
				 remainderMap.put(rem, res.length());
				 rem = rem * 10;			 
				 res += (rem/den);			 
				 rem = rem %den;
				 System.out.println("hello");
			 }
			 if(remainderMap.containsKey(rem))
			 { 
				 res=res.substring(0,remainderMap.get(rem))+"("+res.substring(remainderMap.get(rem))+")";			 
			 }
		 }
		 res=isNeg && !res.equals("0")?"-"+res:res;
		 return res;
	 }
}
