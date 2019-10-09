package com.huobi.client.impl.utils;

import com.alibaba.fastjson.JSONObject;
import com.huobi.client.model.enums.BalanceMode;
import com.huobi.client.model.enums.CandlestickInterval;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Channels {

  public static String klineChannel(String symbol, CandlestickInterval interval) {
    JSONObject json = new JSONObject();
    json.put("sub", "market." + symbol + ".kline." + interval.toString());
    json.put("id", TimeService.getCurrentTimeStamp() + "");
    return json.toJSONString();
  }

  public static List<String> klineChannelAll(String symbol, CandlestickInterval interval) {
    List l = new ArrayList();
    JSONObject json = new JSONObject();
    json.put("req", "market." + symbol + ".kline." + interval.toString());
    for(int i = 1514736000; i < new Date().getTime()/1000; i= i+18000){
      json.put("id", i + "");
      json.put("from", i);
      json.put("to",   i + 18000);
      l.add(json.toJSONString());
    }
    return l;
  }

    public static void main(String[] args) throws Exception {
        String d1 = "2018-01-01 00:00:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date de = sdf.parse(d1);
        System.out.println(de.getTime()/1000);
        System.out.println(new Date().getTime()/1000);
    }


  public static String priceDepthChannel(String symbol) {
    JSONObject json = new JSONObject();
    json.put("sub", "market." + symbol + ".depth.step0");
    json.put("id", TimeService.getCurrentTimeStamp() + "");
    return json.toJSONString();
  }

  public static String tradeChannel(String symbol) {
    JSONObject json = new JSONObject();
    json.put("sub", "market." + symbol + ".trade.detail");
    json.put("id", TimeService.getCurrentTimeStamp() + "");
    return json.toJSONString();
  }

  public static String accountChannel(BalanceMode mode) {
    JSONObject json = new JSONObject();
    json.put("op", "sub");
    json.put("cid", TimeService.getCurrentTimeStamp() + "");
    json.put("topic", "accounts");
    if (mode != null) {
      json.put("model", mode.getCode());
    }
    return json.toJSONString();
  }

  public static String ordersChannel(String symbol) {
    JSONObject json = new JSONObject();
    json.put("op", "sub");
    json.put("cid", TimeService.getCurrentTimeStamp() + "");
    json.put("topic", "orders." + symbol);
    return json.toJSONString();
  }

  public static String tradeStatisticsChannel(String symbol) {
    JSONObject json = new JSONObject();
    json.put("sub", "market." + symbol + ".detail");
    json.put("id", TimeService.getCurrentTimeStamp() + "");
    return json.toJSONString();
  }
}
