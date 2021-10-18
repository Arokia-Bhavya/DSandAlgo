package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;


public class GroupAnagaram {
	@Test
	public void example1()
	{
		List<List<String>> groupAnagramList=new ArrayList<List<String>>();
		List<String> anagram1=new ArrayList<String>();
		anagram1.add("bat");
		groupAnagramList.add(anagram1);
		List<String> anagram2=new ArrayList<String>();
		anagram2.add("nat");
		anagram2.add("tan");
		List<String> anagram3=new ArrayList<String>();
		anagram3.add("ate");
		anagram3.add("eat");
		anagram3.add("tae");
		groupAnagramList.add(anagram3);
		Assert.assertEquals(groupAnagramList,computeAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"}));
	}
	
	@Test
	public void example2()
	{
		List<List<String>> groupAnagramList=new ArrayList<List<String>>();
		List<String> anagram1=new ArrayList<String>();
		anagram1.add("");
		groupAnagramList.add(anagram1);		
		Assert.assertEquals(groupAnagramList,computeAnagrams(new String[] {""}));
	}
	@Test
	public void example3()
	{
		List<List<String>> groupAnagramList=new ArrayList<List<String>>();
		List<String> anagram1=new ArrayList<String>();
		anagram1.add("a");		
		groupAnagramList.add(anagram1);
		Assert.assertEquals(groupAnagramList,computeAnagrams(new String[] {"a"}));
	}
	
	//TC O(n2)
	private List<List<String>> computeAnagramsUsingBruteForce(String[] strs) {
		List<List<String>> output=new ArrayList<>();
        for(int index=0;index<strs.length;index++)
        {
            if(!isPresent(output,strs[index]))
            {
            List<String> anagramList=new ArrayList<String>();
            for(int innerInnerIndex=index+1;innerInnerIndex<strs.length;innerInnerIndex++)
            {
               if(isValidAnagram(strs[index],strs[innerInnerIndex]))
                   anagramList.add(strs[innerInnerIndex]);                  
                   
            }
                anagramList.add(strs[index]);
                output.add(anagramList);
            }
        }
        return output;
	}
	
	public boolean isValidAnagram(String input1,String input2)
    {
        char[] inputCharArray1=input1.toCharArray();
        char[] inputCharArray2=input2.toCharArray();
        Arrays.sort(inputCharArray1);
        Arrays.sort(inputCharArray2);
        return Arrays.equals(inputCharArray1,inputCharArray2);
    }
    
    boolean isPresent(List<List<String>> outputlist,String input)
    {
        for(List<String> anagram: outputlist)
        {
            if(anagram.contains(input))
                return true;
        }
        return false;
    }

	private List<List<String>> computeAnagramsUsingHashtable(String[] input) {
		List<List<String>> groupAnagramList=new ArrayList<List<String>>();
		Map<String,List<String>> frequency=new HashMap<String,List<String>>();
		for(String inputVal:input)
		{
			char[] valueChar=inputVal.toCharArray();
			Arrays.sort(valueChar);
			String key=new String(valueChar);
			List<String> anagramList=new ArrayList<String>();

			if(frequency.containsKey(key))
			{
				anagramList=frequency.get(key);
			}else
			{
				anagramList=new ArrayList<String>();
			}
			anagramList.add(inputVal);
			frequency.put(key, anagramList);
		}
		
		return new ArrayList(frequency.values());
	}
	
	/*O(n)*/
	private List<List<String>> computeAnagrams(String[] input) {
		Map<String,List<String>> frequency=new HashMap<String,List<String>>();
		for(String inputVal:input)
		{
			char[] valueChar=inputVal.toCharArray();
			int[] ref=new int[26];
			for(char c:valueChar)
			{
				ref[c-'a']++;
			}
			StringBuilder sb=new StringBuilder();
			for(int cnt:ref)
			{
				sb.append('#');
				sb.append(cnt);
			}
			String key=sb.toString();
			if(frequency.containsKey(key))
			{
				frequency.get(key).add(inputVal);
			}else
			{
				List<String> anagramList=new ArrayList<String>();
				anagramList.add(inputVal);
				frequency.put(key, anagramList);
			}
		}		
		return new ArrayList(frequency.values());
	}
	

}
