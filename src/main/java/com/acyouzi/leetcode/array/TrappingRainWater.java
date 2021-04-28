package com.acyouzi.leetcode.array;

/**
 * 17/8/27 09:43
 *
 * @author sunxu
 */
public class TrappingRainWater {
  public static int trap(int[] height) {
    int[] target = new int[height.length];
    int max = 0;
    for (int i = 0; i < height.length; i++) {
      if (height[i] <= max){
        target[i] = max;
      }else {
        max = height[i];
        target[i] = max;
      }
    }
    max = 0;
    for (int i = height.length-1; i >= 0 ; i--) {
      if (height[i] <= max){
        target[i] = Math.min(target[i],max);
      }else {
        max = height[i];
        target[i] = Math.min(target[i],max);
      }
    }
    int res = 0;
    for (int i = 0; i < height.length; i++) {
      res += (target[i] - height[i]);
    }
    return res;
  }

  public static void main(String[] args) {
    trap(new int[]{2,0,2});
  }
}
