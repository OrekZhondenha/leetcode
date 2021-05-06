package com.acyouzi.leetcode.design;

import java.util.HashMap;

/**
 * Created by sunxu on 17/6/11.
 */
public class LRUCache {
  class Node{
    int val;
    Node pre = null;
    Node next = null;
    public Node(int val){
      this.val = val;
    }
  }
  int capacity;
  int count = 0;
  Node head;
  Node tail;
  HashMap<Integer,Node> map = new HashMap<>();

  public LRUCache(int capacity) {
    this.capacity = capacity;
    head = new Node(0);
    tail = head;
  }

  public int get(int key) {
    if (map.containsKey(key)){
      Node tmp = map.get(key);
      head.next = tmp;
      tmp.pre.next = tmp.next;
      tmp.next.pre = tmp.pre;
      tmp.next = head.next;
      tmp.pre = head;
      head.next = tmp;
      return tmp.val;
    }
    return -1;
  }

  public void put(int key, int value) {
    if (map.containsKey(key)){
      Node tmp = map.get(key);
      tmp.val = value;
      head.next = tmp;
      tmp.pre.next = tmp.next;
      tmp.next.pre = tmp.pre;
      tmp.next = head.next;
      tmp.pre = head;
      head.next = tmp;
    }else{
      if (count < capacity){
        Node tmp = new Node(value);
        head.next = tmp;
        tmp.pre.next = tmp.next;
        tmp.next.pre = tmp.pre;
        tmp.next = head.next;
        tmp.pre = head;
        head.next = tmp;
        count ++;
      }else{
        // 删除末尾节点，插入头结点
        count --;
      }
    }
  }
}
