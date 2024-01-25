package patterns.twopointer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class QuadrupleSum {

    @Test
    public void example1()
    {
       List<List<Integer>> expected=new ArrayList<List<Integer>>();
       expected.add(Arrays.asList(-3, -1, 1, 4));
       expected.add(Arrays.asList(-3, 1, 1, 2));
       assertOutput(expected,searchQuadruple(new int[]{4, 1, 2, -1, 1, -3},1));
    }

    @Test
    public void example2()
    {
        List<List<Integer>> expected=new ArrayList<List<Integer>>();
        expected.add(Arrays.asList(-2, 0, 2, 2));
        expected.add(Arrays.asList(-1, 0, 1, 2));
        assertOutput(expected,searchQuadruple(new int[]{2, 0, -1, 1, -2, 2},2));
    }

    private List<List<Integer>> searchQuadruple(int[] input, int target) {
        HashSet<List<Integer>> quadruplet = new HashSet<>();
        Arrays.sort(input);
        for(int index=0;index<input.length;index++)
        {
            for(int nextIndex=index+1;nextIndex<input.length;nextIndex++)
            {
                int twoSum=target - (input[index]+input[nextIndex]);
                for(int left=nextIndex+1,right=input.length-1;left<right;)
                {
                    if(input[left]+input[right]==twoSum)
                    {
                        List<Integer> output=new ArrayList<>();
                        output.add(input[index]);
                        output.add(input[nextIndex]);
                        output.add(input[left]);
                        output.add(input[right]);
                        quadruplet.add(output);
                        left++;
                        right--;
                    }else if(input[left]+input[right]>twoSum)
                        right--;
                    else
                        left++;
                }
            }
        }
        return quadruplet.stream().collect(Collectors.toList());
    }

    private List<List<Integer>> searchQuadrupleUsingHashing(int[] input, int target) {
        HashSet<List<Integer>> quadruplet = new HashSet<>();
        for(int index=0;index<input.length;index++)
        {
            for(int nextIndex=index+1;nextIndex<input.length;nextIndex++)
            {
                HashMap<Integer,Integer> frequency=new HashMap<Integer,Integer>();
                int twoSum=target - (input[index]+input[nextIndex]);
                for(int nextToIndexToIndex=nextIndex+1;nextToIndexToIndex<input.length;nextToIndexToIndex++)
                {
                    if(frequency.containsKey(input[nextToIndexToIndex]))
                    {
                        List<Integer> output=new ArrayList<>();
                        output.add(input[index]);
                        output.add(input[nextIndex]);
                        output.add(frequency.get(input[nextToIndexToIndex]));
                        output.add(input[nextToIndexToIndex]);
                        Collections.sort(output);
                        quadruplet.add(output);
                    }else
                    {
                        frequency.put(twoSum - input[nextToIndexToIndex],input[nextToIndexToIndex]);
                    }
                }
            }
        }
        return quadruplet.stream().collect(Collectors.toList());
    }

    private List<List<Integer>> searchQuadrupleBF(int[] input,int target) {
        HashSet<List<Integer>> quadruplet = new HashSet<>();
        for(int index=0;index<input.length;index++)
        {
            for(int nextIndex=index+1;nextIndex<input.length;nextIndex++)
            {
                for(int nextToIndex=nextIndex+1;nextToIndex<input.length;nextToIndex++)
                {
                    for(int nextToIndexToIndex=nextToIndex+1;nextToIndexToIndex<input.length;nextToIndexToIndex++)
                    {
                        if(input[index]+input[nextIndex]+input[nextToIndex]+input[nextToIndexToIndex]==target)
                        {
                            List<Integer> output=new ArrayList<>();
                            output.add(input[index]);
                            output.add(input[nextIndex]);
                            output.add(input[nextToIndex]);
                            output.add(input[nextToIndexToIndex]);
                            Collections.sort(output);
                            quadruplet.add(output);
                        }
                    }
                }
            }
        }
        return quadruplet.stream().collect(Collectors.toList());
    }


    private void assertOutput(List<List<Integer>> expected, List<List<Integer>> actual) {
        Assertions.assertEquals(expected.size(),actual.size());
        for(int index = 0; index< expected.size(); index++)
        {
            Assertions.assertEquals(expected.contains(actual.get(index)),true);
        }
    }
}
