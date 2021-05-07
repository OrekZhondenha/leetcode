package com.acyouzi.leetcode.greedy;

import java.util.*;

/**
 * 17/9/6 10:24
 *
 * @author sunxu
 */
public class SplitArray {
  // 超时
  public static boolean isPossible(int[] nums) {
    PriorityQueue<Set<Integer>> list = new PriorityQueue<>(new Comparator<Set<Integer>>() {
      @Override
      public int compare(Set<Integer> o1, Set<Integer> o2) {
        return o1.size() > o2.size() ? 1:-1;
      }
    });
    for (int num : nums){
      boolean flag = true;
      for (Set<Integer> set : list){
        if (set.contains(num-1) && !set.contains(num)) {
          set.add(num);
          flag = false;
          break;
        }
      }
      if (flag) {
        HashSet<Integer> set = new HashSet<>();
        set.add(num);
        list.add(set);
      }
    }
    for (Set<Integer> set : list) {
      if (set.size() < 3) return false;
    }
    return true;
  }

  public static void main(String[] args) {
    isPossible(new int[]{1,2,3,3,4,5});
  }
}
