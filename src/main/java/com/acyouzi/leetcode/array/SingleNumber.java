package com.acyouzi.leetcode.array;

/**
 * 17/9/2 13:36
 *
 * @author sunxu
 */
public class SingleNumber {
  public int singleNumber(int[] nums) {
    int res = 0;
    for (int i : nums) res ^= i;
    return res;
  }
  public int[] singleNumber2(int[] nums) {
    int diff = 0;
    for (int num : nums) {
      diff ^= num;
    }
    diff &= -diff;
    int[] rets = {0, 0};
    for (int num : nums)
    {
      if ((num & diff) == 0) // the bit is not set
      {
        rets[0] ^= num;
      }
      else // the bit is set
      {
        rets[1] ^= num;
      }
    }
    return rets;
  }
}
