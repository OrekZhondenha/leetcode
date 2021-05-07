package com.acyouzi.leetcode.greedy;

import java.util.ListIterator;
import java.util.Stack;

/**
 * Created by SUN on 2017/9/5.
 */
public class RemoveKDigits {

  // 其基本思想是利用栈尽量维持一个递增的序列，也就是说将字符串中字符依次入栈，
  // 如果当前字符串比栈顶元素小，并且还可以继续删除元素，那么就将栈顶元素删掉，
  // 这样可以保证将当前元素加进去一定可以得到一个较小的序列．也可以算是一个贪心思想．
  // 最后我们只取前len-k个元素构成一个序列即可，如果这样得到的是一个空串那就手动返回０．
  // 还有一个需要注意的是字符串首字符不为０
  // https://leetcode.com/problems/remove-k-digits/description/
  public static String removeKdigits(String num, int k) {
    if (num.length() <= k) return "0";
    Stack<Character> stack = new Stack<>();
    for (char c : num.toCharArray()){
      while ( (!stack.isEmpty()) && k > 0 && c < stack.peek()){
        stack.pop();
        k --;
      }
      stack.push(c);
    }
    StringBuilder builder = new StringBuilder();
    ListIterator<Character> it = stack.listIterator();
    while (it.hasNext()) builder.append(it.next());
    int zero = 0;
    while (builder.length() >0 && builder.charAt(0) == '0') {
      builder.deleteCharAt(0);
      zero++;
    }
    return builder.length() == 0 ? "0" : builder.substring(0,stack.size() - k - zero);
  }

  public static void main(String[] args) {
//    StringBuilder builder = new StringBuilder();
//    builder.append('a');
//    builder.append('a');
//    builder.append('a');
//
//
//    System.out.println(builder.substring(0,2));
    System.out.println(removeKdigits("112",1));
  }
}
