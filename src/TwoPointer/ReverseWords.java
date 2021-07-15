package TwoPointer;

import org.junit.Assert;
import org.junit.Test;

public class ReverseWords {
	@Test
	public void example1()
	{
		Assert.assertEquals("blue is sky the",getReverseWord("the sky is blue"));
	}

	@Test
	public void example2()
	{
		Assert.assertEquals("world hello",getReverseWord("  hello world  "));
	}
	
	@Test
	public void example3()
	{
		Assert.assertEquals("example good a",getReverseWord("a good   example"));
	}
	
	@Test
	public void example4()
	{
		Assert.assertEquals("Alice Loves Bob",getReverseWord("  Bob    Loves  Alice   "));
	}
	
	@Test
	public void example5()
	{
		Assert.assertEquals("bob like even not does Alice",getReverseWord("Alice does not even like bob"));
	}
	/*
	 * TC : O(n/2)
	 * SC : O(n)
	 */
	private String getReverseWord(String s) {
		StringBuilder output=new StringBuilder();
        String[] values=s.split(" ");
        for(int left=0,right=values.length -1;left<right;)
        {
            
                String temp=values[left];
                values[left]=values[right];
                values[right]=temp;
                left++;
                right--;
            
        }
        
        for(String value:values)
        {
           if(!value.isEmpty())
               output.append(value+" ");
        }
        
        return output.toString().trim();
	}

}
