package patterns.fastslowpointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.HashSet;

public class CircularArrayLoop {

    @Test
    public void example1()
    {
        Assertions.assertEquals(true,isCircularArrayLoop(new int[]{2,-1,1,2,2}));
    }

    @Test
    public void example2()
    {
        Assertions.assertEquals(false,isCircularArrayLoop(new int[]{-1,-2,-3,-4,-5,6}));
    }

    @Test
    public void example3()
    {
        Assertions.assertEquals(true,isCircularArrayLoop(new int[]{1,-1,5,1,4}));
    }

    /*
    
     */
    private boolean isCircularArrayLoopBF(int[] nums) {
        for(int index=0;index<nums.length;index++) {
            HashSet<Integer> visitedNode=new HashSet<Integer>();
            int start=index;
            if (nums[index] == 0)
                continue;
            while(nums[start]*nums[getNextPosition(nums,start)]>0)
            {
                if(!visitedNode.add(index))
                {
                    if(start!=getNextPosition(nums,start))
                        return true;
                    break;
                }
                start=getNextPosition(nums,start);
            }
        }
        return false;
    }

    private boolean isCircularArrayLoop(int[] nums) {
        for(int index=0;index<nums.length;index++)
        {
            if(nums[index]==0)
                continue;
            int slow=index;
            int fast=getNextPosition(nums,index);
            while(nums[slow]*nums[fast]>0 && nums[slow]*nums[getNextPosition(nums,fast)]>0)
            {
                if(slow==fast)
                {
                    if(slow!=getNextPosition(nums,slow))
                        return true;
                    break;
                }
                slow=getNextPosition(nums,slow);
                fast=getNextPosition(nums,getNextPosition(nums,fast))   ;

            }
        }
        return false;
    }

    public  int getNextPosition(int[] nums, int index) {
        return (index + nums[index] % nums.length + nums.length) % nums.length;
    }
}

