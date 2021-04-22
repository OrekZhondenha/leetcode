package com.acyouzi.leetcode.uf;

/**
 * 联合查找，适合用来求分组问题的分组数量，同时类似问题也可以用 dfs 配合数组标记是否已经访问来完成
 * 17/8/19 09:17
 * @author sunxu
 */
public class UF {
  int[] flag;
  int count;
  public UF(int len){
    count = len;
    flag = new int[len];
    for (int i = 0; i < len; i++) {
      flag[i] = i;
    }
  }

  public int findRoot(int index){
    while (flag[index] != index){
      index = flag[index];
    }
    return index;
  }

  public void union(int x, int y){
    int xroot = findRoot(x);
    int yroot = findRoot(y);
    if (xroot == yroot) return;
    flag[yroot] = xroot;
    count--;
  }

  public int count(){
    return count;
  }
}
