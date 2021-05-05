package com.acyouzi.leetcode.greedy;

import java.util.Arrays;

/**
 * Created by SUN on 2017/9/4.
 */
public class AssignCookies {
  public int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);
    int end = s.length-1;
    int res = 0;
    for (int i = g.length-1; i >= 0; i--) {
      if (end >= 0 && g[i] <= s[end]){
        end--;
        res++;
      }
    }
    return res;
  }
}
