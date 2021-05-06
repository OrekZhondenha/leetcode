package com.acyouzi.leetcode.design;

import java.util.Stack;

/**
 * 17/9/5 14:00
 *
 * @author sunxu
 */
public class MyQueue {
  // two stack
  Stack<Integer> input = new Stack<>();
  Stack<Integer> output = new Stack<>();

  public void push(int x) {
    input.push(x);
  }
  public int pop() {
    if (output.isEmpty()){
      while (!input.isEmpty()){
        output.push(input.pop());
      }
    }
    return output.pop();
  }
  public int peek() {
    if (output.isEmpty()){
      while (!input.isEmpty()){
        output.push(input.pop());
      }
    }
    return output.peek();
  }
  public boolean empty() {
    return input.isEmpty() && output.isEmpty();
  }
}
