package com.reactnativesmaatoad;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.reactnativesmaatoad.view.Constants;
import com.smaato.sdk.interstitial.EventListener;
import com.smaato.sdk.interstitial.Interstitial;
import com.smaato.sdk.interstitial.InterstitialAd;
import com.smaato.sdk.interstitial.InterstitialError;
import com.smaato.sdk.interstitial.InterstitialRequestError;

public class IntertitialAdModule extends ReactContextBaseJavaModule implements EventListener {

  private ReactApplicationContext mContext;
  private static final String TAG = Constants.TAG;


  public enum Event {
    onAdLoaded("onAdLoaded"),
    onAdFailedToLoad("onAdFailedToLoad"),
    onAdError("onAdError"),
    onAdOpened("onAdOpened"),
    onAdClosed("onAdClosed"),
    onAdClicked("onAdClicked"),
    onAdImpression("onAdImpression"),
    onAdTTLExpired("onAdTTLExpired");

    private String name;
    Event(String name) {
      this.name = name;
    }

    public String getName() {
      return name;
    }
  }

  @NonNull
  @Override
  public String getName() {
    return Constants.Intertitial;
  }

  IntertitialAdModule(@Nullable ReactApplicationContext reactContext) {
    super(reactContext);
    mContext = reactContext;
  }


  @ReactMethod
  public void showAd(String space){
    new Handler(Looper.getMainLooper()).post(() -> {
      Interstitial.loadAd(space,this);
    });
  }


  @Override
  public void onAdLoaded(InterstitialAd interstitialAd) {
    interstitialAd.showAd(getCurrentActivity());
    WritableMap map = new WritableNativeMap();
    map.putString("AdSpaceId",interstitialAd.getAdSpaceId());
    map.putString("CreativeId",interstitialAd.getCreativeId());
    map.putString("SessionId",interstitialAd.getSessionId());
    SendEvent(Event.onAdLoaded,map);
  }

  @Override
  public void onAdFailedToLoad(InterstitialRequestError interstitialRequestError) {
    WritableMap map = new WritableNativeMap();
    map.putString("error",interstitialRequestError.getInterstitialError().toString());
    SendEvent(Event.onAdFailedToLoad,map);
  }

  @Override
  public void onAdError(InterstitialAd interstitialAd, InterstitialError interstitialError) {
    WritableMap map = new WritableNativeMap();
    map.putString("error",interstitialError.toString());
    SendEvent(Event.onAdError,map);
  }

  @Override
  public void onAdOpened(InterstitialAd interstitialAd) {
    SendEvent(Event.onAdOpened,null);
  }

  @Override
  public void onAdClosed(InterstitialAd interstitialAd) {
    SendEvent(Event.onAdClosed,null);
  }

  @Override
  public void onAdClicked(InterstitialAd interstitialAd) {
    SendEvent(Event.onAdClicked,null);
  }

  @Override
  public void onAdImpression(InterstitialAd interstitialAd) {
    SendEvent(Event.onAdImpression,null);
  }

  @Override
  public void onAdTTLExpired(InterstitialAd interstitialAd) {
    SendEvent(Event.onAdTTLExpired,null);
  }

  private void SendEvent(Event event, @Nullable WritableMap wm) {
    Log.d(TAG,"send event:" + event.getName());
    mContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class).emit(event.getName(),wm);
  }

}
