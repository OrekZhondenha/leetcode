package com.acyouzi.meituan;

import java.util.Scanner;
/**
 * 17/8/31 20:10
 *
 * @author sunxu
 */
public class Mainw {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int len = in.nextInt();
    int[] arr = new int[len];
    int sum = 0;
    for (int i = 0; i < len; i++) {
      arr[i] = in.nextInt();
      sum = sum + arr[i];
    }
    int key = in.nextInt();
    if (key == 0 && sum == 0) System.out.println(len);
    int res = helper(arr,sum,key,0,len-1);
    System.out.println(res);
  }

  public static int helper(int[] arr, int sum, int key, int start, int end){
    if (start > end || sum < key) return 0;
    if (sum % key == 0){
      return end - start + 1;
    }
    return Math.max(helper(arr,sum-arr[end],key,start,end-1),helper(arr,sum-arr[start],key,start+1,end));
  }
}
