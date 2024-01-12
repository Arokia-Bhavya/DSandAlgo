package patterns.twopointer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class PairWithTargetsum {
    /*
    Given an array of numbers sorted in ascending order and a target sum, find a pair in the array whose sum is equal to the given target.
    Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target.
    If no such pair exists return [-1, -1].
    BruteForce Approach
    Iterate elements in a nested loop
    find whether the sum of the element at both the indexes is equal to target
    then return the elements
    TC O(n2)
    Hashing Approach
    Iterate the elements in a single loop
    check whether the (target - element) exists in hashMap if not add the element at the index
    return the elements
    TC O(n) SC O(n)
    2 pointer approach
    traverse 2 pointers in opposite direction
    find the sum of elements at both the pointers
    incase of sum==target return the elements
    incase of sum>target keep decrementing right
    incase of sum<target keep incrementing left
    TC O(n) SC O(1)
    * */
    @Test
    public void test1()
    {
        Assertions.assertArrayEquals(new int[]{1, 3},findPair(new int[] {1, 2, 3, 4, 6},6));
    }
    @Test
    public void test2()
    {
        Assertions.assertArrayEquals(new int[]{0, 2},findPair(new int[] {2, 5, 9, 11},11));
    }
    @Test
    public void test3()
    {
        Assertions.assertArrayEquals(new int[]{-1, -1},findPair(new int[] { 3,3},7));
    }

    private int[] findPair(int[] input, int target) {
        int left=0,right=input.length - 1;
        while(left<right)
        {
            if(input[left]+input[right]==target)
                return new int[]{left,right};
            else if(input[left]+input[right]>target)
                right--;
            else
                left++;
        }
        return new int[]{-1,-1};
    }

    private int[] findPairHashing(int[] input, int target) {
        HashMap<Integer,Integer> pair=new HashMap<Integer,Integer>();
        for(int index=0;index<input.length;index++)
        {
            if(pair.containsKey(input[index]))
            {
                return new int[]{pair.get(input[index]),index};
            }else
            {
                pair.put(target - input[index],index);
            }
        }
        return new int[]{-1,-1};
    }

    private int[] findPairBF(int[] input, int target) {
        for(int index=0;index<input.length;index++)
        {
            for(int nextIndex=index+1;nextIndex<input.length;nextIndex++)
            {
                if(input[index]+input[nextIndex]==target)
                    return new int[]{index,nextIndex};
            }
        }
        return new int[]{-1,-1};
    }
}
