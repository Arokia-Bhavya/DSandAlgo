package patterns.twopointer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class ProductSubArray {
    /*
    Given an array with positive numbers and a positive target number,
    find all of its contiguous subarrays whose product is less than the target number.
    Bruteforce Approach
    Iterate the elements in nested loop
    keep calculating the product and check if product less than target
    add it to the list
    TC O(n2)
    2 Pointer approach
    intialize 2 pointers left1 and left2 as 0
    calculate product and and check if product less than target,add it to the list
    increment the left2 and keep calculating the product
    when the product is greater than target
    increment the left1 and keep dividing the product with the element at left1 until left1<left2
    otherwise ,create and add it to the list from left2 to left1
    [2, 5, 3, 10] left1=0 left2=0 product=2 (2) result=[[2]]
    [2, 5, 3, 10] left1=0 left2=1 product=10 (2*5) result=[[2],[5],[2,5]]
    [2, 5, 3, 10] left1=0 left2=2 product=30 (2*5*3)
    [2, 5, 3, 10] left1=1 left2=2 product=15 (30/2) result=[[2],[2,5],[5],[3],[3,5]]
    [2, 5, 3, 10] left1=1 left2=3 product=150 (5*3*10)
    [2, 5, 3, 10] left1=1 left2=3 product=30 (150/5)
    [2, 5, 3, 10] left1=2 left2=3 product=10 (30/3) result=[[2],[2,5],[5],[3],[3,5],[10]]
    TC O(n)
     */

    @Test
    public void example1()
    {
        List<List<Integer>> result=new ArrayList<List<Integer>>(){
            {
                add(Arrays.asList(2));
                add(Arrays.asList(5));
                add(Arrays.asList(2, 5));
                add(Arrays.asList(3));
                add(Arrays.asList(5, 3));
                add(Arrays.asList(10));
            }
        };
        assertOutput(result,findSubarrays(new int[]{2, 5, 3, 10},30));
    }

    @Test
    public void example2()
    {
        List<List<Integer>> result=new ArrayList<List<Integer>>(){
            {
                add(Arrays.asList(8));
                add(Arrays.asList(2));
                add(Arrays.asList(8, 2));
                add(Arrays.asList(6));
                add(Arrays.asList(2, 6));
                add(Arrays.asList(5));
                add(Arrays.asList(6,5));
            }
        };
        assertOutput(result,findSubarrays(new int[]{8, 2, 6, 5},50));
    }



    private void assertOutput(List<List<Integer>> expected, List<List<Integer>> actual) {
        Assertions.assertEquals(expected.size(),actual.size());
        for(int index = 0; index< actual.size(); index++)
        {
            Assertions.assertEquals(expected.contains(actual.get(index)),true);
        }
    }
    private List<List<Integer>> findSubarrays(int[] arr, int target) {

        HashSet<List<Integer>> result = new HashSet<>();
        int product=1;
        for(int left1=0,left2=0;left2<arr.length;left2++)
        {
            product=product*arr[left2];
            while(product>=target)
            {
                product=product/arr[left1];
                left1++;
            }
            List<Integer> subArr=new ArrayList<Integer>();
            for(int index=left2;index>=left1;index--)
            {
                subArr.add(0,arr[index]);
                result.add(new ArrayList<>(subArr));
            }
        }

        return result.stream().collect(Collectors.toList());

    }

    public List<List<Integer>> findSubarraysBF(int[] arr, int target) {
        HashSet<List<Integer>> result = new HashSet<>();
        for(int index=0;index<arr.length;index++)
        {
            int product=arr[index];
            List<Integer> subArr=new ArrayList<Integer>();
            if(product<target)
            {
                subArr.add(arr[index]);
                result.add(subArr);
            }

            for(int nextIndex=index+1;nextIndex<arr.length;nextIndex++)
            {
                product=product*arr[nextIndex];
                if(product<target)
                {
                    subArr=new ArrayList<>(subArr);
                    subArr.add(arr[nextIndex]);
                    result.add(subArr);
                }else
                    break;
            }
        }
        return result.stream().collect(Collectors.toList());
    }

}
