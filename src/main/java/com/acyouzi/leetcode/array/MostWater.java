package com.acyouzi.leetcode.array;

/**
 * 17/8/26 10:35
 *
 * @author sunxu
 */
public class MostWater {
  // two point 问题，不仅能够两个指针从 0 开始，还能两个指针从来头开始
  public int maxArea(int[] height) {
    int start = 0;
    int end = height.length-1;
    int max = Integer.MIN_VALUE;
    while (start < end){
      max = Math.max(max,(end-start)*Math.max(height[start],height[end]));
      if (height[start] < height[end]){
        start ++;
      }else {
        end --;
      }
    }
    return max;
  }
}
