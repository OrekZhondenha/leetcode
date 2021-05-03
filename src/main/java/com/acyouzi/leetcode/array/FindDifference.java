package com.acyouzi.leetcode.array;

import java.util.HashMap;

/**
 * 17/9/2 13:45
 *
 * @author sunxu
 */
public class FindDifference {
  public char findTheDifference(String s, String t) {
    HashMap<Character,Integer> map = new HashMap<>();
    for (char c : s.toCharArray()){
      map.put(c,map.getOrDefault(c,0)+1);
    }
    for (char c : t.toCharArray()){
      int tmp = map.getOrDefault(c,0);
      if (tmp == 0){
        return c;
      }else {
        map.put(c,tmp-1);
      }
    }
    return ' ';
  }
}
