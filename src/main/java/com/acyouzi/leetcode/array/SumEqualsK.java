package com.acyouzi.leetcode.array;

import java.util.HashMap;

/**
 * 17/9/4 13:13
 *
 * @author sunxu
 */
public class SumEqualsK {
//  https://leetcode.com/problems/subarray-sum-equals-k/description/
  public int subarraySum(int[] nums, int k) {
    int count = 0, sum = 0;
    HashMap<Integer, Integer> map = new HashMap<> ();
    map.put(0,1);
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      // 如果当前的 sum - k 如果等于某个 sum，
      // 则从上一个 sum 到这一个 sum 之间的连续位置和为 key
      if (map.containsKey(sum - k)){
        count += map.get(sum - k);
      }
      map.put(sum,map.getOrDefault(sum,0)+1);
    }
    return count;
  }
}
