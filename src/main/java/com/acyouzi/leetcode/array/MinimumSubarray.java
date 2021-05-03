package com.acyouzi.leetcode.array;

/**
 * 17/9/2 09:12
 *
 * @author sunxu
 */
public class MinimumSubarray {
  public static int minSubArrayLen(int s, int[] nums) {
    int sum = 0;
    int start = 0;
    int res = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length; i++) {
      sum = sum + nums[i];
      if (sum >= s){
        res = Math.min(res,i-start+1);
        sum = sum - nums[start++] - nums[i--];
      }
    }
    return res;
  }

  public static void main(String[] args) {
    minSubArrayLen(7 , new int[]{2,3,1,2,4,3});
  }
}
