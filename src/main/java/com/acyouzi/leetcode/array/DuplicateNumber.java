package com.acyouzi.leetcode.array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 17/8/27 10:08
 *
 * @author sunxu
 */
public class DuplicateNumber {
  // two point or binery search
  // 画图， 题目条件是一定会有重复，重复的地方构成了环
  public int findDuplicate(int[] nums) {
    int slow = nums[0];
    int fast = nums[nums[0]];
    while (slow != fast){
      slow = nums[slow];
      fast = nums[nums[fast]];
    }
    slow = 0;
    while (slow != fast){
      slow = nums[slow];
      fast = nums[fast];
    }
    return slow;
  }

  // https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
//  public List<Integer> findDuplicates(int[] nums) {
//
//  }
}
