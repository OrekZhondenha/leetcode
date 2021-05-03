package com.acyouzi.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 17/9/2 21:39
 *
 * @author sunxu
 */
public class NumbersDisappeared {
  public List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> list = new ArrayList<>();
    int[] flag = new int[nums.length+1];
    for (int i = 0; i < nums.length; i++) {
      flag[nums[i]] = nums[i];
    }
    for (int i = 0; i < flag.length; i++) {
      if (flag[i] != i) list.add(i);
    }
    return list;
  }
}
