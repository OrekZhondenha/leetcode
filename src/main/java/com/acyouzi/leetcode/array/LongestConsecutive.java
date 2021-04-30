package com.acyouzi.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by SUN on 2017/8/29.
 */
public class LongestConsecutive {
  public int longestConsecutive(int[] nums) {
    Set<Integer> set = new HashSet<>();
    int max = 0;
    for (int i : nums) set.add(i);
    for (int i : nums){
      int len = 0;
      int j = 1;
      while (set.contains(i-j)){
        set.remove(i-j);
        len ++;
        ++j;
      }
      j = 1;
      while (set.contains(i+j)){
        set.remove(i-j);
        ++j;
        len ++;
      }
      set.remove(i);
      max = Math.max(max,len+1);
    }
    return max;
  }
}
