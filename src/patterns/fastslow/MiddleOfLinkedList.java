package patterns.fastslowpointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MiddleOfLinkedList {
    class Node {
        // Data stored in the node
        public int data;
        // Pointer to the next node in the list
        public Node next;

        // Constructor with both data
        // and next node as parameters
        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        // Constructor with only data as
        // a parameter, sets next to null
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    @Test
    public void example1()
    {
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = null;
        Assertions.assertEquals(third,findMiddle(head));
    }

    @Test
    public void example2()
    {
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);
        Node sixth = new Node(6);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = null;
        Assertions.assertEquals(fourth,findMiddle(head));
    }

    @Test
    public void example3()
    {
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);
        Node sixth = new Node(6);
        Node seventh = new Node(6);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;
        seventh.next = null;
        Assertions.assertEquals(fourth,findMiddle(head));
    }

    private Node findMiddle(Node head) {
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
       return slow;
    }

    private Node findMiddleBF(Node head) {
        List<Node> temp=new ArrayList<Node>();
        while(head!=null)
        {
            temp.add(head);
            head=head.next;
        }
       return temp.get(temp.size()/2);
    }
}
