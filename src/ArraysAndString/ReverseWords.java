package ArraysAndString;

import org.junit.Test;

import junit.framework.Assert;

public class ReverseWords {
	@Test
	public void example1()
	{
		Assert.assertEquals("blue is sky the", reverseWord("the sky is blue"));
	}
	
	@Test
	public void example2()
	{
		Assert.assertEquals("world hello", reverseWord("  hello world  "));
	}
	
	@Test
	public void example3()
	{
		Assert.assertEquals("example good a", reverseWord("a good example"));
	}

	private String reverseWord(String input) {
		input=input.strip();
		char[] inputArray=input.toCharArray();
		reverse(inputArray,0,inputArray.length - 1);
		input=new String(inputArray);
		for(int left=0,right=input.indexOf(" ") - 1;left<right;)
		{
			reverse(inputArray,left,right);
			if(input.indexOf(" ",left ) == -1)
				break;
			left=input.indexOf(" ",left) + 1;
			right=input.indexOf(" ",left)==-1?input.length() - 1:input.indexOf(" ",left) - 1;
		}
		return new String(inputArray);
	}

	private void reverse(char[] inputArray,int start,int end) {
		for(int left=start,right=end;left<right;)
		{
			char temp=inputArray[left];
			inputArray[left]=inputArray[right];
			inputArray[right]=temp;
			left++;
			right--;
		}
	}

}
