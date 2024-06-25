package patterns.fastslowpointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class RearrangeLinkedList {
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
        Node firstNode=new Node(1);
        Node secondNode=new Node(2);
        Node thirdNode=new Node(3);
        Node fourthNode=new Node(4);
        firstNode.next=secondNode;
        secondNode.next=thirdNode;
        thirdNode.next=fourthNode;
        fourthNode.next=null;

        Node exceptedFirstNode=new Node(1);
        Node exceptedSecondNode=new Node(4);
        Node exceptedThirdNode=new Node(2);
        Node exceptedfourthNode =new Node(3);
        exceptedFirstNode.next=exceptedSecondNode;
        exceptedSecondNode.next=exceptedThirdNode;
        exceptedThirdNode.next= exceptedfourthNode;
        exceptedfourthNode.next=null;
        Node actualNode=rearrange(firstNode);
        isLinkedListSame(exceptedFirstNode, actualNode);
    }

    @Test
    public void example2()
    {
        Node firstNode=new Node(1);
        Node secondNode=new Node(2);
        Node thirdNode=new Node(3);
        Node fourthNode=new Node(4);
        Node fifthNode=new Node(5);
        firstNode.next=secondNode;
        secondNode.next=thirdNode;
        thirdNode.next=fourthNode;
        fourthNode.next=fifthNode;
        fifthNode.next=null;
        Node exceptedFirstNode=new Node(1);
        Node exceptedSecondNode=new Node(5);
        Node exceptedThirdNode=new Node(2);
        Node exceptedfourthNode =new Node(4);
        Node exceptedfifththNode =new Node(3);
        exceptedFirstNode.next=exceptedSecondNode;
        exceptedSecondNode.next=exceptedThirdNode;
        exceptedThirdNode.next= exceptedfourthNode;
        exceptedfourthNode.next=exceptedfifththNode;
        exceptedfifththNode.next=null;
        Node actualNode=rearrange(firstNode);
        isLinkedListSame(exceptedFirstNode, actualNode);
    }

    @Test
    public void example3()
    {
        Node firstNode=new Node(2);
        Node secondNode=new Node(4);
        Node thirdNode=new Node(6);
        Node fourthNode=new Node(8);
        Node fifthNode=new Node(10);
        Node sixthNode=new Node(12);
        firstNode.next=secondNode;
        secondNode.next=thirdNode;
        thirdNode.next=fourthNode;
        fourthNode.next=fifthNode;
        fifthNode.next=sixthNode;
        sixthNode.next=null;
        Node exceptedFirstNode=new Node(2);
        Node exceptedSecondNode=new Node(12);
        Node exceptedThirdNode=new Node(4);
        Node exceptedfourthNode =new Node(10);
        Node exceptedfifththNode =new Node(6);
        Node expectedsixthNode =new Node(8);
        exceptedFirstNode.next=exceptedSecondNode;
        exceptedSecondNode.next=exceptedThirdNode;
        exceptedThirdNode.next= exceptedfourthNode;
        exceptedfourthNode.next=exceptedfifththNode;
        exceptedfifththNode.next=expectedsixthNode;
        expectedsixthNode.next=null;
        Node actualNode=rearrange(firstNode);
        isLinkedListSame(exceptedFirstNode, actualNode);
    }

    private Node rearrange(Node head) {
        Node middle=findMiddle(head);
        Node firstHalf=head;
        Stack<Node> temp=new Stack<Node>();
        Node secondHalf=middle.next;
        while(secondHalf!=null)
        {
            temp.push(secondHalf);
            secondHalf=secondHalf.next;
        }
        middle.next=null;//this s necessary so that firstHalf s only till middle element
        Node dummy=new Node(0);
        Node output=dummy;
        while(firstHalf!=null || !temp.isEmpty())
        {
            if(firstHalf!=null)
            {
                output.next=firstHalf;
                firstHalf=firstHalf.next;
                output=output.next;
            }
            if(!temp.isEmpty())
            {
                output.next=temp.pop();
                output=output.next;
            }
        }
        return dummy.next;
    }

    private Node rearrangeO(Node head) {
        Node middle=findMiddle(head);
        Node secondHalf=reverseInplace(middle.next);//reverse from middle + 1 to end
        Node firstHalf=head;
        Node dummy=new Node(0);
        Node output=dummy;
        middle.next=null;//this s necessary so that firstHalf s only till middle element
        while(firstHalf!=null || secondHalf!=null)
        {
            if(firstHalf!=null)
            {
                output.next=firstHalf;
                firstHalf=firstHalf.next;
                output=output.next;
            }
            if(secondHalf!=null)
            {
                output.next=secondHalf;
                secondHalf=secondHalf.next;
                output=output.next;
            }
        }
        return dummy.next;
    }

    private Node reverseInplace(Node head) {
        Node prev=null;
        Node current=head;
        Node temp=null;
        while(current!=null)
        {
            temp=current.next;
            current.next=prev;
            prev=current;
            current=temp;
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

    private void isLinkedListSame(Node exceptedFirstNode, Node actualNode) {
        while(exceptedFirstNode !=null && actualNode !=null)
        {
            Assertions.assertEquals(exceptedFirstNode.data, actualNode.data);
            exceptedFirstNode = exceptedFirstNode.next;
            actualNode = actualNode.next;
        }
    }
}
