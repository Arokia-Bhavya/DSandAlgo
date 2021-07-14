package TwoPointer;

import org.junit.Test;

import junit.framework.Assert;

public class ReverseStringII {
	
	@Test
	public void example1()
	{
		Assert.assertEquals("bacdfeg",getReverStringII("abcdefg",2));
	}
	
	

	@Test
	public void example2()
	{
		Assert.assertEquals("bacd",getReverStringII("abcd",2));
	}
	
	private String getReverStringII(String s, int k) {
		char[] input=s.toCharArray();
        for(int start=0;start<s.length();start+=2*k)
        {
            int left=start;
            int right=Math.min(left+(k - 1),s.length() -1);
            while(left < right)
            {
                char temp=input[left];
                input[left]=input[right];
                input[right]=temp;
                left++;
                right--;
            }
        }
        return new String(input);
	}
}
