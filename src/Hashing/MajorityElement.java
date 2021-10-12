package Hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

public class MajorityElement {
	
@Test
public void example1()
{
	Assert.assertEquals(3, getMajorityElement(new int[] {3,2,3}));	
}

@Test
public void example2()
{
	Assert.assertEquals(2, getMajorityElement(new int[] {2,2,1,1,1,2,2}));	
}
/*TC O(nlogn)*/
private Object getMajorityElement(int[] input) {
	Arrays.sort(input);
	return input[input.length/2];
}

/*TC O(n) SC O(n)*/
private int getMajorityElementUsingHashMap(int[] input) {
	HashMap<Integer,Integer> frequency=new HashMap<Integer,Integer>();
	for(int num:input)
	{
		frequency.put(num, frequency.getOrDefault(num, 0)+1);
	}
	for(Map.Entry<Integer,Integer> map:frequency.entrySet())
	{
		if(map.getValue() > (input.length/2))
			return map.getKey();
	}
	return -1;

}

/*O(n2)*/
private int getMajorityElementUsingBF(int[] input) {
	for(int num:input)
	{
		int count=0;
		for(int value:input)
		{
			if(num == value)
				count++;
		}
		if(count > (input.length/2))
			return num;
	}
	return -1;
}



}
