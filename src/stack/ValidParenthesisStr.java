package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.junit.Test;

import junit.framework.Assert;

public class ValidParenthesisStr {

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
	
	private boolean isValidParenthesis(String input) {
		for (char value:input.toCharArray())
		{
			String valueStr=value+"";
			if(checkParenthesis.size()> 0 && checkParenthesis.peek().equals(parenthesis.get(valueStr)))
				{
					System.out.println(checkParenthesis.peek());
					checkParenthesis.pop();
				}
			else
				checkParenthesis.push(valueStr);	
				
		}
			return checkParenthesis.isEmpty()? true: false;
		}
/*
 * TC O(n)
 * SC O(n)
 *
	private boolean isValidParenthesis(String input) {
	Stack<String> checkParenthesis=new Stack<String>();
	Map<String,String> parenthesis=new HashMap<String,String>();
	parenthesis.put(")", "(");
	parenthesis.put("}", "{");
	parenthesis.put("]", "[");
	for (char value:input.toCharArray())
	{
		String valueStr=value+"";
		if(checkParenthesis.size()> 0 && checkParenthesis.peek().equals(parenthesis.get(valueStr)))
			{
				System.out.println(checkParenthesis.peek());
				checkParenthesis.pop();
			}
		else
			checkParenthesis.push(valueStr);	
			
	}
		return checkParenthesis.isEmpty()? true: false;
	}*/
}
