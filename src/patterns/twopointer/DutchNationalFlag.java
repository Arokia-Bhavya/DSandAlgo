package patterns.twopointer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class DutchNationalFlag {
    /*
    Given an array containing 0s, 1s and 2s, sort the array in-place. You should treat numbers of the array as objects,
    hence, we can’t count 0s, 1s, and 2s to recreate the array.
    Bruteforce
    Iterate the elements in nested loop
    and keep swapping the elements
    TC O(n2)
    Sort
    using inbuilt sort function
    TC O(nlogn)
    CountSort
    iterate the elements and keep counting the 0s,1s and 2s
    iterate the elements and assign O till count0s becomes zero
    iterate the elements and assign 1 till count1s becomes zero
    iterate the elements and assign 2 till count2s becomes zero
    O(n)
     */
    @Test
    public void example1()
    {
        Assertions.assertArrayEquals(new int[]{0,0, 1, 1, 2},countSort(new int[]{1, 0, 2, 1, 0}));
    }


    @Test
    public void example2()
    {
        Assertions.assertArrayEquals(new int[]{0, 0, 1, 2, 2, 2},countSort(new int[]{2, 2, 0, 1, 2, 0}));

    }

    private int[] countSort(int[] input) {
        
    }

    private int[] countSortInbuilt(int[] input) {
       Arrays.sort(input);
       return input;
    }

    private int[] countSortBF(int[] input) {
        for(int index=0;index<input.length;index++)
        {
            for(int nextIndex=index+1;nextIndex<input.length;nextIndex++)
            {
                if(input[index]>input[nextIndex])
                {
                    int temp=input[index];
                    input[index]=input[nextIndex];
                    input[nextIndex] = temp;
                }
            }
        }
        return input;
    }
}
