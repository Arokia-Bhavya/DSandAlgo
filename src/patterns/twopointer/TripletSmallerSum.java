package patterns.twopointer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;


public class TripletSmallerSum {
    /*
    Given an array arr of unsorted numbers and a target sum, count all triplets in it such that arr[i] + arr[j] + arr[k] < target
    where i, j, and k are three different indices. Write a function to return the count of such triplets.
    Bruteforce approach
    Iterate the elements 3 nested loop
    caculate the sum and if it is less than target increment the count
    TC O(n3)
    2 Pointer approach
    sort the elements
    Iterate the elements and fix the index
    Intialize the left as index+1 and right as last position
    calculate the sum and if it s less than target increment the count to right - left & increment left
    otherwise decrement right
     */
    @Test
    public void example1()
    {
        Assertions.assertEquals(2,searchTriplets(new int[]{-1, 0, 2, 3},3));
    }



    @Test
    public void example2()
    {
        Assertions.assertEquals(4,searchTriplets(new int[]{-1, 4, 2, 1, 3},5));
    }

    private int searchTriplets(int[] input, int target) {
        Arrays.sort(input);
        int count=0;
        for (int index=0;index<input.length;index++)
        {
            for(int left=index+1,right=input.length - 1;left<right;)
            {
                int sum=input[index]+input[left]+input[right];
                if(sum<target)
                {
                    count=count+(right-left);
                    left++;
                }else
                {
                    right--;
                }
            }
        }
        return count;
    }


    private int searchTripletsBF(int[] input, int target) {
        int count=0;
        for (int index=0;index<input.length;index++)
        {
            for(int nextIndex=index+1;nextIndex<input.length;nextIndex++)
            {
                for(int nextToIndex=nextIndex+1;nextToIndex<input.length;nextToIndex++)
                {
                    if(input[index]+input[nextIndex]+input[nextToIndex]<target)
                        count++;
                }
            }
        }
        return count;
    }
}
