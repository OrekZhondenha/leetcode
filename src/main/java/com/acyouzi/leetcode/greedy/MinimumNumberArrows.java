package com.acyouzi.leetcode.greedy;

import java.util.Arrays;

/**
 * 17/9/6 11:27
 *
 * @author sunxu
 */
public class MinimumNumberArrows {
  public int findMinArrowShots(int[][] points) {
    if (points.length == 0) return 0;
    Arrays.sort(points,(a,b) -> a[1] - b[1]);
    int arrowPos = points[0][1];
    int arrowCnt = 1;
    for (int i = 1; i < points.length; i++) {
      if (arrowPos >= points[i][0]) {
        continue;
      }
      arrowCnt++;
      arrowPos = points[i][1];
    }
    return arrowCnt;
  }
}
