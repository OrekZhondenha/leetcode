package com.acyouzi.leetcode.array;

import java.util.Arrays;

/**
 * 17/9/4 12:57
 *
 * @author sunxu
 */
public class TaskScheduler {
//  https://leetcode.com/problems/task-scheduler/description/
  public int leastInterval(char[] tasks, int n) {
    int[] map = new int[26];
    for (char i : tasks){
      map[i - 'A'] += 1;
    }
    Arrays.sort(map);
    int max_val = map[25] - 1, idle_slots = max_val * n;
    for (int i = 24; i >= 0 && map[i] > 0; i--) {
      idle_slots -= Math.min(map[i], max_val);
    }
    return idle_slots > 0 ? idle_slots + tasks.length : tasks.length;
  }
}
