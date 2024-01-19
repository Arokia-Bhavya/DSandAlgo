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
    Iterate the elements
    Check the element at index > max,update max=element at index otherwise right=index
    Check the element at (n - index -1) < min,update min=element at (n - index -1) otherwise left=(n - index -1)
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
        int left=-1;
        int right=-1;
        for(int index=0;index<input.length;index++)
        {
            if(input[index]>=max)
                max=input[index];
            else
                right=index;

            if(input[input.length - index - 1]<=min)
                min=input[input.length - index - 1];
            else
                left=input.length - index - 1;

        }
        return right == -1 ? 0 : right - left + 1;
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
