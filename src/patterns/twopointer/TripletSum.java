package patterns.twopointer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class TripletSum {
    /*
    Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
    Bruteforce
    Iterate the elements in nested loop
    keep adding the numbers at all the 3 indexes,
    if it equals to 0,add to the output
    TC O(n3)
    Hashing
    Iterate the elements in nested loop
    keep the remaining(0 - (nums[index] + nums[nextIndex])) as key in the hashMap,and nums[nexIndex] as value
    if the key exists add the 3 numbers to the output
    TC O(n2) SC O(n)
    Sort the elements
    initialize left,previousright,right
    iterate the elements
    when the sum is less than 0 increment left
    when the sum is greater than 0 decrement right and previousright
    when the sum is equals to 0 add the numbers to the output
    TC O(n2)
     */
    @Test
    public void example1()
    {
        List<List<Integer>> result=new ArrayList<List<Integer>>(){
            {
                add(Arrays.asList(-3, 1, 2));
                add(Arrays.asList(-2, 0, 2));
                add(Arrays.asList(-2, 1, 1));
                add(Arrays.asList(-1, 0, 1));
            }
        };
        assertOutput(result,searchTriplets(new int[]{-3, 0, 1, 2, -1, 1, -2}));
    }

    @Test
    public void example2()
    {
        List<List<Integer>> result=new ArrayList<List<Integer>>(){
            {
                add(Arrays.asList(-5, 2, 3));
                add(Arrays.asList(-2, -1, 3));
            }
        };
        assertOutput(result,searchTriplets(new int[]{-5, 2, -1, -2, 3}));
    }

    private List<List<Integer>> searchTriplets(int[] input) {
        Arrays.sort(input);
        HashSet<List<Integer>> triplets = new HashSet<>();
        for(int index=0;index<input.length;index++)
        {
            int target=0-(input[index]);
            for(int left=index+1,right=input.length-1;left<right;)
            {
                if((input[left]+input[right])==target)
                {
                    List<Integer> arrList=new ArrayList<Integer>();
                    arrList.add(input[index]);
                    arrList.add((input[left]));
                    arrList.add(input[right]);
                    triplets.add(arrList);
                    left++;
                    right--;
                }else if((input[left]+input[right])>target)
                    right--;
                else
                    left++;
            }
        }
        return triplets.stream().collect(Collectors.toList());
    }

    private List<List<Integer>> searchTripletsHashing(int[] input) {
        HashSet<List<Integer>> triplets = new HashSet<>();
        for(int index=0;index<input.length;index++) {
            HashMap<Integer,Integer> frequency=new HashMap<Integer,Integer>();
            for (int nextIndex = index + 1; nextIndex < input.length; nextIndex++) {
                    if(frequency.containsKey(input[nextIndex]))
                    {
                        List<Integer> arrList=new ArrayList<Integer>();
                        arrList.add(input[index]);
                        arrList.add(frequency.get(input[nextIndex]));
                        arrList.add(input[nextIndex]);
                        Collections.sort(arrList);
                        triplets.add(arrList);
                    }else
                    {
                        frequency.put(0 - (input[index]+input[nextIndex]),input[nextIndex]);
                    }
            }
        }
        return triplets.stream().collect(Collectors.toList());
    }

    private void assertOutput(List<List<Integer>> result, List<List<Integer>> output) {
        Assertions.assertEquals(result.size(),output.size());
        for(int index = 0; index< result.size(); index++)
        {
            Assertions.assertEquals(output.contains(result.get(index)),true);
        }
    }

    public List<List<Integer>> searchTripletsBF(int[] input) {
        HashSet<List<Integer>> triplets = new HashSet<>();
        for(int index=0;index<input.length;index++)
        {
            for(int nextIndex=index+1;nextIndex<input.length;nextIndex++)
            {
                for(int nextToIndex=nextIndex+1;nextToIndex<input.length;nextToIndex++)
                {
                    if(input[index]+input[nextIndex]+input[nextToIndex]==0)
                    {
                        List<Integer> arrList=new ArrayList<Integer>();
                        arrList.add(input[index]);
                        arrList.add(input[nextIndex]);
                        arrList.add(input[nextToIndex]);
                        Collections.sort(arrList);
                        triplets.add(arrList);
                    }
                }
            }
        }
        return triplets.stream().collect(Collectors.toList());
    }
}
