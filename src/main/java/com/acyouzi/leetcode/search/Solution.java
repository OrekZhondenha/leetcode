package com.acyouzi.leetcode.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 17/8/22 18:14
 *
 * @author sunxu
 */
public class Solution {
  public static int binarySearch(int[] arr,int val){
    int low = 0;
    int high = arr.length-1;
    int mid;
    while (low <= high){
      mid = (low + high)/2;
      if(arr[mid] == val){
        return mid;
      }else if (arr[mid] > val){
        high = mid - 1;
      }else {
        low = mid + 1;
      }
    }
    return -1;
  }

  // 二进制相加
  public static int[] add(int[] A, int[] B){
    int alen = A.length;
    int blen = B.length;
    int[] C = new int[Math.max(alen,blen)+1];
    int i = 0;
    while (i < alen && i < blen){
      int x = A[i] + B[i] + C[i];
      if (x < 2 ){
        C[i] = x;
      }else {
        C[i] = x - 2;
        C[i+1] = 1;
      }
      ++i;
    }
    while (i < alen ){
      int x = A[i] + C[i];
      if (x < 2 ){
        C[i] = x;
      }else {
        C[i] = x - 2;
        C[i+1] = 1;
      }
      ++i;
    }
    while (i < blen) {
      int x = B[i] + C[i];
      if (x < 2) {
        C[i] = x;
      } else {
        C[i] = x - 2;
        C[i + 1] = 1;
      }
      ++i;
    }
    return C;
  }

  // 归并排序
  private static void mergeArray(int[] arr,int first, int mid, int last, int[] temp){
    int i = first,j=mid+1;
    int k = 0;
    while (i<=mid && j<=last){
      if (arr[i] <= arr[j]){
        temp[k++] = arr[i++];
      }else {
        temp[k++] = arr[j++];
      }
    }
    while (i<= mid){
      temp[k++] = arr[i++];
    }
    while (j<= last){
      temp[k++] = arr[j++];
    }
    for (i = first;i<=last;i++){
      arr[i] = temp[i-first];
    }
  }
  public static void mergeSort(int[] a, int first, int last, int[] temp){
    if (first< last){
      int mid = (first + last)/2;
      mergeSort(a,first,mid,temp);
      mergeSort(a,mid+1,last,temp);
      mergeArray(a,first,mid,last,temp);
    }
  }

  // backward
  private static int backwardNumMerge(int[] arr,int first, int mid, int last, int[] temp){
    int i = first, j = mid + 1;
    int k = 0;
    int num = 0;
    while (i <= mid && j <= last){
      if (arr[i] <= arr[j]){
        temp[k++] = arr[i++];
      }else {
        temp[k++] = arr[j++];
        num = num + mid - i + 1;
      }
    }
    while (i<= mid){
      temp[k++] = arr[i++];
    }
    while (j<= last){
      temp[k++] = arr[j++];
    }
    for (i = first; i<= last; i++ ){
      arr[i] = temp[i - first];
    }
    return num;
  }
  // 逆序对
  public static int backwardNum(int[] arr, int first, int last, int[] temp){
    if (first < last){
      int mid = (first + last)/2;
      int res = 0;
      res += backwardNum(arr,first,mid,temp);
      res += backwardNum(arr,mid+1,last,temp);
      res += backwardNumMerge(arr,first,mid,last,temp);
      return res;
    }
    return 0;
  }

  // 快排
  private static int partitionByLast(int[] arr, int first, int last){
    int x = arr[last];
    int i = first - 1;
    for (int j = first; j < last; j++) {
      if (arr[j] < x ){
        i ++;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }
    int temp = arr[i+1];
    arr[i+1] = arr[last];
    arr[last] = temp;
    return i+1;
  }
  // 从两头分区
  private static int partitionByHoare(int[] arr, int first, int last){
    int key = arr[first];
    while (first < last ){
      while (first < last && arr[last] > key ) last --;
      arr[first] = arr[last];
      while (first < last && arr[first] < key ) first++;
      arr[last] = arr[first];
    }
    arr[first] = key;
    return first;
  }
  public static void quickSort(int[] arr, int first, int last){
    if (first < last ){
//      int pos = partitonByLast(arr,first,last);
      int pos = partitionByHoare(arr, first, last);
      quickSort(arr,first,pos-1);
      quickSort(arr,pos+1,last);
    }
  }
  // 快速选择无序数组排前 n 个的元素
  public static int quickSelect(int[] arr, int l, int r, int index){
    if ( l == r ){
      return arr[l];
    }
    int pos = partitionByLast(arr,l,r);
    if (pos == index){
      return arr[pos];
    }
    if (pos > index){
      return quickSelect(arr,l,pos-1,index);
    }else {
      return quickSelect(arr,pos+1,r,index);
    }
  }
  public static int quickSelectByLoop(int[] arr,int l, int r, int index){
    int pos;
    while ( l != r){
      pos = partitionByLast(arr,l,r);
      if (pos == index){
        return arr[pos];
      }
      if (pos > index){
        r = pos - 1;
      }else {
        l = pos + 1;
      }
    }
    return arr[l];
  }
  public static int calculate(String s) {
    String tmp = s;
    Stack<Integer> nums = new Stack<>();
    int start = 0;
    char sign = '+';
    for (int i = 0; i <= s.length(); i++) {
      if (i == s.length() || (!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i) ) ){
        switch (sign){
          case '+':
            nums.push(Integer.parseInt(tmp.substring(start,i).trim()));
            break;
          case '-':
            nums.push(-Integer.parseInt(tmp.substring(start,i)));
            break;
          case '*':
            nums.push(nums.pop()*Integer.parseInt(tmp.substring(start,i)));
            break;
          case '/':
            nums.push(nums.pop()/Integer.parseInt(tmp.substring(start,i)));
            break;
        }
        if ( i < s.length()){
          sign = s.charAt(i);
          start = i+1;
        }
      }
    }
    int sum = 0;
    for (int num : nums){
      sum += num;
    }
    return sum;
  }

  // 模板，最小窗口，最长距离
  public String minWindow(String s, String t) {
    int[] map = new int[256];
    for (char i : t.toCharArray()) map[i]++;
    int counter = t.length();
    int start = 0;
    int end = 0;
    int head = 0;
    int len = Integer.MAX_VALUE;
    while (end < s.length()){
      if (map[s.charAt(end++)] -- > 0) counter--;
      while (counter == 0){
        if (end - start < len) len = end - (head = start);
        if (map[s.charAt(start++)]++ == 0) counter ++;
      }
    }
    return len == Integer.MAX_VALUE ? "":s.substring(head,head+len);
  }

  // Longest Substring with At Most Two Distinct Characters
  // 至多有两个不同，采用模板
//  int lengthOfLongestSubstringTwoDistinct(string s) {
//    vector<int> map(128, 0);
//    int counter=0, begin=0, end=0, d=0;
//    while(end<s.size()){
  // 需要注意的地方
//      if(map[s[end++]]++==0) counter++;
//      while(counter>2) if(map[s[begin++]]--==1) counter--;
//      d=max(d, end-begin);
//    }
//    return d;
//  }
  // Longest Substring Without Repeating Characters
//  int lengthOfLongestSubstring(string s) {
//    vector<int> map(128,0);
//    int counter=0, begin=0, end=0, d=0;
//    while(end<s.size()){
  // 模板代码，注意此处条件
//      if(map[s[end++]]++>0) counter++;
//      while(counter>0) if(map[s[begin++]]-->1) counter--;
//      d=max(d, end-begin); //while valid, update d
//    }
//    return d;
//  }
  //   cbaabc
  // aabbaadc
  // cdaabbaa
  public static String shortestPalindrome(String s) {
    String rs = new StringBuffer(s).reverse().toString();
    int len = s.length();
    for (int i = 0; i < len; i++) {
      if (s.substring(0,len-i).equals(rs.substring(i))) {
        return s.substring(len-i) + s;
      }
      if (s.substring(i).equals(rs.substring(0,len-i))){
        return s+s.substring(0,i);
      }
    }
    return "";
  }
}
