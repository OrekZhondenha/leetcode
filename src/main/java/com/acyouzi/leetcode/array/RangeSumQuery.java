package com.acyouzi.leetcode.array;

import java.util.HashMap;

/**
 * 17/9/4 14:54
 *
 * @author sunxu
 */
// https://leetcode.com/problems/range-sum-query-immutable/description/
public class RangeSumQuery {
  int[] dp;
  public RangeSumQuery(int[] nums) {
    dp = new int[nums.length];
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      dp[i] = sum;
    }
  }

  public int sumRange(int i, int j) {
    return i == 0 ? dp[j] : dp[j] - dp[i-1];
  }
}
