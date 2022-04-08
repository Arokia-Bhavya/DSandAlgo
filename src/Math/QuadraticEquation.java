package Math;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;


public class QuadraticEquation {
	
	@Test
	public void example1()
	{
		Assert.assertArrayEquals(new Integer[] {-1}, findRoots(280, 399, 573));
	}
	
	@Test
	public void example2()
	{
		Assert.assertArrayEquals(new Integer[] {-1,-1}, findRoots(752, 904, 164));
	}
	
	@Test
	public void example3()
	{
		Assert.assertArrayEquals(new Integer[] {1,1}, findRoots(1, -2, 1));
	}
	
	@Test
	public void example4()
	{
		Assert.assertArrayEquals(new Integer[] {4,3}, findRoots(1, -7, 12));
	}
	
	Integer[] findRoots(int a, int b, int c)
    {
		ArrayList<Integer> result=new ArrayList<Integer>();
        int d = b * b - 4 * a * c;        
        if(d>=0)
        {
        	double sqrt_val = Math.sqrt(Math.abs(d));
            int max=(int)Math.floor((double)(-b + sqrt_val) / (2 * a));
            int min=(int)Math.floor((double)(-b - sqrt_val) / (2 * a));
            result.add(Math.max(max,min));
            result.add(Math.min(max,min));
        }else
        { 
            result.add(-1);
        }
        
        return  result.toArray(Integer[]::new);
     }
    
	
	
}
