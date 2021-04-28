package com.acyouzi.leetcode.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 17/8/26 10:01
 *
 * @author sunxu
 */
public class ConcatenatedWords {
  public List<String> findAllConcatenatedWordsInADict(String[] words) {
    List<String> res = new ArrayList<>();
    HashSet<String> set = new HashSet<>();
    for (String str : words) set.add(str);
    for (String str : words){
      boolean[] dp = new boolean[str.length()+1];
      dp[0] = true;
      for (int i = 1; i <= str.length(); i++) {
        for (int j = i-1; j >= 0; j--) {
          if (dp[j] && set.contains(str.substring(j,i)) && i - j != str.length()){
            dp[i] = true;
            break;
          }
        }
        if (dp[str.length()]) res.add(str);
      }
    }
    return res;
  }
}
