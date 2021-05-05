package com.acyouzi.leetcode.array;

import javafx.collections.ArrayChangeListener;

import java.util.ArrayList;
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
  public List<Integer> findDuplicates(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      // if nums[i] == nums[nums[i] - 1] , 要么是重复存在重复，要么是已经在正确的位置上了
      if (nums[i] != nums[nums[i] - 1]){
        int tmp = nums[i];
        nums[i] = nums[tmp-1];
        nums[tmp-1] = tmp;
        i--;
      }
    }
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != i + 1) res.add(nums[i]);
    }
    return res;
  }
}
