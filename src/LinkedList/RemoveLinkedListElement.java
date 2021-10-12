package LinkedList;

import org.junit.Assert;
import org.junit.Test;

public class RemoveLinkedListElement {
	
	@Test
	public void example1()
	{
		ListNode input=new ListNode(1,new ListNode(2,new ListNode(6,new ListNode(3,new ListNode(4,new ListNode(5,new ListNode(6,null)))))));
		ListNode output=new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5,null)))));
		Assert.assertTrue(ListNode.isLinkedListSame(output,RemoveLinkedListElement(input,6)));
	}

	
	@Test
	public void example2()
	{
		ListNode input=null;
		ListNode output=null;
		Assert.assertTrue(ListNode.isLinkedListSame(output,RemoveLinkedListElement(input,1)));
	}
	
	@Test
	public void example3()
	{
		ListNode input=new ListNode(7,new ListNode(7,new ListNode(7,new ListNode(7,null))));
		ListNode output=null;
		Assert.assertTrue(ListNode.isLinkedListSame(output,RemoveLinkedListElement(input,7)));
	}
	
	

	private ListNode RemoveLinkedListElement(ListNode input,int val) {
		if(input == null)
			return input;
		ListNode cur=new ListNode(-1);
	    cur.next = input;
	    input = cur;
		while(cur!=null && cur.next!=null)
		{
			if(cur.next.val == val)
			{
				cur.next=cur.next.next;
			}else
				cur = cur.next;
		}
		return input.next;
	}

}
