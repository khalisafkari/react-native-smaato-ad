package com.reactnativesmaatoad.view;

public enum BannerEvents {
  AD_LOADED("onAdLoaded"),
  AD_FAILED("onAdFailedToLoad"),
  AD_IMPRESSION("onAdImpression"),
  AD_CLICKED("onAdClicked"),
  AD_TTL("onAdTTLExpired");

  private String name;

  BannerEvents(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
