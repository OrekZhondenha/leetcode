package com.acyouzi.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 17/9/2 09:43
 *
 * @author sunxu
 */
public class MajorityElement {
  public static List<Integer> majorityElement(int[] nums) {
    int count1 = 0;
    int count2 = 0;
    int num1 = 0;
    int num2 = 0;
    for (int i = 0; i < nums.length; i++) {
      if (num1 == nums[i]){
        count1 += 1;
      }else if (num2 == nums[i]){
        count2 += 1;
      }else if (count1 == 0){
        count1 = 1;
        num1 = nums[i];
      }else if (count2 == 0){
        count2 = 1;
        num2 = nums[i];
      }else {
        count1--;
        count2--;
      }
    }
    count1 = 0;
    count2 = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == num1) count1 ++;
      if (nums[i] == num2) count2 ++;
    }
    ArrayList<Integer> list = new ArrayList<>();
    if (count1 > nums.length/3) list.add(num1);
    if (count2 > nums.length/3 && num2 != num1) list.add(num2);
    return list;
  }

  public static void main(String[] args) {
    majorityElement(new int[]{1,2,2,3,2,1,1,3});
  }
}
