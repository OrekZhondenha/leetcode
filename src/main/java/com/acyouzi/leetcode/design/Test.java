package com.acyouzi.leetcode.design;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 17/9/5 16:09
 *
 * @author sunxu
 */
public class Test {
  public static void main(String[] args) {
    PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o1 > o2 ? -1 : 1;
      }
    });
    queue.add(2);
    queue.add(5);
    queue.add(4);
    queue.add(1);
    while (!queue.isEmpty()){
      System.out.println(queue.poll());
    }
  }
}
