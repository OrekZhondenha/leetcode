package com.acyouzi.leetcode.array;

import java.util.*;

/**
 * Created by SUN on 2017/8/29.
 */
public class WordLadder {
  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    List<String> tmp = new ArrayList<>();
    List<List<String>> res = new ArrayList<>();
    Set<String> dict = new HashSet<>();
    for (String str : wordList){
      dict.add(str);
    }
    helper(beginWord,endWord,tmp,res,dict);
    return res;
  }

  public void helper(String beginWord, String endWord, List<String> tmp, List<List<String>> res, Set<String> wordList){
    if (beginWord.equals(endWord)){
      res.add(new ArrayList<>(tmp));
      return;
    }else{
      for (int i = 0; i < endWord.length(); i++) {
        if (beginWord.charAt(i) == endWord.charAt(i)) continue;
        char[] arr = beginWord.toCharArray();
        arr[i] = endWord.charAt(i);
        String next = new String(arr);
        if (wordList.contains(next)){
          tmp.add(next);
          helper(next,endWord,tmp,res,wordList);
          tmp.remove(tmp.size()-1);
        }
      }
    }
  }
}
