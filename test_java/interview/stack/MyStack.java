package stack;

import java.io.Serializable;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 用队列模拟栈
 *
 * @author hupan
 * @date 2018/09/28
 */
public class MyStack implements Serializable {
    private static final long serialVersionUID = 3076310910031101701L;

    /** Initialize your data structure here. */

    Deque<Integer> queue = new LinkedList<>();

    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.pollLast();
    }

    /** Get the top element. */
    public int top() {
        return queue.getLast();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(19);
        myStack.push(7);
        int t = myStack.top();
        int a = myStack.pop();
        int b = myStack.pop();
        boolean f = myStack.empty();

        System.out.println(t);
        System.out.println(a);
        System.out.println(b);
        System.out.println(f);
    }
}
