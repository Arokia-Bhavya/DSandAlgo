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

private boolean isValid(String input) {
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
