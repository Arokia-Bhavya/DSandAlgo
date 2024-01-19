package patterns.twopointer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MinimumWindowSort {
    /*
    Given an array, find the length of the smallest subarray in it which when sorted will sort the whole array.
    Bruteforce approach
    copy and sort the array
    keep incrementing the left pointer in both input and sorted till elements at position are same
    keep incrementing the right pointer in both input and sorted till elements at position are same
    length = (right - left)+1
    TC O(nlogn) SC O(n)
    Two pointer
    keep incrementing the left pointer until element at left less than element at left+1 pointer
    keep decrementing the right pointer until element at right greater than element at right-1 pointer
    length=(right - left)+1
    To cover sorted array corner case
    **********************************
    when the left pointer reached end of the array that means array s already sorted
    To cover case where elements exist out of the current found window
    ******************************************************************
    Iterate the elements from left to right,calculate the min and max
    Iterate the element from left to 0,when there is any element found greater than min,update left
    Iterate the element from right to end of array,when there is any element found less than max,update right
    TC O(n) SC O(1)
     */

    @Test
    public void example1()
    {
        Assertions.assertEquals(5,calcLength(new int[]{1, 2, 5, 3, 7, 10, 9, 12}));
    }

    @Test
    public void example2()
    {
        Assertions.assertEquals(5,calcLength(new int[]{1, 3, 2, 0, -1, 7, 10}));
    }

    @Test
    public void example3()
    {
        Assertions.assertEquals(0,calcLength(new int[]{1, 2, 3}));
    }

    @Test
    public void example4()
    {
        Assertions.assertEquals(3,calcLength(new int[]{3, 2, 1}));
    }

    private int calcLength(int[] input) {
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int left=0;
        int right=input.length - 1;
        while(left<input.length-1 && input[left]<=input[left+1])
        {
            left++;
        }
        if(left==input.length - 1)
            return 0;
        while(right>0 && input[right]>=input[right-1])
        {
            right--;
        }
        for(int index=left;index<=right;index++)
        {
            max=Math.max(max,input[index]);
            min=Math.min(min,input[index]);
        }
        for(int index=left;index>=0;index--)
        {
            if(input[index]>min) {
                left = index;
            }
        }
        for(int index=right;index<input.length;index++)
        {
            if(input[index]<max)
            {
                right=index;
            }

        }
        return (right-left)+1;
    }

    private int calcLengthBF(int[] input) {
        int[] sorted= Arrays.copyOf(input,input.length);
        Arrays.sort(sorted);
        int left=0;
        while(left<input.length && input[left]==sorted[left])
        {
            left++;
        }
        int right=input.length - 1;
        while(right>=0 && input[right]==sorted[right])
        {
            right--;
        }
        return right>left?(right - left)+1:0;
    }
}
