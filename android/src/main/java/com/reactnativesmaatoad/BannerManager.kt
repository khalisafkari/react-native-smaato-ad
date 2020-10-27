package com.reactnativesmaatoad

import android.R.string
import com.facebook.react.common.MapBuilder
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.ViewGroupManager
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.uimanager.annotations.ReactPropGroup


class BannerManager:ViewGroupManager<BannerAd>() {

  override fun createViewInstance(reactContext: ThemedReactContext): BannerAd {
    return BannerAd(reactContext);
  }

  override fun getName() = "RNBannerSmaato";

  @ReactProp(name = "adID")
  fun setAdUnit(view: BannerAd,adID: String ) {
    view.setAdId(adID);
  }

  @ReactProp(name="lat")
  fun setLat(view: BannerAd, lat: Double) {
      view.setLat(lat)
  }

  @ReactProp(name="long")
  fun setLong(view: BannerAd, long: Double) {
       view.setLong(long)
  }


  @ReactProp(name = "adsize")
  fun setSize(view: BannerAd, size: String) {
     when(size) {
       "MEDIUM_RECTANGLE_300x250" -> view.setAdSize("MEDIUM_RECTANGLE_300x250")
       "LEADERBOARD_728x90" -> view.setAdId("LEADERBOARD_728x90")
       "SKYSCRAPER_120x600" -> view.setAdId("SKYSCRAPER_120x600")
       else -> view.setAdId("XX_LARGE_320x50")
     }
  }

  override fun getExportedCustomDirectEventTypeConstants(): MutableMap<String, Any> {
    return MapBuilder.of(
      "onAdLoaded",MapBuilder.of("registrationName","onAdLoaded"),
      "onAdFailedToLoad",MapBuilder.of("registrationName","onAdFailedToLoad"),
      "onAdImpression",MapBuilder.of("registrationName","onAdImpression"),
      "onAdClicked",MapBuilder.of("registrationName","onAdClicked"),
      "onAdTTLExpired",MapBuilder.of("registrationName","onAdTTLExpired")
    )
  }
}
