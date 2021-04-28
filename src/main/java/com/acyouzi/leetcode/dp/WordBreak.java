package com.acyouzi.leetcode.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 17/8/26 09:43
 *
 * @author sunxu
 */
public class WordBreak {
  public static boolean wordBreak(String s, List<String> wordDict) {
    Set<String> set = new HashSet<>();
    for (String str : wordDict) set.add(str);
    boolean[] dp = new boolean[s.length()+1];
    dp[0] = true;
    for (int i = 1; i <= s.length(); i++) {
      for (int j = i-1; j >=0 ; j--) {
        if (dp[j] && set.contains( s.substring(j,i) )){
          dp[i] = true;
          break;
        }
      }
    }
    return dp[s.length()];
  }

  public static void main(String[] args) {
    List<String> wordDict = new ArrayList<>();
    wordDict.add("ab");
    wordDict.add("ac");
    wordBreak("abac",wordDict);
  }
}
