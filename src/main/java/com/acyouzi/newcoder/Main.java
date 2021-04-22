package com.acyouzi.newcoder;

import java.util.Scanner;

/**
 * 17/8/22 18:22
 *
 * @author sunxu
 */
public class Main {
  static class Point{
    public int x;
    public int y;

    public Point(int x, int y){
      this.x = x;
      this.y = y;
    }
  }
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int len = in.nextInt();
    Point[] points = new Point[len];
    int[] index = new int[len];

    for (int i = 0; i < len; i++) {
      points[i] = new Point(in.nextInt(),in.nextInt());
    }
    int resLen = 0;
    for (int i = 0; i < len; i++) {
      boolean flag = true;
      for (int j = 0; j < len; j++) {
        if (i == j) continue;
        if (points[i].x < points[j].x && points[i].y < points[j].y){
          flag = false;
          break;
        }
      }
      if (flag) {
        resLen += 1;
        index[i] = 1;
      }
    }
    int start = 0;
    for (int i = 0; i < len; i++) {
      if (index[i] == 1) {
        points[start++] = points[i];
      }
    }
    quickSort(points,0,resLen-1);
    for (int i = 0; i < resLen; i++) {
      System.out.println(points[i].x + " " + points[i].y);
    }
  }

  // 快排
  private static int partitionByLast(Point[] arr, int first, int last){
    int x = arr[last].x;
    int i = first - 1;
    for (int j = first; j < last; j++) {
      if (arr[j].x < x ){
        i ++;
        Point temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }
    Point temp = arr[i+1];
    arr[i+1] = arr[last];
    arr[last] = temp;
    return i+1;
  }
  public static void quickSort(Point[] arr, int first, int last){
    if (first < last ){
      int pos = partitionByLast(arr, first, last);
      quickSort(arr,first,pos-1);
      quickSort(arr,pos+1,last);
    }
  }
}
