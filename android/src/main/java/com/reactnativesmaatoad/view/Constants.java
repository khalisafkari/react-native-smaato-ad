package com.reactnativesmaatoad.view;

import android.os.Build;
import android.util.ArrayMap;

import androidx.annotation.RequiresApi;

import com.facebook.react.common.MapBuilder;
import com.smaato.sdk.banner.ad.AutoReloadInterval;
import com.smaato.sdk.banner.ad.BannerAdSize;

import java.util.Map;

public class Constants {
  public static String TAG = "SmaatoAd";
  public static String BANNER = "RNBannerSmaato";
  public static String Intertitial = "RNIntertitialSmaato";
  public static String Reward = "RNRewardSmaato";
  public static String Initialize = "RNInitialize";

  public static BannerAdSize getBannerSize(final String string) {
      switch (string) {
        case "SKYSCRAPER_120x600":
          return BannerAdSize.SKYSCRAPER_120x600;
        case "LEADERBOARD_728x90":
          return BannerAdSize.LEADERBOARD_728x90;
        case "MEDIUM_RECTANGLE_300x250":
          return BannerAdSize.MEDIUM_RECTANGLE_300x250;
        case "XX_LARGE_320x50":
          return BannerAdSize.XX_LARGE_320x50;
        default:
          return BannerAdSize.XX_LARGE_320x50;
      }
  }

  public static AutoReloadInterval getReloadInterval(final String string) {
    switch (string){
      case "DISABLED":
        return AutoReloadInterval.DISABLED;
      case "DEFAULT":
        return AutoReloadInterval.DEFAULT;
      case "VERY_SHORT":
        return AutoReloadInterval.VERY_SHORT;
      case "SHORT":
        return AutoReloadInterval.SHORT;
      case "NORMAL":
        return AutoReloadInterval.NORMAL;
      case "LONG":
        return AutoReloadInterval.LONG;
      case "VERY_LONG":
        return AutoReloadInterval.VERY_LONG;
      default:
        return AutoReloadInterval.DEFAULT;
    }
  }

  @RequiresApi(api = Build.VERSION_CODES.KITKAT)
  public static Map<String,Object> getExportedCustomDirectEventTypeConstantsFromEvents(String[] events) {
    Map<String, Object> obj = new ArrayMap<>();
    for (String event:events) {
      obj.put(event, MapBuilder.of("registrationName",event));
    }
    return obj;
  }
}
