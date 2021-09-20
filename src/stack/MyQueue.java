package stack;

import java.util.Stack;

public class MyQueue {
	Stack<Integer> num;
	int start;
	/** Initialize your data structure here. */
    public MyQueue() {
    	num=new Stack<Integer>();
    	start=0;
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
    	num.add(start++, x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
    	return num.remove(0);
    }
    
    /** Get the front element. */
    public int peek() {
    	return num.elementAt(0);
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
    	return num.isEmpty();  
    }
    public static void main(String[] args)
    {
    	MyQueue myQueue = new MyQueue();
    	myQueue.push(1); // queue is: [1]
    	myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
    	System.out.println(myQueue.peek()); // return 1
    	System.out.println(myQueue.pop()); // return 1, queue is [2]
    	myQueue.empty(); // return false
    }
}
