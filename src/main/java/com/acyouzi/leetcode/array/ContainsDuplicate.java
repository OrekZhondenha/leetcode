package com.acyouzi.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 17/9/2 09:32
 *
 * @author sunxu
 */
public class ContainsDuplicate {
  public boolean containsDuplicate(int[] nums) {
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 1; ++i) {
      if (nums[i] == nums[i + 1]) return true;
    }
    return false;
  }
  // two point + set
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    int start = 0;
    HashSet<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      if (set.size() > k){
        set.remove(nums[start++]);
      }
      if (set.contains(nums[i])) return true;
      set.add(nums[i]);
    }
    return false;
  }
}
