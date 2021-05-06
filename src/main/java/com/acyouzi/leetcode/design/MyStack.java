package com.acyouzi.leetcode.design;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 17/9/5 13:57
 *
 * @author sunxu
 */
public class MyStack {
  Queue<Integer> queue;
  public MyStack() {
    this.queue=new LinkedList<Integer>();
  }
  public void push(int x) {
    queue.add(x);
    for(int i=0;i<queue.size()-1;i++) {
      queue.add(queue.poll());
    }
  }
  public int pop() {
    return queue.poll();
  }
  public int top() {
    return queue.peek();
  }
  public boolean empty() {
    return queue.isEmpty();
  }
}
