package patterns.fastslowpointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;

public class StartLinkedList {
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
        Node head=new Node(1);
        Node second=new Node(2);
        Node third=new Node(3);
        Node fourth=new Node(4);
        Node fifth=new Node(5);

        head.next=second;
        second.next=third;
        third.next=fourth;
        fourth.next=fifth;
        fifth.next=third;
        Assertions.assertEquals(third,findStart(head));
    }
    @Test
    public void example2()
    {
        Node head=new Node(1);
        Node second=new Node(2);
        Node third=new Node(3);
        Node fourth=new Node(4);
        Node fifth=new Node(5);

        head.next=second;
        second.next=third;
        third.next=fourth;
        fourth.next=fifth;
        Assertions.assertEquals(null,findStart(head));
    }

    private Node findStart(Node head) {
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
            {
                slow=head;
                while(slow!=fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    private Node findStartBF(Node head) {
        List<Node> temp= new ArrayList<Node>();
        while(head!=null)
        {
            if(temp.contains(head))
                return head;
            else
                temp.add(head);
            head=head.next;
        }
        return null;
    }
}
