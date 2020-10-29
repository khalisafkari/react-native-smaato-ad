package com.reactnativesmaatoad;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.react.views.view.ReactViewGroup;
import com.smaato.sdk.banner.ad.BannerAdSize;
import com.smaato.sdk.banner.widget.BannerError;
import com.smaato.sdk.banner.widget.BannerView;
import com.smaato.sdk.core.LatLng;
import com.smaato.sdk.core.SmaatoSdk;

public class BannerAd extends ReactViewGroup {

  private static String TAG = "GGADS";
  private BannerAdSize AdSize = BannerAdSize.XX_LARGE_320x50;
  private String AdId = "130626424";
  private double lat = 0.0;
  private double lon = 0.0;
  private float acc = 0;
  private long time = 0;

  private final Runnable measureRunnable = () -> {
    for (int i = 0;i < getChildCount();i++) {
      View child = getChildAt(i);
      child.measure(
        MeasureSpec.makeMeasureSpec(getMeasuredWidth(),MeasureSpec.EXACTLY),
        MeasureSpec.makeMeasureSpec(getMeasuredHeight(),MeasureSpec.EXACTLY)
      );
      child.layout(0,0,child.getMeasuredWidth(),child.getMeasuredHeight());
    }
  };

  public BannerAd(Context context) {
    super(context);
  }

  private void attachNewAdView() {
      final BannerView bannerView = new BannerView(getContext());
      BannerView oldView = (BannerView) getChildAt(0);

      if (oldView != null) {
        oldView.destroy();
      }

      addView(bannerView);
      setupAd();
  }

  private void setupAd() {
      final BannerView bannerView = (BannerView) getChildAt(0);
      //SmaatoSdk.setLatLng(new LatLng(-31.083332,150.916672,0,0));
      SmaatoSdk.setLatLng(new LatLng(lat,lon,acc,time));
      bannerView.loadAd(AdId,AdSize);
      bannerView.setEventListener(eventListener);
  }

  BannerView.EventListener eventListener = new BannerView.EventListener() {
    @Override
    public void onAdLoaded(@NonNull BannerView bannerView) {
        WritableMap map = Arguments.createMap();
        map.putInt("height",bannerView.getBannerAdSize().adDimension.getHeight());
        map.putInt("width", bannerView.getBannerAdSize().adDimension.getWidth());
        map.putDouble("aspectRatio",(float) bannerView.getBannerAdSize().adDimension.getAspectRatio());
        map.putString("sessionId",bannerView.getSessionId());
        map.putString("creativeId",bannerView.getCreativeId());
        map.putInt("autoReloadTime",bannerView.getAutoReloadInterval().getSeconds());
        map.putDouble("latitude",SmaatoSdk.getLatLng().getLatitude());
        map.putDouble("longitude",SmaatoSdk.getLatLng().getLongitude());
        map.putDouble("accuracy",SmaatoSdk.getLatLng().getLocationAccuracy());
        map.putDouble("timestamp",SmaatoSdk.getLatLng().getLocationTimestamp());
        getEmitter().receiveEvent(getId(),"onAdLoaded",map);
    }

    @Override
    public void onAdFailedToLoad(@NonNull BannerView bannerView, @NonNull BannerError bannerError) {
      WritableMap map = Arguments.createMap();
      map.putString("error",bannerError.toString());
      getEmitter().receiveEvent(getId(),"onAdFailedToLoad",map);
    }

    @Override
    public void onAdImpression(@NonNull BannerView bannerView) {
      getEmitter().receiveEvent(getId(),"onAdImpression",null);
    }

    @Override
    public void onAdClicked(@NonNull BannerView bannerView) {
      getEmitter().receiveEvent(getId(),"onAdClicked",null);
    }

    @Override
    public void onAdTTLExpired(@NonNull BannerView bannerView) {
      getEmitter().receiveEvent(getId(),"onAdTTLExpired",null);
    }
  };

  public void setAdId(String a) {
    if (AdId != null && a != null) {
      AdId = a;
    }
    attachNewAdView();
  }

  public void setLat(double l) {
      lat = l;
      attachNewAdView();
  }

   public void setLong(double l) {
      lon = l;
      attachNewAdView();
   }


  public void setAdSize(String index) {
    switch (index) {
      case "MEDIUM_RECTANGLE_300x250":
        AdSize = BannerAdSize.MEDIUM_RECTANGLE_300x250;
        break;
      case "LEADERBOARD_728x90":
        AdSize = BannerAdSize.LEADERBOARD_728x90;
        break;
      case "SKYSCRAPER_120x600":
        AdSize = BannerAdSize.SKYSCRAPER_120x600;
        break;
      default:
        AdSize = BannerAdSize.XX_LARGE_320x50;
    }
    attachNewAdView();
  }

  private RCTEventEmitter getEmitter() {
    ReactContext context = (ReactContext) getContext();
    return context.getJSModule(RCTEventEmitter.class);
  }

  @Override
  public void requestLayout() {
    super.requestLayout();
    post(measureRunnable);
  }
}
