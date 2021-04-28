package com.acyouzi.leetcode.array;

/**
 * 17/8/27 10:51
 *
 * @author sunxu
 */
public class MaximumSubarray {
  // 如果小于 0 则从新开始
  public int maxSubArray(int[] nums) {
    int len = nums.length;
    int max = Integer.MIN_VALUE;
    int sum = 0;
    for( int i = 0; i < len ; i++ ){
      sum = sum + nums[i];
      max = Math.max(max, sum);
      if(sum < 0){
        sum = 0;
      }
    }
    return max;
  }
}
