package SlidingWindow;

import org.junit.Assert;
import org.junit.Test;

public class DietPlanPerformance {

	@Test
	public void example1()
	{
		Assert.assertEquals(0,calculatePoints(new int[] {1,2,3,4,5},1,3,3));
	}

	@Test
	public void example2()
	{
		Assert.assertEquals(1,calculatePoints(new int[] {3,2},2,0,1));
	}
	
	@Test
	public void example3()
	{
		Assert.assertEquals(0,calculatePoints(new int[] {6,5,0,0},2,1,5));
	}
	
	private int calculatePoints(int[] calories, int target, int lower, int upper) {
		int points=0;		
		int total_calories=0;
		for(int start=0;start<target;start++)
			total_calories=total_calories + calories[start];
		points=updatePoints(total_calories,lower,upper,points);
		for(int start=target;start<calories.length;start++)
		{			
			total_calories=total_calories + calories[start] - calories[start- target];
			points=updatePoints(total_calories,lower,upper,points);
		}
		
		
		return points;
	}

	private int updatePoints(int total_calories, int lower, int upper,int points) {
		if(total_calories < lower)
			points--;
		if(total_calories > upper)
			points++;
		return points;
	}
}
