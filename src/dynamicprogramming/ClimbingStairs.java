package dynamicprogramming;

import org.junit.Test;

import junit.framework.Assert;

public class ClimbingStairs {
	
	@Test
	public void example1()
	{
		Assert.assertEquals(1, getNoOfSteps(1));
	}
	
	@Test
	public void example2()
	{
		Assert.assertEquals(2, getNoOfSteps(2));
	}
	
	@Test
	public void example3()
	{
		Assert.assertEquals(3, getNoOfSteps(3));
	}
	
	

	

	private int getNoOfSteps(int num) {
		if(num<=2)
			return num;
		int prev1=2,prev2=1,cur=0;
		for(int count=3;count<=num;count++)
		{
			cur=prev2+prev1;
			prev2=prev1;
			prev1=cur;
					
		}
		return cur;
	}

	private int getNoOfStepsUsingIterativeApproach(int num) {
		if(num<=2)
			return num;	
		int[] result=new int[num+1];
		
		result[1]=1;
		result[2]=2;
		for(int count=3;count<=num;count++)
			result[count]=result[count-1]+result[count-2];
		
		return result[num];
	}

	private int getNoOfStepsUsingRecursion(int num) {
		if(num<=2)
			return num;		
		return getNoOfStepsUsingRecursion(num-1) + getNoOfStepsUsingRecursion(num-2);
	}

}
