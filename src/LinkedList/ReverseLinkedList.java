package LinkedList;

import org.junit.Test;

import junit.framework.Assert;

public class ReverseLinkedList {
	@Test
	public void example1()
	{
		ListNode input1=new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5,null)))));
		ListNode output=new ListNode(5,new ListNode(4,new ListNode(3,new ListNode(2,new ListNode(1,null)))));
		Assert.assertEquals(true, ListNode.isLinkedListSame(output,reverse(input1)));

	}
	
	@Test
	public void example2()
	{
		ListNode input1=new ListNode(1,new ListNode(2,null));
		ListNode output=new ListNode(2,new ListNode(1,null));
		Assert.assertEquals(true, ListNode.isLinkedListSame(output,reverse(input1)));	
	}
	
	
	
	private ListNode reverse(ListNode input1) {
		ListNode head=new ListNode(-1);
		ListNode current=head;
		while(input1!=null)
		{
			current.next=input1;
			input1=input1.next;
			current=current.next;
		}
		head=head.next;
		while(head!=null)
		{
			System.out.println(head.val);
			head=head.next;
		}
		return head.next;
	}

	

}
