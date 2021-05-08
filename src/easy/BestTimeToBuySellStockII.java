package easy;

import org.junit.Assert;
import org.junit.Test;

public class BestTimeToBuySellStockII {
	@Test
	public void example1()
	{
		Assert.assertEquals(7,maxProfit(new int[] {7,1,5,3,6,4}));
	}
	
	@Test
	public void example2()
	{
		Assert.assertEquals(4,maxProfit(new int[] {1,2,3,4,5}));
	}
	
	@Test
	public void example3()
	{
		Assert.assertEquals(0,maxProfit(new int[] {7,6,4,3,1}));
	}
	/*
	 * Iterate the elements
	 * keep adding the profit
	 * TC O(N)
	 * SC O(1)
	 */
	private int maxProfit(int[] prices) {
		int max_profit=0;
		for(int index=0;index<prices.length - 1;index++)
		{
			if(prices[index]<prices[index+1])
				max_profit+=(prices[index+1] - prices[index]);
		}
		return max_profit;
	}

	/*
	 * Identify the buy value & then sell value
	 * calculate the profit and sum the value
	 * TC O(N)
	 * SC O(1)
	 */
	private int maxProfitUsingPeakValley(int[] prices) {
		int max_profit=0;
		for(int index=0;index<prices.length -1;)
		{
			while(index<prices.length-1 && prices[index] >= prices[index+1])
				index++;
			int buy=prices[index];
			while(index<prices.length-1 && prices[index] <= prices[index+1])
				index++;
			int sell=prices[index];
			max_profit=max_profit+(sell - buy);
		}
		return max_profit;
	}

	/*
	 * BruteForce 
	 * Iterate every element and find the element lesser than that
	 * and calculate profit.increment the next index of the innerindex and repeat the process
	 *  
	 * TC O(N^N)
	 * SC O(N)
	 */
	public int maxProfitUsingBF(int[] prices) {
		return calculate(prices,0);
    }
	
	public int calculate(int prices[], int s) {
        if (s >= prices.length)
            return 0;
        int max = 0;
        for (int buy_index = s; buy_index < prices.length; buy_index++) {
            int maxprofit = 0;
            for (int sell_index = buy_index + 1; sell_index < prices.length; sell_index++) {
                if (prices[buy_index] < prices[sell_index]) {
                    int profit = calculate(prices, sell_index + 1) + prices[sell_index] - prices[buy_index];
                    maxprofit=Math.max(maxprofit, profit);
                }
            }
            max=Math.max(max, maxprofit);
        }
        return max;
    }
	
	
}
