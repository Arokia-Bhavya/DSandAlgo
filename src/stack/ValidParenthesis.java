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

	private boolean isValidParenthesis(String input) {
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
