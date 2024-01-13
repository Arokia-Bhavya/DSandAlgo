package patterns.twopointer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SquareSortArray {

    /*
    Given a sorted array, create a new array containing squares of all the numbers of the input array in the sorted order.

    bruteforce approach
    create a new array,iterate and square the elements
    TC O(nlogn) SC O(n)
    2 pointer approach
    intialize left as 0 and right as last element
    TC O(n)
     */

    @Test
    public void example1()
    {
        Assertions.assertArrayEquals(new int[]{0, 1, 4, 4, 9},makeSquares(new int[]{-2, -1, 0, 2, 3}));
    }

    @Test
    public void example2()
    {
        Assertions.assertArrayEquals(new int[]{0, 1, 1, 4, 9},makeSquares(new int[]{-3, -1, 0, 1, 2}));
    }

    private int[] makeSquares(int[] input) {
        int[] output=new int[input.length];
        int left=0,right=input.length - 1;
        int count=input.length - 1;
        for(;left<right;)
        {
            if(Math.abs(input[right]) > Math.abs(input[left]))
            {
                output[count--]=input[right]*input[right];
                right--;
            }else {
                output[count--]=input[left]*input[left];
                left++;
            }

        }
        return output;
    }

    private int[] makeSquaresBF(int[] input) {
        int[] output=new int[input.length];
        for(int index=0;index<input.length;index++)
        {
            output[index]=input[index]*input[index];
        }
        Arrays.sort(output);
        return output;
    }
}
