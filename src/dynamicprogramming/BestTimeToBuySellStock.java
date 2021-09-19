package dynamicprogramming;

import org.junit.Test;

import junit.framework.Assert;

public class BestTimeToBuySellStock {
	@Test
	public void example1()
	{
		Assert.assertEquals(5,getResult(new int[] {7,1,5,3,6,4}));
	}
	
	@Test
	public void example2()
	{
		Assert.assertEquals(0,getResult(new int[] {7,6,4,3,1}));
	}
	
	/*
	 * O(n) */
	public int getResult(int[] prices)
    {
        int max_profit=0;
        int buyPrice=prices[0];
        for(int index=1;index<prices.length;index++)
        {
        	if(prices[index]>buyPrice)
                max_profit=Math.max(max_profit,prices[index] - buyPrice);
            else
                buyPrice=prices[index];
        }
		return max_profit;
    }

	/* TC O(n2) Time limit exceeded*/
	private int getResultUsingBruteForce(int[] prices) {
		int max_profit=0;
        for(int index=0;index<prices.length;index++)
        {
        	for(int loopIndex=index + 1;loopIndex<prices.length;loopIndex++)
        	{
        		int profit=prices[loopIndex] - prices[index];
        		if(profit > 0)
        		max_profit=Math.max(max_profit, profit);
        	}
        }
		return max_profit;
	}

	
	
}
