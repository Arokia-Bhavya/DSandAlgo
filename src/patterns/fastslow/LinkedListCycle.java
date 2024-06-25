package patterns.fastslowpointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LinkedListCycle {
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
        // Create a loop
        fifth.next = third;
        Assertions.assertEquals(true,isCycleExist(head));
    }

    @Test
    public void example2()
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

        Assertions.assertEquals(false,isCycleExist(head));
    }

    private boolean isCycleExist(Node head) {
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null )
        {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
                return true;
        }
        return false;
    }

    private boolean isCycleExistBF(Node head) {
        List<Node> temp=new ArrayList<Node>();
        while(head!=null)
        {
            if(temp.contains(head))
                return true;
            temp.add(head);
            head=head.next;
        }
        return false;
    }
}
