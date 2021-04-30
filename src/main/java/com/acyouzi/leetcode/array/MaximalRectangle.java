package com.acyouzi.leetcode.array;

import java.util.Stack;

/**
 * Created by SUN on 2017/8/29.
 */
public class MaximalRectangle {
  public int maximalRectangle(char[][] matrix) {
    if (matrix==null||matrix.length==0||matrix[0].length==0)
      return 0;

    int rlen = matrix.length;
    int clen = matrix[0].length;
    // 想象 height 记录的是一个高度数组，从 i 行到第 0 行的高度
    // 如果在第 i 行某一列出现 0 则, height[x] = 0;
    // 然后剩下的问题是解决一个 直方图的最大面积的问题
    // https://leetcode.com/problems/largest-rectangle-in-histogram/description/
    int[] height = new int[clen +1];
    int max = 0;

    for (int i = 0; i < rlen; i++) {
      Stack<Integer> stack = new Stack<>();
      for (int j = 0; j <= clen; j++) {
        // 从上往下扫描，但是从下往上统计高度
        // 所以第一行只能是 0 / 1
        if(j < clen){
          if (matrix[i][j] == '1') height[j] += 1;
          else height[j] = 0;
        }
        if (stack.isEmpty() || height[stack.peek()] <= height[j]){
          stack.push(j);
        }else {
          // 当出现 height[i] 小于栈顶情况时，合并，直到 height[i] > 栈顶，或者栈为空
          while (!stack.isEmpty() && height[stack.peek()] > height[j]){
            int pos = stack.pop();
            int area = height[pos] * (stack.isEmpty()? j : j - 1 - stack.peek());
            max = Math.max(max,area);
          }
          stack.push(j);
        }
      }
    }
    return max;
  }
}
