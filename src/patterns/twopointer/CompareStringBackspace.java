package patterns.twopointer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class CompareStringBackspace {
    /*
    Given two strings containing backspaces (identified by the character ‘#’), check if the two strings are equal.

    Iterate the characters in the string
    append the character to stringbuilder
    if it s equal to '#' remove the last character
    check the equals
    TC O(n+m)
    Iterate the characters in the string
    push the character to stack
    pop the character from stack if it s equal to '#'
    TC O(n+m) SC O(n+m)
    2 pointer approach
    intialize right1 and right2 pointer
    keep checking the character at both the pointers
    O(max(n,m)) SC O(1)
     */

    @Test
    public void example1()
    {
        Assertions.assertEquals(true,compareString("xy#z", "xzz#"));
    }

    @Test
    public void example2()
    {
        Assertions.assertEquals(false,compareString("xy#z", "xyz#"));
    }

    @Test
    public void example3()
    {
        Assertions.assertEquals(true,compareString("xp#","xyz##"));
    }

    private boolean compareString(String firstText, String secondText) {
        int firstCount=0,secondCount=0;
        for(int right1=firstText.length() - 1,right2=secondText.length() - 1;right1>0 && right2>0;right1--,right2--)
        {
            while (firstText.charAt(right1)=='#')
            {
                right1--;
                firstCount++;
            }
            while(firstCount>0)
            {
                right1--;
                firstCount--;
            }

            while (secondText.charAt(right2)=='#')
            {
                right2--;
                secondCount++;
            }
            while(secondCount>0)
            {
                right2--;
                secondCount--;
            }
            if(firstText.charAt(right1)!=secondText.charAt(right2))
                return false;
        }
        return true;
    }

    private boolean compareStringStack(String firstText, String secondText) {
        return removeBackSpaceCh(firstText).equals(removeBackSpaceCh(secondText));
    }

    private Stack<Character> removeBackSpaceCh(String input) {
        Stack<Character> output=new Stack<Character>();
        for(Character value:input.toCharArray())
        {
            if(value=='#')
                output.pop();
            else
                output.push(value);
        }
        return output;
    }

    private boolean compareStringBF(String s, String t) {
        return removeBackSpace(s).equals(removeBackSpace(t));
    }

    private String removeBackSpace(String input) {
        StringBuilder output=new StringBuilder();
        for(Character value:input.toCharArray())
        {
            if(value=='#')
                output.deleteCharAt(output.length() -1);
            else
                output.append(value);
        }
        return output.toString();
    }

}
