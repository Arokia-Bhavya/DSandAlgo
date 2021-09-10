package dynamicprogramming;

import org.junit.Test;

import junit.framework.Assert;

public class FibonacciNumber {
	@Test
	public void example1()
	{
		Assert.assertEquals(3, getFibonacciNumber(4));
	}
	
	@Test
	public void example2()
	{
		Assert.assertEquals(2, getFibonacciNumber(3));
	}
	
	@Test
	public void example3()
	{
		Assert.assertEquals(1, getFibonacciNumber(2));
	}

	/*using previous variables TC O(n) SC O(1)*/
	private int getFibonacciNumber(int num) {
		if(num<=1)
			return num;
		int prev1=1,prev2=0,cur = 0;
		for(int count=2;count<=num;count++)
		{
			cur=prev1+prev2;
			prev2=prev1;
			prev1=cur;			
		}
		return cur;
	}

	/*recursive TC O(n) SC O(n)*/
	private int getFibonacciNumberUsingRecursive(int num) {
		if(num == 0)
			return num;
		if(num == 1)
			return num;
		int[] fibo=new int[num+1];		
		if(num>=2)
			fibo[num]= getFibonacciNumberUsingRecursive(num-1) + getFibonacciNumberUsingRecursive(num-2);	
		return fibo[num];
	}

	/*BruteForce TC O(n) SC O(n)*/
	private int getFibonacciNumberUsingBruteForce(int num) {
		if(num<=1)
			return num;		
		int[] fibo=new int[num+1];		
		fibo[1]=1;		
		for(int count=2;count<fibo.length;count++)
		{
			fibo[count]=fibo[count-1]+fibo[count-2];
		}
		  
		return fibo[num];
	}

	
}
