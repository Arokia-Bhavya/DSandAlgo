package Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class RepeatedDNASequences {

	@Test
	public void example1()
	{
		List<String> output=new ArrayList<String>();
		output.add("AAAAACCCCC");
		output.add("CCCCCAAAAA");
		Assert.assertEquals(output, findRepeatedValues("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
	}
	
	
	@Test
	public void example2()
	{
		List<String> output=new ArrayList<String>();
		output.add("AAAAAAAAAA");
		Assert.assertEquals(output, findRepeatedValues("AAAAAAAAAAA"));
	}
	
	@Test
	public void example3()
	{
		List<String> output=new ArrayList<String>();
		Assert.assertEquals(output, findRepeatedValues("A"));
	}
	
	@Test
	public void example4()
	{
		List<String> output=new ArrayList<String>();
		output.add("AAAAAAAAAA");
		Assert.assertEquals(output, findRepeatedValues("AAAAAAAAAAAAA"));
	}
	
	private List<String> findRepeatedValues(String input) {
		 Map<String,Integer> frequency=new HashMap<String,Integer>();  
	        List<String> output=new ArrayList<String>();
	        String window="";        
	        int window_size=10;
	        if(input.length() < window_size)
	            return output;
	        window=input.substring(0,window_size);
	        frequency.put(window,1);
	        for(int index=1;index<=input.length() - window_size;index++)
	        {
	            window=input.substring(index,index+window_size);
	            frequency.put(window,frequency.getOrDefault(window,0) + 1);
	        }
	      
	       
	        for(Map.Entry<String,Integer> entry:frequency.entrySet())
	        {
	            if(entry.getValue() > 1)    
	                output.add(entry.getKey());
	        }
	        return output;   
	    }
	

}
