package easy;

import org.junit.Assert;
import org.junit.Test;

public class PlusOne {
	
	
	@Test
	public void example1()
	{
		Assert.assertArrayEquals(new Integer[] {1,2,4}, plusOne(new Integer[] {1,2,3}));
	}
	
	@Test
	public void example2()
	{
		Assert.assertArrayEquals(new Integer[] {4,3,2,2}, plusOne(new Integer[] {4,3,2,1}));
	}
	
	@Test
	public void example3()
	{
		Assert.assertArrayEquals(new Integer[] {1}, plusOne(new Integer[] {0}));
	}
	

	/*
    TC O(n)
    SC O(1)
    */
    
    public Integer[] plusOne(Integer[] digits) {
        int index=digits.length -1;
        while(index>=0 && digits[index]==9)
        {
            digits[index]=0;
            index--;
        }
        if(index==-1)
        {
        	Integer[] output=new Integer[digits.length + 1];
            output[0]=1;
            return output;
        }
        digits[index]=digits[index] + 1;
        return digits;
    }
}
