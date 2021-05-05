package com.acyouzi.leetcode.string;

/**
 * Created by SUN on 2017/9/4.
 */
public class Subsequence {
  public boolean isSubsequence(String s, String t) {
    int index = 0;
    for (int i = 0; i < t.length(); i++) {
      if (index < s.length() && t.charAt(i) == s.charAt(index)){
        index++;
      }
    }
    if (index == s.length()) return true;
    return false;
  }
}
