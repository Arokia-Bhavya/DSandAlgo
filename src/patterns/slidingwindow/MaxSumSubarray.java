package patterns.slidingwindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.LinkedList;
import java.util.Queue;

public class MaxSumSubarray {
    /*
    Given an array of positive numbers and a positive number 'k,' find the maximum sum of any contiguous subarray of size 'k'.
    Bruteforce
    iterate the elements of every size k
    keep adding and calculate the maximum sum
    TC O(n2)
    Queue
    calculate the windowsum and push the elements to the queue
    keep subtracting the element at left and adding the element at right
    incase the new window sum is less than the stored one,replace it
    TC O(n) SC O(k)
    Sliding window
    calculate the window sum of size k
    keep subtracting the element at left and  adding the element at right
    incase the new window sum is less than the stored one,replace it
    TC O(n)
     */

    @Test
    public void example1()
    {
        Assertions.assertEquals(calcMax(new int[]{2, 1, 5, 1, 3, 2},3),9);
    }

    @Test
    public void example2()
    {
        Assertions.assertEquals(calcMax(new int[]{2, 3, 4, 1, 5},2),7);
    }

    private int  calcMaxQueue(int[] input, int size) {
        Queue<Integer> window=new LinkedList<Integer>();
        int windowSum=0;
        int maxSum=0;
        for(int index=0;index<size;index++)
        {
            window.add(input[index]);
            windowSum=windowSum+ input[index];
        }
        maxSum=Math.max(maxSum,windowSum);
        for(int index=size;index<input.length;index++)
        {
            windowSum=windowSum - window.remove();
            window.add(input[index]);
            windowSum=windowSum + input[index];
            maxSum=Math.max(maxSum,windowSum);
        }
        return maxSum;
    }

    private int calcMax(int[] input, int size) {
        int windowSum=0;
        int maxSum=0;
        for(int index=0;index<size;index++)
            windowSum=windowSum+input[index];
        maxSum= Math.max(maxSum,windowSum);
        for(int index=size;index<input.length;index++)
        {
            windowSum=windowSum+ input[index] - input[index - size];
            maxSum= Math.max(maxSum,windowSum);
        }
        return maxSum;
    }

    private int calcMaxBF(int[] input, int size) {
        int maxSum=Integer.MIN_VALUE;
        for(int index=0;index<input.length - size;index++ )
        {
            int windowSum=0;
            for(int window=index;window<index+size;window++ )
            {
                windowSum=windowSum+input[window];
            }
            maxSum=Math.max(maxSum,windowSum);
        }
        return maxSum;
    }
}
