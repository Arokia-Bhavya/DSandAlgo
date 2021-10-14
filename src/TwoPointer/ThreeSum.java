package TwoPointer;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
	
	@Test
	public void example1()
	{
		List<List<Integer>> outputList=new ArrayList<>();
		List<Integer> output1=new ArrayList<Integer>();
		output1.add(-1);
		output1.add(-1);
		output1.add(2);
		outputList.add(output1);
		List<Integer> output2=new ArrayList<Integer>();
		output2.add(-1);
		output2.add(0);
		output2.add(1);
		outputList.add(output2);
		Assert.assertEquals(outputList, threeSum(new int[] {-1,0,1,2,-1,-4}));
	}
	
	@Test
	public void example2()
	{
		List<List<Integer>> outputList=new ArrayList<>();		
		Assert.assertEquals(outputList, threeSum(new int[] {}));
	}
	
	@Test
	public void example3()
	{
		List<List<Integer>> outputList=new ArrayList<>();		
		Assert.assertEquals(outputList, threeSum(new int[] {0}));
	}
	/*TC O(n2) SC O(n)*/
	private List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
        Set<List<Integer>> outputSet = new HashSet<List<Integer>>();
        for(int index=0;index<nums.length;index++)
        {  
        	int remaining= 0 - nums[index];
        	HashSet<Integer> unique=new HashSet<Integer>();
           for(int loopIndex=index+1;loopIndex<nums.length;loopIndex++)
           {	
        	   if(unique.contains(nums[loopIndex]))
        	   {
        		   List<Integer> output=new ArrayList<Integer>();
                   output.add(nums[index]);
                   output.add(remaining - nums[loopIndex]);
                   output.add(nums[loopIndex]);
                   outputSet.add(output);
        	   }else
        	   {
        		   unique.add(remaining - nums[loopIndex]);
        	   }
           }
        }
        
        List<List<Integer>> outputList=new ArrayList<>();
        for(List<Integer> set:outputSet)
        {            
            outputList.add(set);
        }
        return outputList;
	}

	/*TC O(n3) SC O(n)*/
	 private List<List<Integer>> threeSumUsingBF(int[] nums) {
	        Arrays.sort(nums);
	        Set<List<Integer>> outputSet = new HashSet<List<Integer>>();
	        for(int index=0;index<nums.length;index++)
	        {  
	           for(int loopIndex=index+1;loopIndex<nums.length;loopIndex++)
	           {
	               for(int innerIndex=loopIndex+1;innerIndex<nums.length;innerIndex++)
	               {
	                   if(nums[index]+nums[loopIndex]+nums[innerIndex]==0)
	                   {
	                       List<Integer> output=new ArrayList<Integer>();
	                       output.add(nums[index]);
	                       output.add(nums[loopIndex]);
	                       output.add(nums[innerIndex]);
	                       outputSet.add(output);
	                   }
	               }
	           }
	        }
	        List<List<Integer>> outputList=new ArrayList<>();
	        for(List<Integer> set:outputSet)
	        {            
	            outputList.add(set);
	        }
	        return outputList;
	        
	    }

}
