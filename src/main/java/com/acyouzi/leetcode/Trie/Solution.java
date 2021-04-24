package com.acyouzi.leetcode.Trie;

import java.util.List;

/**
 * Created by SUN on 2017/8/24.
 */

public class Solution {
  public static void main(String[] args) {

  }
  class TrieNode {
    public char val;
    public boolean isWord;
    public TrieNode[] children = new TrieNode[26];
    public TrieNode() {}
    TrieNode(char c){
      TrieNode node = new TrieNode();
      node.val = c;
    }
  }
  public String replaceWords(List<String> dict, String sentence) {
    TrieNode root = new TrieNode();
    for (String str : dict){
      TrieNode tmp = root;
      for (char i : str.toCharArray()){
        if (tmp.children[i - 'a'] == null){
          tmp.children[i - 'a'] = new TrieNode(i);
        }
        tmp = tmp.children[i - 'a'];
      }
      tmp.isWord = true;
    }
    StringBuilder builder = new StringBuilder();
    for (String str : sentence.split(" ")){
      TrieNode tmp = root;
      int i = 0;
      while (!tmp.isWord && i < str.length()){
        if (tmp.children[str.charAt(i)-'a'] == null){
          break;
        }
        tmp = tmp.children[str.charAt(i++)-'a'];
      }
      if (tmp.isWord) builder.append(str.substring(0,i+1));
      else builder.append(str);
      builder.append(" ");
    }
    builder.deleteCharAt(builder.length() -1);
    return builder.toString();
  }
}
