package com.huobi.client.examples;

import com.huobi.client.SubscriptionClient;
import com.huobi.client.SubscriptionOptions;
import com.huobi.client.model.Candlestick;
import com.huobi.client.model.enums.CandlestickInterval;

public class SubscribeCandlestickEvent {
  public static void main(String[] args) {
    SubscriptionClient subscriptionClient = SubscriptionClient.create();
    subscriptionClient.subscribeAllCandlestickEvent("btcusdt", CandlestickInterval.MIN1, (list) -> {
      for(Object c:list){
        Candlestick data = (Candlestick)c;
        System.out.println();
        System.out.println("Timestamp: " + data.getTimestamp());
        System.out.println("High: " + data.getHigh());
      }
    });
  }
}
