package stack;

import java.util.Stack;

public class MyQueue {
	Stack<Integer> num;
	
	
	/** Initialize your data structure here. */
    public MyQueue() {
    	num=new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {    	
    	if(num.size()==0)
    		num.push(x);
    	else
    	{
    		Stack<Integer> temp=new Stack<Integer>();
    		while(!num.empty())
    			temp.push(num.pop());
    		num.push(x);
    		while(!temp.empty())
    			num.push(temp.pop());
    	}
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
    	return num.pop();
    }
    
    /** Get the front element. */
    public int peek() {
    	return num.peek();
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
    	myQueue.push(3);
    	myQueue.push(4);
    	System.out.println(myQueue.pop()); // return 1
    	myQueue.push(5);
    	System.out.println(myQueue.pop()); // return 1, queue is [2]
    	System.out.println(myQueue.pop()); // return false
    	System.out.println(myQueue.pop());
    	System.out.println(myQueue.pop());
    }
}
