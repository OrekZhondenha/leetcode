package com.acyouzi.leetcode.string;

import org.omg.CORBA.StringSeqHelper;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 17/8/20 14:20
 *
 * @author sunxu
 */
public class Solution {
  public static void main(String[] args) {
//    strStr("a","a");
//    longestValidParentheses("()(()");
//    System.out.println(countAndSay(1));
//    System.out.println("aa".substring(1,3));
//    System.out.println(Integer.MAX_VALUE);
//    minDistance("minDistancepark","spake");
    nextGreaterElement(12443322);
  }
  public static int lengthOfLongestSubstring(String s) {
    Set<Character> set = new HashSet<>();
    int start = 0;
    int end = 0;
    char[] arr = s.toCharArray();
    int max = 0;
    while (end < arr.length) {
      if (set.contains(arr[end])){
        set.remove(arr[start++]);
      }else {
        set.add(arr[end++]);
      }
      max = Math.max(max,end - start);
    }
    return max;
  }

  public static String longestPalindrome(String s) {
    int n = s.length();
    String res = null;
    boolean[][] dp = new boolean[n][n];
    for (int i = n - 1; i >= 0; i--) {
      for (int j = i; j < n; j++) {
        dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

        if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
          res = s.substring(i, j + 1);
        }
      }
    }
    return res;
  }

  public int myAtoi(String str) {
    char[] arr = str.toCharArray();
    int sum = 0;
    int flag = 1;
    for (int i = 0; i < arr.length; i++) {
      if (i == 0 && arr[i] == '-') {
        flag = -1;
        continue;
      }
      if (i == 0 && arr[i] == '+') {
        continue;
      }
      sum = sum * 10 + (arr[i] - '0');
    }
    return flag * sum;
  }

  public String longestCommonPrefix(String[] strs) {
    if ( strs.length == 0 ) return "";
    StringBuilder builder = new StringBuilder();
    int len = Integer.MAX_VALUE;
    String tmp = null;
    for (String str : strs){
      if( str.length() < len ){
        len = str.length();
        tmp =str;
      }
    }
    for (int i = 0; i < len; i++) {
      boolean isprefix = true;
      for (String str : strs){
        if (tmp.charAt(i) != str.charAt(i)){
          isprefix = false;
          break;
        }
      }
      if (isprefix) builder.append(tmp.charAt(i));
      else break;
    }
    return builder.toString();
  }

  public List<String> generateParenthesis(int n) {
    List<String> res = new ArrayList<>();
    getPath(n*2,new StringBuilder(),0,0,res);
    return res;
  }

  public static void getPath(int deep, StringBuilder builder, int open, int close, List<String> res){
    if (builder.length() == deep){
      res.add(builder.toString());
      return;
    }
    if (open < deep/2){
      getPath(deep,builder.append('('),open+1,close,res);
      builder.deleteCharAt(builder.length() - 1);
    }
    if (close < deep/2){
      getPath(deep,builder.append(')'),open,close+1,res);
      builder.deleteCharAt(builder.length() - 1);
    }
  }

  public static int strStr(String haystack, String needle) {
    if (needle.length() == 0) return 0;
    if (haystack.length() == 0 && needle.length() != 0) return -1;
    int start = 0;
    int end = needle.length()-1;
    int len = haystack.length();
    while (end < len){
      if (haystack.substring(start,end).equals(needle)) return start;
      start++;
      end++;
    }
    return -1;
  }

  public static int longestValidParentheses(String s) {
    Stack<Character> stack = new Stack<>();
    int max = 0;
    int start = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '('){
        stack.push('(');
      }else {
        if (!stack.isEmpty() && stack.peek() == '(') {
          stack.pop();
          max = Math.max(max,i - start - stack.size() + 1);
        }else {
          start = i + 1;
          stack.clear();
        }
      }
    }
    return max;
  }
  public static String countAndSay(int n) {
    return say(n,"1");
  }
  public static String say(int n, String code){
    if (n == 1) return code;
    StringBuilder builder = new StringBuilder();
    int start = 0;
    for (int i = 1; i < code.length(); i++) {
      if (code.charAt(i) != code.charAt(i-1)){
        builder.append(""+(i-start)+code.charAt(i-1));
        start = i;
      }
    }
    builder.append(""+(code.length()-start)+code.charAt(code.length()-1));
    return say(n-1,builder.toString());
  }

  public List<List<String>> groupAnagrams(String[] strs) {
    HashMap<String,List<String>> map = new HashMap<>();
    for (String str : strs){
      char[] c = str.toCharArray();
      Arrays.sort(c);
      if (map.containsKey(String.valueOf(c))){
        map.get(String.valueOf(c)).add(str);
      }else {
        List<String> list = new ArrayList<>();
        list.add(str);
        map.put(String.valueOf(c),list);
      }
    }
    List<List<String>> res = new ArrayList<>();
    for (List<String> list : map.values()){
      res.add(list);
    }
    return res;
  }

  public static List<String> restoreIpAddresses(String s) {

    List<String> res = new ArrayList<>();
    if (s.length() == 0 || s.length() > 12) return res;
    getIp(0,"",res,s);
    return res;
  }

  public static void getIp(int index, String str, List<String> res ,String comm){
    if (index == comm.length() && str.length() == comm.length() + 4){
      res.add(str.substring(0,str.length()-1));
    }
    for (int i = 1; i <= 3; i++) {
      if (index + i > comm.length()) break;
      String tmp = comm.substring(index, index + i);
      if (tmp.length() > 1 && tmp.startsWith("0")) continue;
      if (Integer.parseInt(tmp) <= 255){
        getIp(index+i,str + tmp + '.',res,comm);
      }
    }
  }

  public static int minDistance(String word1, String word2) {
    int[][] dp = new int[word1.length()+1][word2.length()+1];
    int max = 0;
    for (int i = 1; i <= word1.length(); i++) {
      for (int j = 1; j <= word2.length(); j++) {
        if (word1.charAt(i-1) == word2.charAt(j-1)){
          dp[i][j] = dp[i-1][j-1] + 1;
          max = Math.max(max,dp[i][j]);
        }else{
          dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
        }
      }
    }
    return (word1.length()) - max + (word2.length() - max);
  }

  public int minDistance2(String word1, String word2) {
    if ( word1.length() == 0 || word2.length() == 0 ) return Math.max(word1.length(),word2.length());
    int[][] dp = new int[word1.length()+1][word2.length()+1];
    int max = 0;
    for (int i = 1; i <= word1.length(); i++) {
      for (int j = 1; j <= word2.length(); j++) {
        if (word1.charAt(i-1) == word2.charAt(j-1)){
          dp[i][j] = dp[i-1][j-1] + 1;
          max = Math.max(max,dp[i][j]);
        }else{
          dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
        }
      }
    }
    return Math.abs(word1.length() - word2.length()) + Math.min(word1.length(),word2.length()) - max;
  }

  public static int nextGreaterElement(int n) {
    char[] arr = String.valueOf(n).toCharArray();
    for (int i = arr.length - 1; i > 0 ; i--) {
      for (int j = i; j >=0; j--) {
        if (arr[i] > arr[j]){
          char tmp = arr[j];
          arr[j] = arr[i];
          arr[i] = tmp;
          // 排序
          for (int k = arr.length; k > j ; k--) {
            for (int l = k+1; l > j; l--) {
              if (arr[k] < arr[l]){
                tmp = arr[k];
                arr[k] = arr[l];
                arr[l] = tmp;
              }
            }
          }
          String str = String.valueOf(arr);
          String MAX = String.valueOf(Integer.MAX_VALUE);
          if (str.length() < MAX.length()){
            return Integer.parseInt(str);
          }else {
            return str.compareTo(MAX) <=0 ? Integer.parseInt(str): -1;
          }
        }
      }
    }
    return -1;
  }
  
}
