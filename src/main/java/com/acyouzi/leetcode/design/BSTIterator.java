package com.acyouzi.leetcode.design;

import java.util.Stack;

/**
 * 17/9/5 12:30
 *
 * @author sunxu
 */


class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}
public class BSTIterator {
  private Stack<TreeNode> stack = new Stack<TreeNode>();

  public BSTIterator(TreeNode root) {
    pushAll(root);
  }

  public boolean hasNext() {
    return !stack.isEmpty();
  }

  public int next() {
    TreeNode tmpNode = stack.pop();
    pushAll(tmpNode.right);
    return tmpNode.val;
  }

  private void pushAll(TreeNode node) {
    for (; node != null; stack.push(node), node = node.left);
  }
}
