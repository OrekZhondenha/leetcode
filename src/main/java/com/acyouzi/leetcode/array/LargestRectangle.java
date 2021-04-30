package com.acyouzi.leetcode.array;

import java.util.Stack;

/**
 * Created by SUN on 2017/8/28.
 */
public class LargestRectangle {
  public int largestRectangleArea(int[] heights) {
    Stack<Integer> stack = new Stack<>();
    int max = 0;
    for (int i = 0; i < heights.length; i++) {
      if (stack.isEmpty() || heights[i] >= heights[stack.peek()]){
        stack.push(i);
      }else{
        int tp = stack.pop();
        max = Math.max(max,heights[tp]*(stack.isEmpty()? i:i -1 - stack.peek()));
        i--;
      }
    }
    return max;
  }
    // public int largestRectangleArea(int[] heights) {
    //     int len = heights.length;
    //     Stack<Integer> s = new Stack<Integer>();
    //     int max = 0;
    //     for( int i = 0; i <= len; i++ ){
    //         int h = (i == len ? 0 : heights[i]);
    //         // 大于栈顶元素直接入栈
    //         if(s.isEmpty() || h >= heights[s.peek()]){
    //             s.push(i);
    //         }else{
    //             // 出栈的位置是当前能够合并的最大高度
    //             int tp = s.pop();
    //             // i- 1 -s.peek() 从当前指针位置的前一个位置开始到栈顶指示位置的距离
    //             max = Math.max(max,heights[tp]* (s.isEmpty()? i : i- 1 -s.peek() ));
    //             // i 位置的元素还没有处理，下一轮接着判断
    //             i--;
    //         }
    //     }
    //     return max;
    // }

  public int maxProfit(int[] prices) {
    int max = 0;
    int min = Integer.MAX_VALUE;
    for (int i : prices){
      min = Math.min(min,i);
      max = Math.max(max,i - min);
    }
    return max;
  }
}
