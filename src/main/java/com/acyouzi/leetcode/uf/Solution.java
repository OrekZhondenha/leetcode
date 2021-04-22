package com.acyouzi.leetcode.uf;

/**
 * 17/8/19 09:15
 *
 * @author sunxu
 */
public class Solution {
  // 并集查找
  public int findCircleNum(int[][] M) {
    int[] flag = new int[M.length+1];
    for (int i = 0; i <= M.length; i++) {
      flag[i] = i;
    }

    for (int i = 0; i < M.length; i++) {
      for (int j = i+1; j < M.length; j++) {
        if (M[i][j] == 1) {
          int xroot = findRoot(i+1, flag);
          int yroot = findRoot(j+1, flag);
          if (xroot != yroot) flag[yroot] = xroot;
        }
      }
    }
    int sum = 0;
    for (int i = 1; i <= M.length; i++) {
      sum += flag[i] == i ? 1 : 0;
    }
    return sum;
  }

  private int findRoot(int index, int[] flag) {
    while (flag[index] != index){
      index = flag[index];
    }
    return index;
  }

  public int numIslands(char[][] grid) {
    int row = grid.length;
    int col = grid[0].length;
    int len = row * col;
    int zero = 0;
    UF uf = new UF(len);
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (grid[i][j] == 0) {zero++;continue;}
        int x = i * col + j;
        if (i > 0 && grid[i-1][j] == 1) uf.union(x,(i-1) * col + j);
        if (i < row-1 && grid[i+1][j] == 1) uf.union(x,(i+1) * col + j);
        if (j > 0 && grid[i][j-1] == 1) uf.union(x,(i) * col + j-1);
        if (j < col-1 && grid[i][j+1] == 1) uf.union(x,(i) * col + j+1);
      }
    }
    return uf.count() - zero;
  }

  public void solve(char[][] board) {
    if (board == null || board.length == 0) return;
    int row = board.length;
    int col = board[0].length;
    int len = row * col;
    UF uf = new UF(len);
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        
      }
    }
  }
}
