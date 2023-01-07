package Hashing;

import java.util.Arrays;
import java.util.HashMap;

import org.junit.Test;

import junit.framework.Assert;

public class ValidaAnagram {
@Test
public void example1()
{
	Assert.assertEquals(true, isAnagram("anagram", "nagaram"));
}

@Test
public void example2()
{
	Assert.assertEquals(false, isAnagram("car", "rat"));
}

/*TC O(n) SC O(1)*/
private boolean isAnagram(String input1, String input2) {
	int[] count=new int[26];
	for(char value:input1.toCharArray())
	{
		count[value - 'a']++;
	}
	for(char value:input2.toCharArray())
	{
		count[value - 'a']--;
	}
	for(int value:count)
	{
		if(value!=0)
			return false;
	}
	return true;
}

/*TC O(nlogn)*/
public boolean isAnagramUsingSortin(String s, String t)
{
  if(s.length() != t.length() )
        return false;
  char[] inputArray1=s.toCharArray();
  char[] inputArray2=t.toCharArray();
  Arrays.sort(inputArray1);
  Arrays.sort(inputArray2);
  return Arrays.equals(inputArray1,inputArray2);  
}
/*TC O(n) SC O(n)*/
public boolean isAnagramUsingHashing(String s, String t) {
    if(s.length() != t.length() )
        return false;
    if(s.isEmpty() && t.isEmpty())
        return true;
    char[] inputArray=s.toCharArray();
    HashMap<Character,Integer> map=new HashMap<Character,Integer>();
    for(char value:inputArray)
    {
        map.put(value,map.getOrDefault(value,0)+1);            
    }
    
    for (char value:t.toCharArray())
    {
        if(map.containsKey(value))
        {
            map.put(value,map.getOrDefault(value,0)-1);
        }else
        {
            return false;
        }
    }
    for(char c:map.keySet()){
        if(map.get(c)!=0){return false;}
    }
    
    return true;
}
}
