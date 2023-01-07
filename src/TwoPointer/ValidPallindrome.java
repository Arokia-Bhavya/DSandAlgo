package TwoPointer;

import org.junit.Assert;
import org.junit.Test;

public class ValidPallindrome {

@Test
public void example1()
{
	Assert.assertEquals(true,isValid( "A man, a plan, a canal: Panama"));
}



@Test
public void example2()
{
	Assert.assertEquals(false, isValid( "race a car"));	
}
/*TC O(n) SC O(n)*/
private Object isValid(String input) {
	StringBuilder cleanInput=new StringBuilder(input.length());
	for(char value:input.toLowerCase().toCharArray())
	{
		if(Character.isLetterOrDigit(value))
			cleanInput.append(value);
	}
	String firstHalf=cleanInput.substring(0, input.length()/2);
	String secondHalf=cleanInput.reverse().substring(0, input.length()/2);
	return firstHalf.equals(secondHalf);
}



/*TC O(n/2)*/
private boolean isValidUsing2Pointer(String input) {
	char[] inputArray=input.toLowerCase().toCharArray();
	for(int left=0,right=input.length() - 1;left<right;)
	{
		if(Character.isAlphabetic(inputArray[left]) && Character.isAlphabetic(inputArray[right]))
		{
			if(inputArray[left] != inputArray[right])
				return false;
			left++;
			right--;
		}else if(!Character.isAlphabetic(inputArray[left]))
		{
			left++;
		}else if(!Character.isAlphabetic(inputArray[right]))
		{
			right--;
		}
				
	}
	return true;
}
}
