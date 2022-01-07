package string;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sequence {
	
public static void main(String[] args)
{
	List<Character> output = new Sequence().printRandomSequence();
	System.out.println(output);
}
/*O(n)*/
private List<Character> printRandomSequence() {
	int total_size=26;
	List<Character> output=new ArrayList<Character>(total_size);
	Random ran = new Random();
	int index=0;
	while(index<total_size)
	{
		int position=ran.nextInt(total_size);
		char value=(char) (position+97);
		if(!output.contains(value))
			output.add(index++,value);
	}
	return output;
}

}
