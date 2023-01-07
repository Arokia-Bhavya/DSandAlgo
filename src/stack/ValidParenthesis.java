package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.junit.Test;

import junit.framework.Assert;

public class ValidParenthesis {

	@Test
	public void example1()
	{
		Assert.assertEquals(true, isValidParenthesis("()"));
	}
	
	@Test
	public void example2()
	{
		Assert.assertEquals(true, isValidParenthesis("()[]{}"));
	}
	
	@Test
	public void example3()
	{
		Assert.assertEquals(false, isValidParenthesis("(]"));
	}
	
	@Test
	public void example4()
	{
		Assert.assertEquals(false, isValidParenthesis("([)]}"));
	}
	
	@Test
	public void example5()
	{
		Assert.assertEquals(true, isValidParenthesis("{[]}"));
	}

	@Test
	public void example6()
	{
		Assert.assertEquals(false, isValidParenthesis("([)]"));
	}
	
	@Test
	public void example7()
	{
		Assert.assertEquals(false, isValidParenthesis("]"));
	}
	private boolean isValidParenthesis(String input) {
		char[] inputArray=input.toCharArray();
		String temp="";
		for (int index=0;index<input.length();index++)
		{
			if(inputArray[index]=='(' || inputArray[index]=='[' || inputArray[index]=='{')
				temp=temp + inputArray[index];
			else if(inputArray[index]==')')
			{
				if(temp.charAt(temp.length() - 1)!= '(')
					return false;
				temp=temp.substring(0, temp.length()-1);
			}
			else if(inputArray[index]==']')
			{
				if(temp.length()>0 && temp.charAt(temp.length() - 1)!= '[')
					return false;
				temp=temp.substring(0, temp.length()-1);
			}else if(inputArray[index]=='}')
			{
				if(temp.length()>0 && temp.charAt(temp.length() - 1)!= '{')
					return false;
				temp=temp.substring(0, temp.length()-1);
			}
		}
		return true;
	}
	
	/*
	 * TC O(n)
	 * SC O(n)
	 */
	private boolean isValidParenthesisBest(String input) {
	Stack<Character> checkParenthesis=new Stack<Character>();
	Map<Character,Character> parenthesis=new HashMap<Character,Character>();
	parenthesis.put(')', '(');
	parenthesis.put('}', '{');
	parenthesis.put(']', '[');
	for (Character value:input.toCharArray())
	{
		if(checkParenthesis.size()> 0 && checkParenthesis.peek().equals(parenthesis.get(value)))
			checkParenthesis.pop();
		else
			checkParenthesis.push(value);	
			
	}
		return checkParenthesis.isEmpty()? true: false;
	}
}
