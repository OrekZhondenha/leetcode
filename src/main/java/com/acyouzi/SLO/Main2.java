package com.acyouzi.SLO;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 17/8/26 20:10
 *
 * @author sunxu
 */
public class Main2 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int alen = in.nextInt();
    int[] anums = new int[alen];
    for (int i = 0; i < alen; i++) {
      anums[i] = in.nextInt();
    }
    Arrays.sort(anums);
    int asum = Arrays.stream(anums).reduce( (x,y) -> x +y ).getAsInt();
    int blen = in.nextInt();
    int[] bnums = new int[blen];
    for (int i = 0; i < blen; i++) {
      bnums[i] = in.nextInt();
    }
    Arrays.sort(bnums);
    int bsum = Arrays.stream(bnums).reduce( (x,y) -> x +y ).getAsInt();

    for (int i = 0; i < 2; i++) {
      int tmp = asum - bsum;
      if (tmp > 0 ){
        for (int j = 0; j < alen; j++) {
          //
        }
      }
    }

  }
}
