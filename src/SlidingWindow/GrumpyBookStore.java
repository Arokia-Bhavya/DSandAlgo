package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

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
		int satisfied=0;
		int maxUnSatisfied=0;
		int currentUnSatisfied=0;
		for(int index=0;index < customers.length;index++)
		{
			
			satisfied+=grumpy[index]== 0?customers[index]:0;
			currentUnSatisfied+=grumpy[index]== 1?customers[index]:0;
			if(index>=minutes)
			{
				currentUnSatisfied -= grumpy[index - minutes]==1? customers[index - minutes]:0;  
			}
			maxUnSatisfied=Math.max(maxUnSatisfied, currentUnSatisfied);
		}
		
		
		return satisfied+Math.max(currentUnSatisfied, maxUnSatisfied);
	}
	
	
}
