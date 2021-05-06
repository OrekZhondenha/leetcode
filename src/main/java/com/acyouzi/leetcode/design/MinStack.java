package com.acyouzi.leetcode.design;

import java.util.Stack;

/**
 * 17/9/5 11:37
 *
 * @author sunxu
 */
public class MinStack {
  int min = Integer.MAX_VALUE;
  Stack<Integer> stack = new Stack<Integer>();
  public void push(int x) {
    if(x <= min){
      stack.push(min);
      min=x;
    }
    stack.push(x);
  }
  public void pop() {
    if(stack.pop() == min) min=stack.pop();
  }
  public int top() {
    return stack.peek();
  }
  public int getMin() {
    return min;
  }
}
