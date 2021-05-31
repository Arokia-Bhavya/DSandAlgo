package datastructures;


public class LinkedList {
	Node head, last;
	
	public static void main(String[] args) {

        LinkedList list = new LinkedList();

        System.out.println("Inserting Element: "+10);
        list.addFirst(10);
        System.out.println("Inserting Element: "+20);
        list.addFirst(20);
        System.out.println("Inserting Element: "+30);
        list.addFirst(30);
        System.out.println("Inserting Element: "+40);
        list.addFirst(40);
        
        System.out.println("Inserting Element at the end: "+50);
        list.addLast(50);
        
        System.out.println("The LinkedList Elements Are:");
        list.print();
        list.delete(10);
        System.out.println("The LinkedList Elements after deletion Are:");
        list.print();
        Node node=list.search(50);
        System.out.println("Found data "+node.data);
        
	}

	private Node search(int data)
	{
		Node temp=head;
		
		while(temp!=null && temp.data!=data)
		{
			temp = temp.next;
		}
		
		return temp;
	}
	private void delete(int data) {
		if(head.data == data)
		{
			head = head.next;
		}else
		{
			Node temp=head;
			
			while(temp!=null && temp.next!=null && temp.next.data!=data)
			{
				temp = temp.next;
			}
			temp.next=temp.next.next;
		}
	}

	private void print() {
		 Node temp = head;

	        while(temp != null)
	        {
	            System.out.println(temp.data);
	            temp = temp.next;
	        }
		
	}

	private void addLast(int val) {
		Node node =new Node();
		node.data=val;
		node.next=null;
		
		
		if(head == null)
		{
			head = node;
		}else
		{
			Node temp = head;
			
			while(temp.next !=null )
			{
				temp = temp.next;
			}
			temp.next=node;
		
			last=node;
		}
	}

	private void addFirst(int val) {
	Node node=new Node();	
	node.data = val;
	node.next= head;
	head =node;
	}

}
