package com.acyouzi.leetcode.array;

/**
 * 17/9/2 09:06
 *
 * @author sunxu
 */
public class MaximumProduct {
  public static int maxProduct(int[] A) {
    if (A == null || A.length == 0) {
      return 0;
    }
    int max = A[0], min = A[0], result = A[0];
    for (int i = 1; i < A.length; i++) {
      int temp = max;
      max = Math.max(Math.max(max * A[i], min * A[i]), A[i]);
      min = Math.min(Math.min(temp * A[i], min * A[i]), A[i]);
      if (max > result) {
        result = max;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    maxProduct(new int[]{2,3,-2,4,5});
  }
}
