package SlidingWindow;

import org.junit.Assert;
import org.junit.Test;

public class GrumpyBookStore {

	@Test
	public void example1()
	{
		Assert.assertEquals(16, countHappyCustomers(new int[] {1,0,1,2,1,1,7,5},new int[] {0,1,0,1,0,1,0,1},3));
	}
	
	@Test
	public void example2()
	{
		Assert.assertEquals(1, countHappyCustomers(new int[] {1},new int[] {0},1));
	}
	
	@Test
	public void example3()
	{
		Assert.assertEquals(24, countHappyCustomers(new int[] {4,10,10},new int[] {1,1,0},2));
	}

	private int countHappyCustomers(int[] customers, int[] grumpy, int minutes) {
		int total=0;
		int maxProfit=0;
		int maxEnd=0;
		int currentProfit=0;
		for(int count=0;count<minutes;count++)
			currentProfit=currentProfit + customers[count];
		maxProfit=currentProfit;
		maxEnd=minutes;
		for(int count=minutes;count<customers.length;count++)
		{
			currentProfit=currentProfit - customers[count-minutes] + customers[count];
			if(currentProfit>maxProfit)
			{
				maxProfit=currentProfit;
				maxEnd=count;
			}
		}
		total=maxProfit;
		int max_start=(maxEnd - minutes) + 1;
		for(int count=0;count<grumpy.length;count++)
		{
			if(grumpy[count]==0 && (count < max_start || count > maxEnd))
			{
				System.out.println("count "+count+"customers[count]"+customers[count]);
				total=total+customers[count];
			}
		}
		
		return total;
	}
	
	
}
