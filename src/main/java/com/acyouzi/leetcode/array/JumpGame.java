package com.acyouzi.leetcode.array;

/**
 * 17/8/27 10:32
 *
 * @author sunxu
 */
public class JumpGame {
  // 贪心算法
  public boolean canJump(int[] A) {
    int max = 0;
    // 每次都尽量跳最远
    for(int i=0;i<A.length;i++){
      // 什么情况下 i > max ?
      // 上一个 max 小于等于 A[i]+i, 并且 A[i] = 0
      // 这种情况 jump 不到 i
      if(i>max) {return false;}
      max = Math.max(A[i]+i,max);
    }
    return true;
  }
}
