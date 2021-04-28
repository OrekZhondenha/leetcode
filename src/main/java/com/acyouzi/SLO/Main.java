package com.acyouzi.SLO;

import java.util.Scanner;

/**
 * 17/8/26 19:50
 *
 * @author sunxu
 */
public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int len = in.nextInt();
    int[] nums = new int[len];
    for (int i = 0; i < len; i++) {
      nums[i] = in.nextInt();
    }
    int[] dp =new int[len];
    for (int i = 1; i < len; i++) {
      for (int j = i-1; j >=0 ; j--) {
        if (nums[i] < nums[j]){
          dp[i] += 1;
        }
      }
    }
    for (int i = 0; i < len; i++) {
      if (i == len-1) System.out.print(dp[i]);
      else System.out.print(dp[i] + " ");
    }
  }
}
