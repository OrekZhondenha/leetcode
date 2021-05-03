package com.acyouzi.leetcode.List;

/**
 * 17/9/2 14:23
 *
 * @author sunxu
 */
public class ListCycle {
  // 证明
  // 2(a + b) = a + b + c + b
  // a = c
  public ListNode detectCycle(ListNode head) {
    if (head == null) return null;
    ListNode slow = head.next;
    ListNode fast = head.next == null? null:head.next.next;
    if (fast == null) return null;
    while (slow != fast && fast != null){
      slow = slow.next;
      fast = fast.next == null ? null : fast.next.next;
    }
    if (slow != fast) return null;
    slow = head;
    while (slow != fast){
      slow = slow.next;
      fast = fast.next;
    }
    return slow;
  }
}
