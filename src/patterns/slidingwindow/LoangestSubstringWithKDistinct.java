package patterns.slidingwindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class LoangestSubstringWithKDistinct {
    /*
    Given a string, find the length of the longest substring in it with no more than K distinct characters.
    Example 1:

        Input: s = "abcabcbb"
        Output: 3
        Explanation: The answer is "abc", with the length of 3.
        Example 2:

        Input: s = "bbbbb"
        Output: 1
        Explanation: The answer is "b", with the length of 1.
        Example 3:

        Input: s = "pwwkew"
        Output: 3
        Explanation: The answer is "wke", with the length of 3.
        Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
         BruteForce
        Intialize empty unique set
        Iterate the characters one by one nested loop
        add it to the set only if the character is not present in it
        if the character is already present,calculate the length as size of the set,exit out of the loo[]
        TC O(n2) SC O(n)
        iteration 0 set[a]
        iteration 1 set[a,b]
        iteration 2 set[a,b,c]
        iteration 3 a is there in set length=3 maxLength=3
        iteration 1 set[b]
        iteration 2 set[b,c]
        iteration 3 set[b,c,a]
        iteration 4 b is there in set length=3 maxlength=3
        iteration 2 set [c]
        iteration 3 set [c,a]
        iteration 4 set [c,a,b]
        iteration 5 c is there in set length=3 maxlength=3
        iteration 3 set[a]
        iteration 4 set[a,b]
        iteration 5 set [a,b,c]

        SlidingWindow Approach TC O(n) SC O(n)
        Intialize empty unique set
        Iterate the character one by one
        add it to the set only if the character is not present in it
        if the character is already present,calculate the length as size of the set,remove the character at left pointer and increment it
        Input: s = "pwwkew"
        left=0 right=0
        set [p] length=1 maxlength=1
        left=0 right=1
        set [p,w] length=2 maxlength=2
        left=0 right=2 set[w]
        left=1 right=2 set[]
        left=2 right=2
        set[w]
        left=2 right=3 set[w,k] length=2 maxlength=2
        left=2 right=4 set[w,k,e] length=3 maxlength=3
        left=3 right=5 set[k,e,w] length=3 maxlength=3

     */
    @Test
    public void example1()
    {
        Assertions.assertEquals(4,calcLongestSubstringLength("araaci",2  ));
    }

    @Test
    public void example2()
    {
        Assertions.assertEquals(2,calcLongestSubstringLength("araaci",1  ));
    }

    @Test
    public void example3()
    {
        Assertions.assertEquals(5,calcLongestSubstringLength("cbbebi",3  ));
    }

    private int calcLongestSubstringLength(String input, int target) {
        HashMap<Character,Integer> unique=new HashMap<Character,Integer>();
        int maxLength=Integer.MIN_VALUE;
        int left=0;
        for (int right=0;right<input.length();right++)
        {
            unique.put(input.charAt(right), unique.getOrDefault(input.charAt(right),0)+1);
            while(unique.size()>target)
                {
                    unique.put(input.charAt(left), unique.getOrDefault(input.charAt(left),0)-1);
                    if(unique.get(input.charAt(left))==0)
                        unique.remove(input.charAt(left));
                    left++;
                }
                maxLength=Math.max(maxLength,(right - left)+1);
        }
        return maxLength;
    }
}
