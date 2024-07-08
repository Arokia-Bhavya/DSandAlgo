import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import patterns.fastslowpointers.RearrangeLinkedList;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class OddEvenList {
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
        Node fifthNode=new Node(5);
        firstNode.next=secondNode;
        secondNode.next=thirdNode;
        thirdNode.next=fourthNode;
        fourthNode.next=fifthNode;
        fifthNode.next=null;
        Node exceptedFirstNode=new Node(1);
        Node exceptedSecondNode=new Node(3);
        Node exceptedThirdNode=new Node(5);
        Node exceptedfourthNode =new Node(2);
        Node exceptedfifththNode =new Node(4);
        exceptedFirstNode.next=exceptedSecondNode;
        exceptedSecondNode.next=exceptedThirdNode;
        exceptedThirdNode.next= exceptedfourthNode;
        exceptedfourthNode.next=exceptedfifththNode;
        exceptedfifththNode.next=null;
        Node actualNode=oddEven(firstNode);
        isLinkedListSame(exceptedFirstNode, actualNode);
    }

    private Node oddEven(Node head) {
        Node oddHead=head;
        Node evenHead=head.next;
        Node oddCurrent=oddHead;
        Node evenCurrent=evenHead;
        while(oddCurrent!=null)
        {
            Node tempEven = oddCurrent.next;
            if(oddCurrent.next!=null)
                oddCurrent.next=oddCurrent.next.next;
            evenCurrent.next=tempEven;
            evenCurrent = evenCurrent.next;
            if(oddCurrent.next==null) break;
            oddCurrent=oddCurrent.next;
        }
        oddCurrent.next=evenHead;
        return oddHead;
    }

    private Node oddEvenBF(Node head) {
        Node odd = head;
        LinkedList<Node> temp=new LinkedList<Node>();
        Node dummy = new Node(0);
        Node output = dummy;
        while(odd!=null )
        {
            output.next=odd;
            output=output.next;

            if(odd.next!=null) {
                temp.add(odd.next);
                odd = odd.next.next;
            }
            else
                odd=odd.next;
        }
        while(!temp.isEmpty())
        {
            output.next=temp.getFirst();
            temp.removeFirst();
            output=output.next;
        }
        return dummy.next;
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
