package com.acyouzi.leetcode.design;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 17/9/5 15:43
 *
 * @author sunxu
 */
public class MedianFinder {
  PriorityQueue<Integer> small = new PriorityQueue<>(new Comparator<Integer>() {
    @Override
    public int compare(Integer o1, Integer o2) {
      // 大根堆
      return o1 > o2 ? -1 : 1;
    }
  });
  PriorityQueue<Integer> large = new PriorityQueue<>(new Comparator<Integer>() {
    @Override
    public int compare(Integer o1, Integer o2) {
      // 小根堆
      return o1 > o2 ? 1 : -1;
    }
  });

  public void addNum(int num) {
    small.add(num);
    large.add(small.poll());
    if (large.size() > small.size()){
      small.add(large.poll());
    }
  }

  public double findMedian() {
    if (small.size() == large.size()){
      return ((double) (small.peek() + large.peek()))/2;
    } else {
      return small.peek();
    }
  }
}
