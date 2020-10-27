package com.reactnativesmaatoad;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.reactnativesmaatoad.view.Constants;
import com.smaato.sdk.core.Gender;
import com.smaato.sdk.core.LatLng;
import com.smaato.sdk.core.SmaatoSdk;

public class InitializeModule extends ReactContextBaseJavaModule {

  private static final String TAG = Constants.TAG;
  private ReactApplicationContext mContext;

  @NonNull
  @Override
  public String getName() {
    return Constants.Initialize;
  }

  InitializeModule(@Nullable ReactApplicationContext reactApplicationContext) {
    super(reactApplicationContext);
    mContext = reactApplicationContext;
  }

  @ReactMethod
  public void init(String id) {
    Application app = (Application) mContext.getApplicationContext();
    SmaatoSdk.init(app,id);
  }

  @ReactMethod
  public void getVersion(Promise promise) {
    promise.resolve(SmaatoSdk.getVersion());
  }

  @ReactMethod
  public void getKeywords(Promise promise) {
    promise.resolve(SmaatoSdk.getKeywords());
  }

  @ReactMethod
  public void setKeywords(String keywords,Promise promise) {
      SmaatoSdk.setKeywords(keywords);
      promise.resolve(SmaatoSdk.getKeywords());
  }

  @ReactMethod
  public void getSearchQuery(Promise promise) {
    promise.resolve(SmaatoSdk.getSearchQuery());
  }

  @ReactMethod
  public void setSearchQuery(String searchQuery,Promise promise) {
      SmaatoSdk.setSearchQuery(searchQuery);
      promise.resolve(SmaatoSdk.getSearchQuery());
  }

  @ReactMethod
  public void getGender(Promise promise) {
    promise.resolve(SmaatoSdk.getGender());
  }

  @ReactMethod
  public void setGender(String gender,Promise promise) {
    Gender gender1 = null;
    switch (gender) {
      case "FEMALE" :
        gender1 = Gender.FEMALE;
        break;
      case "MALE":
        gender1 = Gender.MALE;
        break;
      case "OTHER":
        gender1 = Gender.OTHER;
        break;
      default:
        break;
    }
    SmaatoSdk.setGender(gender1);
    promise.resolve(SmaatoSdk.getGender());
  }

  @ReactMethod
  public void getAge(Promise promise) {
      promise.resolve(SmaatoSdk.getAge());
  }

  @ReactMethod
  public void setAge(Integer age,Promise promise) {
    SmaatoSdk.setAge(age);
    promise.resolve(SmaatoSdk.getAge());
  }

  @ReactMethod
  public void getLatLng(Promise promise) {
    promise.resolve(SmaatoSdk.getLatLng().toString());
  }

  @ReactMethod
  public void setLatLng(double latitude, double longitude, float accuracy, Promise promise) {
      LatLng latLng = new LatLng(latitude,longitude,accuracy,0);
      SmaatoSdk.setLatLng(latLng);
      promise.resolve(SmaatoSdk.getLatLng().toString());
  }

  @ReactMethod
  public void isGPSEnabled(Promise promise) {
    promise.resolve(SmaatoSdk.isGPSEnabled());
  }

  @ReactMethod
  public void setGPSEnabled(boolean gpsEnabled,Promise promise) {
    SmaatoSdk.setGPSEnabled(gpsEnabled);
    promise.resolve(SmaatoSdk.isGPSEnabled());
  }

  @ReactMethod
  public void getPublisherId(Promise promise) {
    promise.resolve(SmaatoSdk.getPublisherId());
  }

  @ReactMethod
  public void getRegion(Promise promise) {
    promise.resolve(SmaatoSdk.getRegion());
  }

  @ReactMethod
  public void setRegion(String region,Promise promise) {
    SmaatoSdk.setRegion(region);
    promise.resolve(SmaatoSdk.getRegion());
  }

  @ReactMethod
  public void getZip(Promise promise) {
    promise.resolve(SmaatoSdk.getZip());
  }

  @ReactMethod
  public void setZip(String zip,Promise promise) {
    SmaatoSdk.setZip(zip);
    promise.resolve(SmaatoSdk.getZip());
  }

  @ReactMethod
  public void getLanguage(Promise promise) {
    promise.resolve(SmaatoSdk.getLanguage());
  }

  @ReactMethod
  public void setLanguage(String  language,Promise promise) {
    SmaatoSdk.setLanguage(language);
    promise.resolve(SmaatoSdk.getLanguage());
  }

  @ReactMethod
  public void getCoppa(Promise promise) {
    promise.resolve(SmaatoSdk.getCoppa());
  }

  @ReactMethod
  public void setCoppa(boolean coppa,Promise promise) {
    SmaatoSdk.setCoppa(coppa);
    promise.resolve(SmaatoSdk.getCoppa());
  }

  @ReactMethod
  public void isWatermarkEnabled(Promise promise) {
    promise.resolve(SmaatoSdk.isWatermarkEnabled());
  }

  @ReactMethod
  public void setWatermarkEnabled(boolean watermarkEnabled,Promise promise) {
    SmaatoSdk.setWatermarkEnabled(watermarkEnabled);
    promise.resolve(SmaatoSdk.isWatermarkEnabled());
  }

  @ReactMethod
  public void getUsPrivacyString(Promise promise) {
    promise.resolve(SmaatoSdk.getUsPrivacyString());
  }

  @ReactMethod
  public void isCompanionAdSkippable(Promise promise) {
    promise.resolve(SmaatoSdk.isCompanionAdSkippable());
  }

  @ReactMethod
  public void setIsCompanionAdSkippable(boolean skippable,Promise promise) {
      SmaatoSdk.setIsCompanionAdSkippable(skippable);
      promise.resolve(SmaatoSdk.isCompanionAdSkippable());
  }

  @ReactMethod
  public void getAdContentRating(Promise promise) {
    promise.resolve(SmaatoSdk.getAdContentRating());
  }

}
