package com.hyt.wy.dao;

import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class safeDog {
    private static int dataDiff = 0;

    static {
        System.loadLibrary("libDog");
    }

    private native int add(int paramInt1, int paramInt2);

    private native String readDog(String paramString);

    private native int writeDog(String paramString);

    public String checkDog() {
//    int baseSize = 25;
//    int scanSize = 10;
//    int pingjuanSize = 10;
//    safeDog dog = new safeDog();
//    String data = dog.readDog("sea");
//    String ret = "1";
//    Date d1 = null;
//    Date d2 = null;
//    Date d3 = null;
//
//    SimpleDateFormat dateTimeDF = new SimpleDateFormat("yyyy-MM-dd");
//    String nowData = dateTimeDF.format(new Date());
//
//    if ((data == null) || ("".equalsIgnoreCase(data))) {
//      System.out.println("狗数据读取错误");
//      ret = "Errot:狗数据读取错误,狗数据为空";
//    }
//
//    if (data != null) {
//      if (data.length() < baseSize)
//      {
//        ret = "Error:读取狗内容错误";
//      }
//
//      String baseData = data.substring(0, baseSize);
//
//      if ("SeaSkyLight:CEPINGLIMITED".equalsIgnoreCase(baseData))
//      {
//        try {
//          d3 = dateTimeDF.parse(nowData);
//        }
//        catch (ParseException e) {
//          e.printStackTrace();
//        }
//
//        String endDate = data.substring(baseSize + 3, baseSize + 13);
//        if ((endDate == null) || ("".equals(endDate)))
//        {
//          return "Error:读取狗过期时间错误";
//        }
//        try
//        {
//          d1 = dateTimeDF.parse(endDate);
//        }
//        catch (Exception ex) {
//          System.out.println("Error:读取狗过期时间错误" + ex.getMessage());
//          return "Error:读取狗过期时间错误";
//        }
//
//        String upDate = data.substring(baseSize + 16, baseSize + 26);
//        if ((upDate == null) || ("".equals(upDate)))
//        {
//          dog.writeDog(nowData);
//          upDate = nowData;
//        }
//
//        try
//        {
//          d2 = dateTimeDF.parse(upDate);
//        }
//        catch (Exception ex) {
//          System.out.println("Error:写入狗时间错误" + ex.getMessage());
//          return "Error:写入狗时间错误";
//        }
//
//        if (d3.getTime() < d2.getTime())
//        {
//          return "Error:校验狗时间错误，请与微软时间服务器同步系统时间后在登录系统";
//        }
//
//        if (d1.getTime() < d3.getTime())
//        {
//          dog.writeDog(nowData);
//          return "Error:您的狗已经过期，请与海云天公司联系";
//        }
//
//        dataDiff = (int)((d1.getTime() - d3.getTime()) / 86400000L);
//
//        dog.writeDog(nowData);
//      }
//      else {
//        return "Error:非本软件评卷狗";
//      }
//
//    }

        return "0";
    }

    public int getDogNoUseData() {
        return dataDiff;
    }

    public static void main(String[] args) {
    }
}