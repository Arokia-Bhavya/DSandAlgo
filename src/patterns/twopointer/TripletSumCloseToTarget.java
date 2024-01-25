package patterns.twopointer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


public class TripletSumCloseToTarget {
    /*
    Given an array of unsorted numbers and a target number, find a triplet in the array whose sum is as close to the target number as possible,
    return the sum of the triplet. If there are more than one such triplet, return the sum of the triplet with the smallest sum.
    Bruteforce
    loop the elements 3 times
        calculate sum,minDistance & assign the minDistance & closestSum
     O(n3)
     two pointer approach
     loop the elements
     intialize left=0 and right=n-1
     calculate sum,minDistance


     */

    @Test
    public void example1()
    {
        Assertions.assertEquals(2,searchTriplet(new int[]{-1, 0, 2, 3},3));
    }



    @Test
    public void example2()
    {
        Assertions.assertEquals(3,searchTriplet(new int[]{1, 0, 1, 1},100));
    }

    @Test
    public void example3()
    {
        Assertions.assertEquals(4,searchTriplet(new int[]{0, 0, 1, 1, 2, 6},5));
    }

    @Test
    public void example4()
    {
        Assertions.assertEquals(0,searchTriplet(new int[]{-3, -1, 1, 2},1));
    }



    private int searchTriplet(int[] input, int target) {
        int closestSum=Integer.MAX_VALUE;
        Arrays.sort(input);
        for(int index=0;index<input.length;index++) {
            for (int left = index + 1,right=input.length-1; left < right; ) {
                int sum=input[index]+input[left]+input[right];
                if(sum>target)
                {
                    right--;
                }else
                {
                    left++;
                }
                if(Math.abs(target - sum)<Math.abs(target - closestSum))
                {
                    closestSum=sum;
                }else if(Math.abs(target - sum)==Math.abs(target - closestSum))
                {
                    closestSum=Math.min(sum,closestSum);
                }
            }
        }
        return closestSum;
    }

    private int searchTripletBF(int[] input, int target) {
        int closestSum=Integer.MAX_VALUE;
        for(int index=0;index<input.length;index++)
        {
            for(int nextIndex=index+1;nextIndex<input.length;nextIndex++)
            {
                for(int nextToIndex=nextIndex+1;nextToIndex<input.length;nextToIndex++)
                {
                    int sum=input[index]+input[nextIndex]+input[nextToIndex];
                    if(Math.abs(target - sum)<Math.abs(target - closestSum))
                    {
                        closestSum=sum;
                    }else if(Math.abs(target - sum)==Math.abs(target - closestSum))
                    {
                        closestSum=Math.min(sum,closestSum);
                    }
                }
            }
        }
        return closestSum;
    }
}
