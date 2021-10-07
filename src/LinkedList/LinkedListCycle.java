package LinkedList;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class LinkedListCycle {
	
	@Test
	public void example1()
	{
		ListNode node1=new ListNode(3);
		ListNode node2=new ListNode(2);
		ListNode node3=new ListNode(0);
		ListNode node4=new ListNode(4);
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node2;
		Assert.assertEquals(true,hasCycle(node1));
	}
	
	@Test
	public void example2()
	{
		ListNode node1=new ListNode(1);
		ListNode node2=new ListNode(1);
		node1.next=node2;
		node2.next=node1;
		Assert.assertEquals(true,hasCycle(node1));
	}
	
	
	@Test
	public void example3()
	{
		ListNode node1=new ListNode(1);
		Assert.assertEquals(false,hasCycle(node1));
	}
	
	@Test
	public void example4()
	{
		ListNode node1=new ListNode(1);
		ListNode node2=new ListNode(2);
		node1.next=node2;
		node2.next=null;
		Assert.assertEquals(false,hasCycle(node1));
	}
	/*Using flag TC O(n) SCo(n)*/
	private boolean hasCycleUsingFlag(ListNode node1) {
		
		while(node1!=null)
		{
			if(node1.isPresent)
				return true;
			else
				node1.isPresent=true;
			node1=node1.next;
		}
		return false;
	}

	/*BruteForce TC O(n) SC O(n)*/
	private boolean hasCycleBruteForce(ListNode node1)
	{
		Set<ListNode> nodes=new HashSet<ListNode>();
		while(node1!=null)
		{
			if(nodes.contains(node1))
				return true;
			else
				nodes.add(node1);
			node1=node1.next;
		}
		return false;
	}
	/*slow and fast pointers - Flyods Cycle Detection
	 * SC O(1) TC k*O(n) where k is number of cycles*/
	private boolean hasCycle(ListNode node1) {
		ListNode left1=node1;
		ListNode left2=node1;
		while(left1!=null && left2!=null && left2.next!=null)
		{
			
			left1 = left1.next;
			left2 = left2.next.next;
			if(left1 == left2)
				return true;
		}
		return false;
	}

}
