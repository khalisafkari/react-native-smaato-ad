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
import com.smaato.sdk.rewarded.EventListener;
import com.smaato.sdk.rewarded.RewardedError;
import com.smaato.sdk.rewarded.RewardedInterstitial;
import com.smaato.sdk.rewarded.RewardedInterstitialAd;
import com.smaato.sdk.rewarded.RewardedRequestError;

public class RewardAdModule extends ReactContextBaseJavaModule implements EventListener {


  private ReactApplicationContext mContext;
  private final static String TAG = Constants.TAG;

  public enum Event {
    onAdLoaded("onAdLoaded"),
    onAdFailedToLoad("onAdFailedToLoad"),
    onAdError("onAdError"),
    onAdStarted("onAdStarted"),
    onAdClosed("onAdClosed"),
    onAdClicked("onAdClicked"),
    onAdReward("onAdReward"),
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
    return Constants.Reward;
  }

  RewardAdModule(@Nullable  ReactApplicationContext context) {
    super(context);
    mContext = context;
  }

  @ReactMethod
  public void showAd(String space){
    new Handler(Looper.getMainLooper()).post(() -> {
      RewardedInterstitial.loadAd(space,this);
    });
  }

  @Override
  public void onAdLoaded(@NonNull RewardedInterstitialAd rewardedInterstitialAd) {
    rewardedInterstitialAd.showAd();
    WritableMap wm = new WritableNativeMap();
    wm.putString("AdSpaceId",rewardedInterstitialAd.getAdSpaceId());
    wm.putString("SessionId",rewardedInterstitialAd.getSessionId());
    wm.putString("CreativeId",rewardedInterstitialAd.getCreativeId());
    SendEvent(Event.onAdLoaded,wm);
  }

  @Override
  public void onAdFailedToLoad(@NonNull RewardedRequestError rewardedRequestError) {
    WritableMap wm = new WritableNativeMap();
    wm.putString("Error",rewardedRequestError.getRewardedError().toString());
    SendEvent(Event.onAdFailedToLoad,wm);
  }

  @Override
  public void onAdError(@NonNull RewardedInterstitialAd rewardedInterstitialAd, @NonNull RewardedError rewardedError) {
    WritableMap wm = new WritableNativeMap();
    wm.putString("AdSpaceId",rewardedInterstitialAd.getAdSpaceId());
    wm.putString("SessionId",rewardedInterstitialAd.getSessionId());
    wm.putString("CreativeId",rewardedInterstitialAd.getCreativeId());
    wm.putString("rewardedError",rewardedError.toString());
    SendEvent(Event.onAdError,wm);
  }

  @Override
  public void onAdClosed(@NonNull RewardedInterstitialAd rewardedInterstitialAd) {
    rewardedInterstitialAd.showAd();
    WritableMap wm = new WritableNativeMap();
    wm.putString("AdSpaceId",rewardedInterstitialAd.getAdSpaceId());
    wm.putString("SessionId",rewardedInterstitialAd.getSessionId());
    wm.putString("CreativeId",rewardedInterstitialAd.getCreativeId());
    SendEvent(Event.onAdClosed,wm);
  }

  @Override
  public void onAdClicked(@NonNull RewardedInterstitialAd rewardedInterstitialAd) {
    rewardedInterstitialAd.showAd();
    WritableMap wm = new WritableNativeMap();
    wm.putString("AdSpaceId",rewardedInterstitialAd.getAdSpaceId());
    wm.putString("SessionId",rewardedInterstitialAd.getSessionId());
    wm.putString("CreativeId",rewardedInterstitialAd.getCreativeId());
    SendEvent(Event.onAdClicked,wm);
  }

  @Override
  public void onAdStarted(@NonNull RewardedInterstitialAd rewardedInterstitialAd) {
    rewardedInterstitialAd.showAd();
    WritableMap wm = new WritableNativeMap();
    wm.putString("AdSpaceId",rewardedInterstitialAd.getAdSpaceId());
    wm.putString("SessionId",rewardedInterstitialAd.getSessionId());
    wm.putString("CreativeId",rewardedInterstitialAd.getCreativeId());
    SendEvent(Event.onAdStarted,wm);
  }

  @Override
  public void onAdReward(@NonNull RewardedInterstitialAd rewardedInterstitialAd) {
    rewardedInterstitialAd.showAd();
    WritableMap wm = new WritableNativeMap();
    wm.putString("AdSpaceId",rewardedInterstitialAd.getAdSpaceId());
    wm.putString("SessionId",rewardedInterstitialAd.getSessionId());
    wm.putString("CreativeId",rewardedInterstitialAd.getCreativeId());
    SendEvent(Event.onAdReward,wm);
  }

  @Override
  public void onAdTTLExpired(@NonNull RewardedInterstitialAd rewardedInterstitialAd) {
    rewardedInterstitialAd.showAd();
    WritableMap wm = new WritableNativeMap();
    wm.putString("AdSpaceId",rewardedInterstitialAd.getAdSpaceId());
    wm.putString("SessionId",rewardedInterstitialAd.getSessionId());
    wm.putString("CreativeId",rewardedInterstitialAd.getCreativeId());
    SendEvent(Event.onAdTTLExpired,wm);
  }

  private void SendEvent(Event event, @Nullable WritableMap wm) {
    Log.d(TAG,"send event:" + event.getName());
    mContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class).emit(event.getName(),wm);
  }
}
