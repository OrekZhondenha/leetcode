package com.acyouzi.leetcode.array;

/**
 * 17/8/27 09:35
 *
 * @author sunxu
 */
public class MissingPositive {
  public static int firstMissingPositive(int[] nums) {
    int len = nums.length;
    for (int i = 0; i < len; i++) {
      if (nums[i] < len && nums[i] > 0 && nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]){
        int tmp = nums[i];
        nums[i] = nums[tmp-1];
        nums[tmp-1] = tmp;
        i --;
      }
    }
    for (int i = 0; i < len; i++) {
      if (nums[i] != i+1) return i+1;
    }
    return len+1;
  }

  public static void main(String[] args) {
    firstMissingPositive(new int[]{-1,4,2,1,9,10});
  }
}
