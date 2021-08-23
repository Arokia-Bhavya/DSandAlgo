package Hashing;

import java.util.HashSet;

import org.junit.Test;

import junit.framework.Assert;

public class JewelStones {

	@Test
	public void example1()
	{
		Assert.assertEquals(3,numJewelsInStones("aA","aAAbbbb"));
	}
	
	@Test
	public void example2()
	{
		Assert.assertEquals(0,numJewelsInStones("z", "ZZ"));
	}
	
	public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> uniqueJewel=new HashSet<Character>();
        int count=0;
        for(char jewel:jewels.toCharArray())
        {
            uniqueJewel.add(jewel);
        }
        for(char stone:stones.toCharArray())
        {
            if (uniqueJewel.contains(stone))
              count++;  
        }
        return count;
    }
}
