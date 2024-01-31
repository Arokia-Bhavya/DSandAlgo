package patterns.slidingwindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MinSizeSubarray {
    /*
    Bruteforce
    Iterate the elements from index 0 to n
	    Iterate the elements from index+1 to n
		    Keep calculating the sum
		    Check sum>=target
		    Then assign length=(currentposition – index)+1
    TC O(n*n) SC O(1)

    Sliding window
    Iterate the elements from right 0 to n
	        Keep incrementing the sum with element at right
		    Check sum>=target
		        Then assign length=(right – left)+1
		        Keep decrementing the sum with element at left
		        increment left
    TC O(n*n) SC O(1)

    Input: [2, 1, 5, 2, 8], S=7
    Output: 1

    Left=0 right=0 sum=2
    Left=0 right=1 sum=3
    Left=0 right=2 sum=8 length=3 minLength=3
    Left=1 right=2 sum=6
    Left=1 right=3 sum=8 length=3 minLength=3
    Left=2 right=3 sum=7 length=2 minLength=2
    Left=3 right=3 sum=2
    Left=3 right=4 sum=10 length=2 minLength=2
    Left=4 right=4 sum=8  length=1 minLength=1

    TC O(n) SC O(1)

     */
    @Test
    public void example1()
    {
        Assertions.assertEquals(2,minSubArrayLen(new int[]{2, 1, 5, 2, 3, 2},7));
    }

    @Test
    public void example2()
    {
        Assertions.assertEquals(1,minSubArrayLen(new int[]{2, 1, 5, 2, 8},7));
    }

    @Test
    public void example3()
    {
        Assertions.assertEquals(3,minSubArrayLen(new int[]{3, 4, 1, 1, 6},8));
    }

    private int minSubArrayLen(int[] input, int target) {
        int minLength=Integer.MAX_VALUE;
        int sum=0;
        for(int left=0,right=0;right<input.length;right++)
        {
            sum=sum+input[right];
            while(sum>=target)
            {
                minLength=Math.min(minLength,(right - left)+1);
                sum=sum-input[left];
                left++;
            }
        }
        return minLength;
    }

    private int minSubArrayLenBF(int[] input, int target) {
        int minLength=Integer.MAX_VALUE;

        for(int start=0;start<input.length;start++)
        {
            int sum=input[start];
            if(sum>=target)
                minLength=Math.min(minLength,1);
            for(int end=start+1;end<input.length;end++)
            {
                sum=sum+input[end];
                if(sum>=target)
                    minLength=Math.min(minLength,(end - start)+1);
            }
        }
        return minLength;
    }

}
