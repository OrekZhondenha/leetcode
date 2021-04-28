package com.acyouzi.leetcode.array;

import java.util.Arrays;

/**
 * 17/8/26 21:14
 *
 * @author sunxu
 */
public class NextPermutation {
  // 思路：
  // 从后到前，先找到一个比他的后一个点小的点，
  // 在从后向前找到第一个比上一步找到的点大的点(也就是大于那个点的最小点)
  // 因为可以认为第一步的点往后的点都是递减的，所以第二步只需要倒序遍历就可了
  public static void nextPermutation(int[] nums) {
    int len = nums.length;
    int start = len-2;
    while (start >= 0){
      if (nums[start] < nums[start+1]) break;
      start --;
    }
    if (start < 0) Arrays.sort(nums);
    else {
      int end = len -1;
      while (true){
        if (nums[end] > nums[start]) break;
        end --;
      }
      int tmp = nums[start];
      nums[start] = nums[end];
      nums[end] = tmp;
      Arrays.sort(nums,start+1,len);
    }
  }

  public static void main(String[] args) {
    nextPermutation(new int[]{2,3,1});
  }
}
