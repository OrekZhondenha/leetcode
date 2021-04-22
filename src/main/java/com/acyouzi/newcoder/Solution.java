package com.acyouzi.newcoder;

import java.util.Scanner;

/**
 * 17/8/22 20:01
 *
 * @author sunxu
 */
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int len = in.nextInt();
    int[] arr = new int[len];
    for (int i = 0; i < len; i++) {
      arr[i] = in.nextInt();
    }
    System.out.println(getMax(arr,1));
  }

  public static int getMax(int[] arr, int len){
    int max = Integer.MIN_VALUE;
    for (int start = len - 1; start < arr.length; start++) {
      int min = Integer.MAX_VALUE;
      int sum = 0;
      for (int i = 0; i < arr.length - start; i++) {
        sum += arr[start+i];
        min = Math.min(min,arr[start+i]);
        max = Math.max(max,sum*min);
      }
    }
    return max;
  }
}
