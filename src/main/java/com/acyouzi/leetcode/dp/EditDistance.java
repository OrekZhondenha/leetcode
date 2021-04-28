package com.acyouzi.leetcode.dp;

/**
 * 17/8/26 09:19
 *
 * @author sunxu
 */
public class EditDistance {
  public static int minDistance(String word1, String word2) {
    if (word1.length() == 0 || word2.length() ==0) return Math.max(word1.length(),word2.length());
    int min = Integer.MAX_VALUE;
    int dp[][] = new int[word1.length()+1][word2.length()+1];
    for (int i = 0; i <= word2.length(); i++) {
      dp[0][i] = i;
    }
    for (int i = 0; i <= word1.length(); i++) {
      dp[i][0] = i;
    }

    for (int i = 1; i <= word1.length(); i++) {
      for (int j = 1; j <= word2.length(); j++) {
        if (word1.charAt(i-1) == word2.charAt(j-1)){
          dp[i][j] = dp[i-1][j-1];
        }else{
          // 添加一个字符dp[i][j-1]，删除一个字符dp[i-1][j]，替换一个字符dp[i-1][j-1]
          dp[i][j] = Math.min(Math.min(dp[i][j-1],dp[i-1][j]),dp[i-1][j-1]) + 1;
        }
      }
    }
    return dp[word1.length()][word2.length()];
  }
  public static void main(String[] args) {
    minDistance("ab","bc");
  }
}
