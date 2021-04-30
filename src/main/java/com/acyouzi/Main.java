package com.acyouzi;


import com.sun.javafx.binding.StringFormatter;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
  static String bike_plan(double distance, double speed) {
    double min = Double.MAX_VALUE;
    double ofo = 0;
    if ((int)(distance * 10) % 15 == 0 ){
      ofo = ((int)(distance * 10) / 15) * 1;
    }else {
      ofo = ((int)(distance * 10) / 15) + 1;
    }
    if (ofo == 0.0){
      ofo = 1;
    }
    if (ofo < min) min = ofo;
    double yongan = 0;
    if (speed == 0.0){
      yongan = 0.2;
    }else {
      yongan = Math.ceil(distance / speed) * 0.2;
    }
    if (yongan == 0.0){
      yongan = 0.2;
    }
    if (yongan < min) min = yongan;
    double hellobike = 0;
    int len = (int)Math.ceil(distance);
    if (len <= 2){
      hellobike = 1;
    }else if (len <= 4){
      hellobike = 3;
    }else if (len <= 8){
      hellobike = 5;
    }else{
      hellobike = 8;
    }
    if (hellobike < min) min = hellobike;

    StringBuilder builder = new StringBuilder();
    if (ofo == min){
      builder.append("和OFO小黄车" + ofo + "（元）");
    }
    if(yongan == min){
      builder.append("和永安行" + yongan + "（元）");
    }
    if (hellobike == min){
      builder.append("和hellobike" + hellobike + "（元）");
    }
    return builder.deleteCharAt(0).toString();
  }

  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    String res;

    double _distance;
    _distance = Double.parseDouble(in.nextLine().trim());

    double _speed;
    _speed = Double.parseDouble(in.nextLine().trim());
    res = "骑行距离"+_distance+"(千米)，匀速骑行速度"+_speed+"(千米/分钟)最省钱方案:\n";
    res =  res + bike_plan(_distance, _speed);
    System.out.println(res);
//    System.out.println(Math.ceil(0/0));
  }
}




