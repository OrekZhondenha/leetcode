package com.acyouzi.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 17/9/2 15:06
 *
 * @author sunxu
 */
public class SetMismatch {
  // 注意这个题不能使用类似 link list 求循环起始节点的 two point 方法
  // 因为所给的条件中 val ~ 1 - n , 总共有 n 个元素，如果一个数等于 n， 再找他的下一个元素会发生越界
  public int[] findErrorNums(int[] nums) {
    Map< Integer, Integer > map = new HashMap();
    int dup = -1, missing = 1;
    for (int n: nums) {
      map.put(n, map.getOrDefault(n, 0) + 1);
    }
    for (int i = 1; i <= nums.length; i++) {
      if (map.containsKey(i)) {
        if (map.get(i) == 2)
          dup = i;
      } else
        missing = i;
    }
    return new int[]{dup, missing};
  }
//  public int[] findErrorNums(int[] nums) {
//    int slow = nums[0];
//    int fast = nums[nums[0]];
//    while (slow != fast){
//      slow = nums[slow];
//      fast = nums[nums[fast]];
//    }
//    slow = 0;
//    while (slow != fast){
//      slow = nums[slow];
//      fast = nums[fast];
//    }
//    int keysum = 0;
//    int valsum = 0;
//    for (int i = 0; i < nums.length; i++) {
//      keysum += i;
//      valsum += nums[i];
//    }
//    keysum += nums.length;
//    return new int[]{slow,slow+(keysum-valsum)};
//  }
}
