package LinkedList;

public class ListNode {
	int val;
	ListNode next;
	boolean isPresent;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }	
	
	static boolean isLinkedListSame(ListNode output, ListNode input) {
		while(input!=null && output!=null && input.val==output.val)
		{
			input = input.next;
			output = output.next;
		}
		return input==null && output==null;
	}       
}
