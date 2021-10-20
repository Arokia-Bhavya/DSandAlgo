package string;


import java.util.ArrayList;
import java.util.List;

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
	
	@Test
	public void example3()
	{
		Assert.assertEquals("121932631112635269", multiply("123456789","987654321"));
	}
	
	@Test
	public void example4()
	{
		Assert.assertEquals("0", multiply("9133","0"));
	}
	
	@Test
	public void example5()
	{
		Assert.assertEquals("100940", multiply("140","721"));
	}

	

	private String multiply(String num1, String num2) {	
		if(num1.equals("0") || num2.equals("0"))
			return "0";
		int carry=0;
		StringBuilder num1sb=new StringBuilder(num1);
		num1sb.reverse();
		StringBuilder num2sb=new StringBuilder(num2);
		num2sb.reverse();
		List<List<Integer>> finalList=new ArrayList<List<Integer>>();
		for(int num2Index=0;num2Index<num2sb.length();num2Index++)
		{
			List<Integer> numList=new ArrayList<Integer>();
			carry=0;
			for(int index=0;index<num2Index;index++)
			{
				numList.add(0);
			}
			for(int num1Index=0;num1Index<num1sb.length();num1Index++)
			{
				int result=(num1sb.charAt(num1Index) - '0')*(num2sb.charAt(num2Index) - '0');
				result=result+carry;
				carry=result/10;
				numList.add(result%10);
			}
			if(carry!=0)
				numList.add(carry);
			finalList.add(numList);
		}
		StringBuilder result=new StringBuilder();
		int maxCol=0;
		for(int row=0;row<finalList.size();row++)
		{
			maxCol=Math.max(maxCol, finalList.get(row).size());
		}
		carry=0;
		for(int col=0;col<maxCol;col++)
		{
			int sum=carry;
			for(int row=0;row<finalList.size();row++)
			{
				if(col<finalList.get(row).size())
				sum=sum+finalList.get(row).get(col);
			}
			carry=sum/10;
			result.append(sum%10);			
		}
		if(carry!=0)
		result.append(carry);
		return result.reverse().toString();

	}
}
