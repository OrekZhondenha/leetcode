package com.acyouzi.leetcode.heap;

import java.util.Arrays;

/**
 * 17/8/22 18:11
 *
 * @author sunxu
 */
public class Solution {

  public static void main(String[] args) {
    int[] arr = new int[10];
    arr[0] = 12;
    arr[1] = 3;
    arr[2] = 5;
    arr[3] = 15;
    arr[4] = 2;

    HeapSort.buildMaxHeap(arr, 5);
    Arrays.stream(arr).forEach(x -> System.out.print(x + "   "));
    System.out.println();
    HeapSort.insertMaxHeap(arr, 5, 34);
    Arrays.stream(arr).forEach(x -> System.out.print(x + "   "));
  }
}

class HeapSort {
  public static int left(int i) {
    return i << 1;
  }

  public static int right(int i) {
    return (i << 1) + 1;
  }

  public static int parent(int i) {
    return i >> 1;
  }

  private static void maxHeapIFYByLoop(int[] arr, int i, int length) {
    int l = left(i);
    int r = right(i);
    int max = i;
    while (max <= length / 2) {
      l = left(max);
      r = right(max);
      if (l < length && arr[l] > arr[max]) {
        max = l;
      }
      if (r < length && arr[r] > arr[max]) {
        max = r;
      }
      if (max != i) {
        int temp = arr[i];
        arr[i] = arr[max];
        arr[max] = temp;
        i = max;
      } else {
        return;
      }
    }
  }

  public static void buildMaxHeap(int[] arr, int length) {
    int i = length / 2;
    while (i >= 0) {
      maxHeapIFYByLoop(arr, i, length);
      i--;
    }
  }

  // 注意等于 0 的情况
  public static void increaseMaxHeapElemKey(int[] arr, int index, int val) {
    if (arr[index] > val) {
      throw new IllegalArgumentException("increase key must big than old");
    }
    while (index > 0 && val > arr[parent(index)]) {
      arr[index] = arr[parent(index)];
      index = parent(index);
    }
//    if (parent(index) == 0){
//      arr[index] = arr[parent(index)];
//      index = parent(index);
//    }
    arr[index] = val;
  }

  // 返回长度
  public static int insertMaxHeap(int[] arr, int length, int val) {
    arr[length] = Integer.MIN_VALUE;
    HeapSort.increaseMaxHeapElemKey(arr, length, val);
    return length++;
  }

  //  public static void buildMaxHeapByInsert(){
//
//  }
  public static void maxHeapSort(int[] arr) {
    HeapSort.buildMaxHeap(arr, arr.length);
    for (int i = arr.length - 1; i > 0; i--) {
      int temp = arr[i];
      arr[i] = arr[0];
      arr[0] = temp;
      maxHeapIFYByLoop(arr, 0, i);
    }
  }

}