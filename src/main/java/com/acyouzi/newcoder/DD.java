package com.acyouzi.newcoder;

import java.util.Scanner;

/**
 * 17/8/26 14:31
 *
 * @author sunxu
 */
public class DD {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String line = in.nextLine();
    String[] strs = line.split(" ");
    int[] nums = new int[strs.length];
    for (int i = 0; i < strs.length; i++) {
      nums[i] = Integer.parseInt(strs[i].trim());
    }
    int max = Integer.MIN_VALUE;
    int[] dp = new int[nums.length+1];
    for (int i = 1; i <= nums.length; i++) {
      dp[i] = Math.max(dp[i-1]+nums[i-1],nums[i-1]);
      max = Math.max(dp[i],max);
    }
    System.out.println(max);
  }
}
