package patterns.fastslowpointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PallindromeLinkedList {
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
        Node fourth=new Node(2);
        Node fifth=new Node(1);

        head.next=second;
        second.next=third;
        third.next=fourth;
        fourth.next=fifth;
        fifth.next=null;
        Assertions.assertEquals(true,isPallindromeLinkedList(head));
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
        fifth.next=null;
        Assertions.assertEquals(false,isPallindromeLinkedList(head));
    }

    @Test
    public void example3()
    {
        Node head=new Node(1);
        Node second=new Node(2);
        Node third=new Node(3);
        Node fourth=new Node(3);
        Node fifth=new Node(2);
        Node sixth=new Node(1);
        head.next=second;
        second.next=third;
        third.next=fourth;
        fourth.next=fifth;
        fifth.next=sixth;
        sixth.next=null;
        Assertions.assertEquals(true,isPallindromeLinkedList(head));
    }

    private boolean isPallindromeLinkedList(Node head) {
        Node middle=findMiddle(head);
        middle=reverseInPlace(middle);
        while(head!=null && middle!=null)
        {
            if(head.data!=middle.data)
                return false;
            head=head.next;
            middle=middle.next;
        }
        return true;
    }

    private Node reverseInPlace(Node head) {
        Node prev=null;
        Node current=head;
        Node temp=null;
        while(current!=null)
        {
            temp = current.next;
            current.next = prev ;
            prev = current;
            current = temp;
        }
        return prev;
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

    private boolean isPallindromeLinkedListStack(Node head) {
        Stack<Integer> data=new Stack<Integer>();
        Node current=head;
        while(current!=null)
        {
            data.push(current.data);
            current=current.next;
        }
        while(head!=null)
        {
            if(data.pop()!=head.data)
                return false;
            head=head.next;
        }
        return data.isEmpty();
    }

    private boolean isPallindromeLinkedListBF(Node head) {
        List<Integer> numberList=new ArrayList<Integer>();
        while(head!=null)
        {
            numberList.add(head.data);
            head=head.next;
        }
        int left=0;
        int right= numberList.size() - 1;
        while(left<right)
        {
            if(numberList.get(left)!= numberList.get(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
