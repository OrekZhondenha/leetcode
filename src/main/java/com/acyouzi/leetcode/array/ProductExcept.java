package com.acyouzi.leetcode.array;

/**
 * 17/9/2 10:56
 *
 * @author sunxu
 */
public class ProductExcept {
  public static int[] productExceptSelf(int[] nums) {
    int[] flag = new int[nums.length+1];
    flag[nums.length] = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      flag[i] = flag[i+1] * nums[i];
    }
    int pro = 1;
    int[] res = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      res[i] = pro * flag[i+1];
      pro = pro * nums[i];
    }
    return res;
  }

  public static void main(String[] args) {
    productExceptSelf(new int[]{1,1});
  }
}

