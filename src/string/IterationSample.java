package string;

import java.util.ArrayList;
import java.util.HashMap;

public class IterationSample {
	
	public static void main(String args[])
	{
		ArrayList<HashMap<String,String>> dataList1=new ArrayList<HashMap<String,String>>();
		ArrayList<HashMap<String,String>> dataList2=new ArrayList<HashMap<String,String>>();
		ArrayList<HashMap<String,String>> dataList3=new ArrayList<HashMap<String,String>>();
		
		HashMap<String,String> dataMap1=new HashMap<String,String>();
		HashMap<String,String> dataMap2=new HashMap<String,String>();
		HashMap<String,String> dataMap3=new HashMap<String,String>();
		
		dataMap1.put("Account Number","136136745"); 
		dataMap1.put("Unique Id", "675287457");
		dataMap1.put("Hold Plastic indicator", "Y");
		
		dataMap2.put("Account Number","136136745658756"); 
		dataMap2.put("Unique Id", "675287457");
		dataMap2.put("Hold Plastic indicator", "Y");
		
		dataList1.add(dataMap1);
		dataList2.add(dataMap2);		
		dataList2.add(dataMap1);
		
		System.out.println(dataList2.stream().filter(hashmap -> hashmap.containsKey("Unique Id")).count());
		
	}

}
