package patterns.fastslowpointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class HappyNumber {

    @Test
    public void example1()
    {
        Assertions.assertEquals(true,isHappy(19));
    }

    @Test
    public void example2()
    {
        Assertions.assertEquals(false,isHappy(2));
    }

    /*TC O(n) SC O(n)*/
    private boolean isHappyHashing(int num) {
        HashSet<Integer> seen=new HashSet<Integer>();
        while(!seen.contains(num))
        {
            seen.add(num);
            num=sumOfSquareDigits(num);
        }
        return num==1;
    }

    /*TC O(logn) SC O(1)*/
    private boolean isHappy(int num) {
        int slow=num;
        int fast=sumOfSquareDigits(num);
        while(slow!=fast)
        {
            slow=sumOfSquareDigits(slow);
            fast=sumOfSquareDigits(sumOfSquareDigits(fast));
        }
        return slow==1;
    }

    int sumOfSquareDigits(int num)
    {
        int totalSum=0;
        while(num>0) {
            num = num % 10;
            totalSum = num * num + totalSum;
            num=num/10;
        }
        return totalSum;
    }
}
