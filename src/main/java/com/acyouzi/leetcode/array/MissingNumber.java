package com.acyouzi.leetcode.array;

/**
 * 17/9/2 13:24
 *
 * @author sunxu
 */
public class MissingNumber {
  public static int missingNumber(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] < nums.length && nums[i] != i){
        int tmp = nums[i];
        nums[i] = nums[tmp];
        nums[tmp] = tmp;
        i--;
      }
    }
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != i){
        return i;
      }
    }
    return nums.length;
  }

  public static void main(String[] args) {
    missingNumber(new int[]{3,2,0});
  }
}
