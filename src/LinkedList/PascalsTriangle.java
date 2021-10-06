package LinkedList;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PascalsTriangle {
	
	@Test
	public void example1()
	{
		List<List<Integer>> output=new ArrayList<List<Integer>>();
		List<Integer> output1=new ArrayList<Integer>();
		output1.add(1);
		output.add(output1);
		List<Integer> output2=new ArrayList<Integer>();
		output2.add(1);
		output2.add(1);
		output.add(output2);
		List<Integer> output3=new ArrayList<Integer>();
		output3.add(1);
		output3.add(2);
		output3.add(1);
		output.add(output3);
		List<Integer> output4=new ArrayList<Integer>();
		output4.add(1);
		output4.add(3);
		output4.add(3);
		output4.add(1);
		output.add(output4);
		List<Integer> output5=new ArrayList<Integer>();
		output5.add(1);
		output5.add(4);
		output5.add(6);
		output5.add(4);
		output5.add(1);
		output.add(output5);
		assertEquals(true,output.equals(generate(5)));		
	}
	
	@Test
	public void example2()
	{
		List<List<Integer>> output=new ArrayList<List<Integer>>();
		List<Integer> output1=new ArrayList<Integer>();
		output1.add(1);
		output.add(output1);
		assertEquals(true,output.equals(generate(1)));
	}

	private List<List<Integer>> generate(int num) {
		List<List<Integer>> output=new ArrayList<List<Integer>>();
		
		for(int index=0;index<num;index++)
		{
			List<Integer> pascal=new ArrayList<Integer>(index+1);			
			if(index==0)
				pascal.add(1);
			else
			{
				int count=0;
				while(count<=index)
                {
                    if(count==0 || count==index)
                        pascal.add(count,1);                    
                    else
                    {                       
                        pascal.add(count,output.get(index-1).get(count)+output.get(index-1).get(count-1));
                    }
                    count++;
                }
			}
			output.add(index,pascal);
		}
		return output;
	}
}
