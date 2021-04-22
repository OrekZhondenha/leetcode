package com.acyouzi.leetcode;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by sunxu on 17/6/11.
 */

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}

public class Solution {
  public boolean wordBreak(String s, List<String> wordDict) {
    boolean[] dp = new boolean[s.length()+1];
    dp[0] = true;

    for (int i = 1; i <= s.length(); i++) {
      for (int j = 0; j < i; j++) {
        if (dp[j] && wordDict.contains(s.substring(j,i))){
          dp[i] = true;
          break;
        }
      }
    }

    return dp[s.length()];
  }

  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<Integer>();
    if(root == null) return list;
    Stack<TreeNode> stack = new Stack<TreeNode>();
    stack.push(root);
    TreeNode tmp = null;
    while ( !stack.isEmpty() ){
      tmp = stack.pop();
      if ( tmp.right != null ) stack.push(tmp.right);
      if ( tmp.left != null ) stack.push(tmp.left);
      list.add(0,tmp.val);
    }
    return list;
  }

  public static void main(String[] args) {
    boolean[] dp = new boolean[1];
    System.out.println(dp[0]);
  }
}
