package string;

import org.junit.Assert;
import org.junit.Test;

public class AddString {

	@Test
	public void exampe1()
	{
		Assert.assertEquals("134", add("11","123"));
	}
	
	@Test
	public void exampe2()
	{
		Assert.assertEquals("533", add("456","77"));
	}
	
	@Test
	public void exampe3()
	{
		Assert.assertEquals("0", add("0","0"));
	}
    /*Using 2 pointer TC O(max(m,n)) SC O(1)*/
	private String  add(String num1, String num2) {
		StringBuilder result=new StringBuilder();
		int left1=num1.length() - 1;
		int left2=num2.length() - 1;
		int carry=0;
		while(left1>=0 || left2>=0)
		{
			int sum=carry;
			if(left1>=0)
			{
				sum = sum + (num1.charAt(left1) - '0');
				left1--;
			}
			if(left2>=0)
			{
				sum = sum + (num2.charAt(left2) - '0');
				left2--;
			}
			carry=sum/10;
			result.append(sum%10);
		}
		if(carry!=0)
			result.append(carry);
		return result.reverse().toString();
	}
}
