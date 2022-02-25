package BitMasking;

import org.junit.Assert;
import org.junit.Test;

public class CountingBits {
	@Test
	public void example1()
	{
		Assert.assertArrayEquals(new int[] {0,1,1}, countBits(2));
	}
	
	@Test
	public void example2()
	{
		Assert.assertArrayEquals(new int[] {0,1,1,2,1,2}, countBits(5));
	}
	
	public int[] countBits(int n) {
	       int[] output=new int[n+1];
	       int position=0;
	       for(int index=0;index<=n;index++)
	       {
	           String bin=Integer.toBinaryString(index);
	           int count=0;
	           for(char value:bin.toCharArray())
	           {
	               if(value=='1')
	                   count++;
	           }
	           output[position++]=count;
	       }
	        return output;
	    }

}
