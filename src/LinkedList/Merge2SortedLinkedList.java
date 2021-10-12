package LinkedList;

import org.junit.Test;

import junit.framework.Assert;

public class Merge2SortedLinkedList {

	@Test
	public void example1()
	{
		ListNode input1=new ListNode(1,new ListNode(2,new ListNode(4,null)));
		ListNode input2=new ListNode(1,new ListNode(3,new ListNode(4,null)));
		ListNode output=new ListNode(1,new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(4,null))))));
		Assert.assertEquals(true, ListNode.isLinkedListSame(output,merge(input1,input2)));;
	}

	@Test
	public void example2()
	{
		ListNode input1=null;
		ListNode input2=new ListNode(0,null);
		ListNode output=new ListNode(0,null);
		Assert.assertEquals(true, ListNode.isLinkedListSame(output,merge(input1,input2)));
	}
	
	@Test
	public void example3()
	{
		ListNode input1=null;
		ListNode input2=null;
		ListNode output=null;
		Assert.assertEquals(true, ListNode.isLinkedListSame(output,merge(input1,input2)));
	}
	private ListNode merge(ListNode input1, ListNode input2) {
		 ListNode head=new ListNode(-1);
	    ListNode output=head;
        while(input1!=null && input2!=null)
        {
        	if(input1.val<=input2.val)
        	{
        		output.next=input1;
        		input1=input1.next;
        	}else
        	{
        		output.next=input2;
        		input2=input2.next;
        	}
        	output=output.next;
        }
        if(input1!=null)
        	output=input1;
        if(input2!=null)
        	output=input2;
		return head.next;
	}
}
