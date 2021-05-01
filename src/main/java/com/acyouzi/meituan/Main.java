package com.acyouzi.meituan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 17/8/31 20:03
 *
 * @author sunxu
 */
public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int len = in.nextInt();
    int sum = 0;
    int max = 0;
    for (int i = 0; i < len; i++) {
      int tmp = in.nextInt();
      sum = sum + tmp;
      max = Math.max(max,tmp);
    }

    if (2 * max <= sum) System.out.println("Yes");
    else System.out.println("No");
  }
}
