package patterns.twopointer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class NonDuplicate {

    /*
    Given an array of sorted numbers, move all non-duplicate number instances at the beginning of the array in-place.
    The relative order of the elements should be kept the same and you should not use any extra space so that the solution has constant space complexity i.e., .
    Move all the unique number instances at the beginning of the array and after moving return the length of the subarray that has no duplicate in it
     bruteforce approach
     iterate the elements in nested loop
     when the elements at index didnot get repeated add it to the output
     TC O(n2)
     hashing approach
     add the elements to the set
     add the elements to the array and return the size of the set
     TC O(n) SC O(n)
     2 pointer
     iterate the elements
     move the left & right pointer
     when the element at left is not equal to element at right
     assign the element at left and keep incrementing
     TC O(n)
     */
     @Test
     public void example1()
     {
       Assertions.assertEquals(remove(new int[]{2, 3, 3, 3, 6, 9, 9}),4);
     }

     @Test
     public void example2()
     {
          Assertions.assertEquals(remove(new int[]{2, 2, 2, 11}),2);
     }

     public int removeBF(int[] input)
     {
          int count=0;
          for(int index=0;index < input.length;index++)
          {
               boolean isDuplicateFound=false;
               for(int nextIndex=index+1;nextIndex<input.length;nextIndex++)
               {
                    if(input[index]==input[nextIndex])
                    {
                         isDuplicateFound=true;
                         break;
                    }
               }
               if(!isDuplicateFound)
                    input[count++]=input[index];
          }
          return count;
     }

     public int removeHashing(int[] input)
     {
          HashSet<Integer> output=new HashSet<Integer>();
          for(int index=0;index < input.length;index++)
          {
               output.add(input[index]);
          }
          int left=0;
          for(int value:output)
          {
               input[left++]=value;
          }
          return output.size();
     }

     public int remove(int[] input)
     {
          int left=0;
          int right=1;
          for(;right < input.length;right++)
          {
               if(input[right-1]!=input[right])
                    input[left++]=input[right-1];
          }
          if(input[left]!=input[input.length - 1])
               input[left++]=input[right-1];
          return left;
     }

}
