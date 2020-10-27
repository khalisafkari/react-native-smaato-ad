package com.reactnativesmaatoad;

import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.reactnativesmaatoad.view.BannerEvents;
import com.reactnativesmaatoad.view.BannerViewAd;
import com.reactnativesmaatoad.view.Constants;

import java.util.Map;

public class BannerViewManager extends ViewGroupManager<BannerViewAd> {

  private static final String TAG = Constants.TAG;
  public static final int COMMAND_LOAD_AD = 0;
  public static final int COMMAND_DESTROY = 1;

  @NonNull
  @Override
  public String getName() {
    return Constants.BANNER;
  }

  @NonNull
  @Override
  protected BannerViewAd createViewInstance(@NonNull ThemedReactContext reactContext) {
    return new BannerViewAd(reactContext);
  }

  @ReactProp(name = "adID")
  public void setAdId(final BannerViewAd view,final String adid) {
    view.setAdId(adid);
  }

  @ReactProp(name = "bannerAdSize")
  public void setBannerAdSize(final BannerViewAd view,final String bannerAdSize) {
    view.setBannerAdSize(bannerAdSize);
  }

  @ReactProp(name = "adReload")
  public void setAdReload(final BannerViewAd view,final String reload) {
    view.setReloadVoid(reload);
  }


  @Nullable
  @Override
  @RequiresApi(api = Build.VERSION_CODES.KITKAT)
  public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
    BannerEvents[] bannerEvents = BannerEvents.values();
    String[] events = new String[bannerEvents.length];
    for (int i = 0;i < bannerEvents.length;i++) {
      events[i] = bannerEvents[i].getName();
    }
    return Constants.getExportedCustomDirectEventTypeConstantsFromEvents(events);
  }

  @Nullable
  @Override
  public Map<String, Integer> getCommandsMap() {
    return MapBuilder.of("loadAd",COMMAND_LOAD_AD,"destroy",COMMAND_DESTROY);
  }

  @Override
  public void receiveCommand(@NonNull BannerViewAd root, String commandId, @Nullable ReadableArray args) {
    switch (commandId) {
      case "loadAd":
        Log.d(TAG,commandId);
        root.loadAd();
        break;
      case "destroy":
        root.destroy();
        break;
      default:
        break;
    }
  }
}
