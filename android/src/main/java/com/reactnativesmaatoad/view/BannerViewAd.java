package com.reactnativesmaatoad.view;

import android.content.Context;
import android.util.Log;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.smaato.sdk.banner.ad.AutoReloadInterval;
import com.smaato.sdk.banner.ad.BannerAdSize;
import com.smaato.sdk.banner.widget.BannerError;
import com.smaato.sdk.banner.widget.BannerView;

public class BannerViewAd extends LinearLayout {

  private static final String TAG = Constants.TAG;
  private ReactContext mReactContext;
  private String mAdId = "130626424";
  private BannerAdSize mBannerAdSize = BannerAdSize.XX_LARGE_320x50;
  private AutoReloadInterval mreloadInterval = AutoReloadInterval.DEFAULT;


  private final Runnable measureAndLayout = () -> {
    measure(
      MeasureSpec.makeMeasureSpec(getWidth(), MeasureSpec.EXACTLY),
      MeasureSpec.makeMeasureSpec(getHeight(), MeasureSpec.EXACTLY));
    layout(getLeft(), getTop(), getRight(), getBottom());
  };


  public BannerViewAd(final Context context) {
    super(context);
    if (context instanceof ReactContext) {
      mReactContext = (ReactContext) context;
    }
    attachNewAdView();
  }

  public void setAdId(String adId) {
    mAdId = adId;
    attachNewAdView();
  }

  public void setBannerAdSize(String bannerAdSize) {
    mBannerAdSize = Constants.getBannerSize(bannerAdSize);
    attachNewAdView();
  }

  public void setReloadVoid(String reloadVoid) {
    mreloadInterval = Constants.getReloadInterval(reloadVoid);
    attachNewAdView();
  }

  private void attachNewAdView() {
    final BannerView bannerView = new BannerView(getContext());
    BannerView oldView = (BannerView) getChildAt(0);
    removeAllViews();
    if (oldView != null) {
      oldView.destroy();
    }
    this.addView(bannerView);
    setupAd();
  }

  private void setupAd() {
    final BannerView bannerView = (BannerView) getChildAt(0);
    bannerView.loadAd(mAdId,mBannerAdSize);
    bannerView.setAutoReloadInterval(mreloadInterval);
    bannerView.setEventListener(new BannerView.EventListener() {
      @Override
      public void onAdLoaded(@NonNull BannerView bannerView) {
        int top = bannerView.getTop();
        int left = bannerView.getLeft();
        int height = mBannerAdSize.adDimension.getHeight();
        int width = mBannerAdSize.adDimension.getWidth();
        bannerView.measure(width, height);
        bannerView.layout(left, top, left + width, top + height);
        WritableMap wm = new WritableNativeMap();
        wm.putString("adId",bannerView.getAdSpaceId());
        wm.putString("BannerSize", String.valueOf(bannerView.getBannerAdSize()));
        sendEvent(BannerEvents.AD_LOADED,wm);
      }

      @Override
      public void onAdFailedToLoad(@NonNull BannerView bannerView, @NonNull BannerError bannerError) {
        Log.d(TAG,"onAdFailedToLoad");
        WritableMap wm = new WritableNativeMap();
        wm.putString("errorMessage",bannerError.toString());
        sendEvent(BannerEvents.AD_FAILED,wm);
      }

      @Override
      public void onAdImpression(@NonNull BannerView bannerView) {
        Log.d(TAG,"onAdImpression");
        sendEvent(BannerEvents.AD_IMPRESSION,null);
      }

      @Override
      public void onAdClicked(@NonNull BannerView bannerView) {
        Log.d(TAG,"onAdClicked");
        sendEvent(BannerEvents.AD_CLICKED,null);
      }

      @Override
      public void onAdTTLExpired(@NonNull BannerView bannerView) {
        Log.d(TAG,"onAdTTLExpired");
        sendEvent(BannerEvents.AD_TTL,null);
      }
    });
    Log.i(TAG, "AdListener object is created");
    Log.i(TAG, "setAdListener() is called");
    Log.i(TAG, String.valueOf(bannerView.getAutoReloadInterval()));
    this.requestLayout();
  }

  private void sendEvent(BannerEvents events, @Nullable WritableMap wm) {
    Log.i(TAG,"Sending event:" + events.getName());
    ReactContext reactContext = (ReactContext) mReactContext;
    reactContext.getJSModule(RCTEventEmitter.class).receiveEvent(getId(),events.getName(),wm);
  }

  public void loadAd() {
    attachNewAdView();
    Log.i(TAG,"loadAd");
  }

  public void destroy() {
    BannerView bannerView = (BannerView) getChildAt(0);
    bannerView.destroy();
    Log.i(TAG,"destroy");
  }


  @Override
  public void requestLayout() {
    super.requestLayout();
    post(measureAndLayout);
  }
}
