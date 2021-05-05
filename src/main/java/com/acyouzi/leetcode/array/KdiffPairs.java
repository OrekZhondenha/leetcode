package com.acyouzi.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 17/9/4 15:08
 *
 * @author sunxu
 */
// https://leetcode.com/problems/k-diff-pairs-in-an-array/description/
public class KdiffPairs {
  public int findPairs(int[] nums, int k) {
    HashMap<Integer,Integer> map = new HashMap<>();
    for (int num : nums) map.put(num,map.getOrDefault(num,0)+1);
    int res = 0;
    for (Map.Entry<Integer,Integer> entry : map.entrySet()){
      if (k == 0 && entry.getValue() > 1) res ++;
      if (k > 0 && map.containsKey(entry.getKey() + k)) res ++;
    }
    return res;
  }
}
