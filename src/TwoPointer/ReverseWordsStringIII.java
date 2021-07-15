package TwoPointer;

import org.junit.Assert;
import org.junit.Test;

public class ReverseWordsStringIII {
	
	@Test
	public void example1()
	{
		Assert.assertEquals("s'teL ekat edoCteeL tsetnoc",getReverseWordsUsingInPlace("Let's take LeetCode contest"));
	}
	
	@Test
	public void example2()
	{
		Assert.assertEquals("doG gniD",getReverseWordsUsingInPlace("God Ding"));
	}
	/*
	 * 
	 */
	private String getReverseWordsUsingInPlace(String input)
	{
		char[] inputArray=input.toCharArray();	
		int left=0;
		int right=0;
		while(input.indexOf(" ",left)!=-1 || right < input.length() -1)
		{
			right= ( input.indexOf(" ",left)!=-1 )? (input.indexOf(" ",left) - 1): input.length() - 1;
			int new_left=right+2;
			for(;left<right;left++,right--)
			{
				char temp=inputArray[left];
				inputArray[left]=inputArray[right];
				inputArray[right]=temp;
			}
			left=new_left;
			
		}
		return new String(inputArray);
	}
	
	
	private String getReverseWords(String s) {
		 StringBuilder output=new StringBuilder();
	        String[] values=s.split(" ");
	             
	        for(String value:values)
	        {
	           if(!value.isEmpty())
	               output.append(reverse(value)+" ");
	        }
	        
	        return output.toString().trim();
		
	}
	
	 private String reverse(String input)
	    {
	        char[] inputArray=input.toCharArray();
	        for(int left=0,right=input.length()-1;left<right;left++,right--)
	        {
	            char temp=inputArray[left];
	            inputArray[left]=inputArray[right];
	            inputArray[right]=temp;
	        }
	        return new String(inputArray);
	    }
}
