package com.acyouzi.leetcode.sort;

import java.util.*;

/**
 * 17/8/19 10:36
 *
 * @author sunxu
 */
public class Solution {
  public static class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }
  // https://leetcode.com/problems/merge-intervals/description/
  public List<Interval> merge(List<Interval> intervals) {
    List<Interval> res = new ArrayList<>();
    if (intervals == null || intervals.size() == 0) return res;
    intervals.sort(new Comparator<Interval>() {
      public int compare(Interval o1, Interval o2) {
        if (o1.start < o2.start) return -1;
        if (o1.start > o2.start) return 1;
        if (o1.end < o2.end) return -1;
        if (o1.end > o2.end) return 1;
        return 0;
      }
    });

    int start = -1;
    int end = -1;

    for (Interval interval : intervals){
      if (interval.start > end) {
        if (start >= 0) res.add(new Interval(start,end));
        start = interval.start;
        end = interval.end;
      }
      end = Math.max(end,interval.end);
    }
    res.add(new Interval(start,end));
    return res;
  }

  public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    List<Interval> res = new ArrayList<>();
    if (intervals == null || intervals.size() == 0) {
      res.add(newInterval);
      return res;
    }
    boolean flag = true;
    for (Interval interval : intervals){
      // 画图写代码
      if (interval.end < newInterval.start || interval.start > newInterval.end) {
        if (flag && interval.start > newInterval.end){
          res.add(newInterval);
          flag = false;
        }
        res.add(interval);
      } else {
        if (interval.start < newInterval.start && interval.end < newInterval.end) {
          newInterval.start = interval.start;
        } else if (interval.start > newInterval.start && interval.end > newInterval.end) {
          newInterval.end = interval.end;
        } else {
          // 两种被包裹的情况
          newInterval.start = Math.max(newInterval.start,interval.start);
          newInterval.end = Math.max(newInterval.end,interval.end);
        }
      }
    }
    // 考虑边界情况
    if (flag) res.add(newInterval);
    return res;
  }

  public void sortColors(int[] nums) {
    Arrays.sort(nums);
  }

  public String largestNumber(int[] nums) {
    List<String> list = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      list.add(Integer.toString(nums[i]));
    }
    list.sort(new Comparator<String>() {
      @Override
      public int compare(String x, String y) {
        String s1 = x + y;
        String s2 = y + x;
        return s2.compareTo(s1);
      }
    });
    if(list.get(0).charAt(0) == '0') return "0";
    StringBuilder sb = new StringBuilder();
    for (String s : list){
      sb.append(s);
    }
    return sb.toString();
  }

  public static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }
  public ListNode insertionSortList(ListNode head) {
    ListNode tmp = new ListNode(Integer.MIN_VALUE);
    if (head == null) return head;
    tmp.next = head;
    head = head.next;
    tmp.next.next = null;

    while (head != null){
      ListNode node = head;
      head = head.next;
      // 插入位置
      ListNode start = tmp.next;
      ListNode prestart = tmp;
      while (start!=null){
        if (start.val > node.val){
          prestart.next = node;
          node.next = start;
          break;
        }
        prestart = start;
        start = start.next;
      }
      if( node != null ){
        prestart.next = node;
        node.next = null;
      }
    }
    return tmp.next;
  }
  // 归并排序
  public static ListNode sortList(ListNode head) {
    if (head == null) return head;
    ListNode list1 = new ListNode(Integer.MIN_VALUE);
    ListNode list2 = new ListNode(Integer.MIN_VALUE);
    splitList(head,list1,list2);
    list1.next = sortList(list1.next);
    list2.next = sortList(list2.next);
    return mergeSort(list1.next,list2.next);
  }

  public static void splitList(ListNode head,ListNode list1,ListNode list2){
    while (head != null){
      list1.next = head;
      list1 = list1.next;
      head = head.next;
      list1.next = null;
      if (head != null){
        list2.next = head;
        list2 = list2.next;
        head = head.next;
        list2.next = null;
      }
    }
  }

  public static ListNode mergeSort(ListNode batch1, ListNode batch2){
    ListNode tmp = new ListNode(Integer.MIN_VALUE);
    ListNode head = tmp;
    while (batch1 != null && batch2 != null){
      if (batch1.val <= batch2.val){
        tmp.next = batch1;
        tmp = tmp.next;
        batch1 = batch1.next;
      }else{
        tmp.next = batch2;
        tmp = tmp.next;
        batch2 = batch2.next;
      }
      tmp.next = null;
    }
    if (batch1 != null) tmp.next = batch1;
    if (batch2 != null) tmp.next = batch2;
    return head.next;
  }

  public static void wiggleSort(int[] nums) {
    int[] res = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      res[i] = nums[i];
    }
    // 排序
    Arrays.sort(res);
    int mid = (res.length+1) / 2;
    int end = res.length;
    for (int i = 0; i < nums.length; i++) {
      nums[i] = (i & 1) == 1 ? res[--end] : res[--mid];
    }
  }

  public boolean isAnagram(String s, String t) {
    char[] schar = s.toCharArray();
    char[] tchar = t.toCharArray();
    Arrays.sort(schar);
    Arrays.sort(tchar);
    return String.valueOf(schar).equals(String.valueOf(tchar));
  }

  public String findLongestWord(String s, List<String> d) {
    d.sort(new Comparator<String>() {
      public int compare(String o1, String o2) {
        return o1.length() != o2.length() ? -Integer.compare(o1.length(), o2.length()) :  o1.compareTo(o2);
      }
    });

    for (String word : d){
      char[] c = word.toCharArray();
      int index = 0;
      for (char i : s.toCharArray()){
        if (index < word.length() && i == c[index]) index++;
      }
      if (index == word.length()) return word;
    }
    return "";
  }

  public int[] intersection(int[] nums1, int[] nums2) {
    Set<Integer> set = new HashSet<Integer>();
    for (int i : nums1){
      set.add(i);
    }
    Set<Integer> res = new HashSet<Integer>();
    for (int i : nums2){
      if (set.contains(i)) set.add(i);
    }
    int[] arr = new int[res.size()];
    int i = 0;
    for (Integer num : res) {
      arr[i++] = num;
    }
    return arr;
  }
  public static void main(String[] args) {
    wiggleSort(new int[]{1,5,1,1,6,4});
//    System.out.println( (0 & 1) == 1);
  }
}
