package com.acyouzi;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 17/8/25 20:34
 *
 * @author sunxu
 */
public class Main2 {

  static String[] fsd_team(String[] staff_info) {
    HashMap<String,Integer> map = new HashMap<>();
    HashMap<String,Set<String>> mapset = new HashMap<>();
    for (String num : staff_info){
      String[] arr = num.split(",");
      map.put(arr[0],0);
      if (mapset.containsKey(arr[1])){
        mapset.get(arr[1]).add(arr[0]);
      }else {
        HashSet<String> set = new HashSet<>();
        set.add(arr[0]);
        mapset.put(arr[1],set);
      }
    }
    return new String[]{""};
  }

  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    String[] res;

    int _staff_info_size = 0;
    _staff_info_size = Integer.parseInt(in.nextLine().trim());
    String[] _staff_info = new String[_staff_info_size];
    String _staff_info_item;
    for(int _staff_info_i = 0; _staff_info_i < _staff_info_size; _staff_info_i++) {
      try {
        _staff_info_item = in.nextLine();
      } catch (Exception e) {
        _staff_info_item = null;
      }
      _staff_info[_staff_info_i] = _staff_info_item;
    }

    res = fsd_team(_staff_info);
    for(int res_i=0; res_i < res.length; res_i++) {
      System.out.println(String.valueOf(res[res_i]));
    }

  }
}
