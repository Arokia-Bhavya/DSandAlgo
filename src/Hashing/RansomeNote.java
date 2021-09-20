package Hashing;


import org.junit.Assert;
import org.junit.Test;

public class RansomeNote {
	
	@Test
	public void example1()
	{
		Assert.assertEquals(false,canConstruct("a","b"));
	}
	
	@Test
	public void example2()
	{
		Assert.assertEquals(false,canConstruct("aa","ab"));
	}
	
	@Test
	public void example3()
	{
		Assert.assertEquals(true,canConstruct("aa","aab"));
	}

	private Object canConstruct(String ransomNote, String magazine) {
		int[] ref=new int[26];
		for(char value:magazine.toCharArray())
		{
			ref[value - 'a']++;
		}
		for(char value:ransomNote.toCharArray())
		{
			ref[value - 'a']--;
		}
		for(int value:ref)
		{
			if(value<0)
				return false;
		}
		
		return true;
	}

}
