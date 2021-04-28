package com.acyouzi.newcoder;

import java.util.Scanner;

/**
 * 17/8/26 15:50
 *
 * @author sunxu
 */
public class DD2 {
  private static int partition(int[] arr, int first, int last){
    int x = arr[last];
    int i = first - 1;
    for (int j = first; j < last; j++) {
      if (arr[j] > x ){
        i ++;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }
    int temp = arr[i+1];
    arr[i+1] = arr[last];
    arr[last] = temp;
    return i+1;
  }
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String line = in.nextLine();
    int k = in.nextInt() -1 ;
    String[] strs = line.split(" ");
    int[] nums = new int[strs.length];
    for (int i = 0; i < strs.length; i++) {
      nums[i] = Integer.parseInt(strs[i].trim());
    }
    int first = 0;
    int last = nums.length -1;
    int mid;
    while (true){
      mid = partition(nums,first,last);
      if (mid == k){
        System.out.println(nums[mid]);
        break;
      }else {
        if (mid > k){
          last = mid - 1;
        }else {
          first = mid + 1;
        }
      }
    }
  }
}
