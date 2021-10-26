package SlidingWindow;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

public class WordPattern {
	
	@Test
	public void example1()
	{
		Assert.assertEquals(false, isPatternExist("abba","dog cat cat fish"));
	}
	
	@Test
	public void example2()
	{
		Assert.assertEquals(true, isPatternExist("abba","dog cat cat dog"));
	}
	
	@Test
	public void example3()
	{
		Assert.assertEquals(false, isPatternExist("abba","dog cat cat fish"));
	}
	
	@Test
	public void example4()
	{
		Assert.assertEquals(false, isPatternExist("abba","dog dog dog dog"));
	}
	
	@Test
	public void example5()
	{
		Assert.assertEquals(true, isPatternExist("aaaa","dog dog dog dog"));
	}

	private boolean isPatternExist(String pattern, String s) {
		HashMap<Character,String> patternTbl=new  HashMap<Character,String>();
        String[] input=s.split(" ");
        if(pattern.length() != input.length)
            return false;
        for(int index=0;index<pattern.length();index++)
        {
           if(patternTbl.containsKey(pattern.charAt(index)))
            {
               if(!patternTbl.get(pattern.charAt(index)).equals(input[index]))
               return false;
            }
            if(patternTbl.containsValue(input[index]))
            {
                if(!patternTbl.containsKey(pattern.charAt(index)))
                    return false;
            }
            patternTbl.put(pattern.charAt(index),input[index]);
        }
        return true;
	}

}
