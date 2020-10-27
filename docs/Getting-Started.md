# React Native Smaato Next Ads Getting Started Guide

Here's how to get started quickly with the  React Native Smaato Next Ads.

#### 1. Add react-native-smaato-ad to your dependencies

```
$ yarn add react-native-smaato-ad
```
 (or)

 For npm use
```
$ npm install --save react-native-smaato-ad
```

#### 2. Link native dependencies

From react-native 0.60 autolinking will take care of the link.

React Native modules that include nativeJava, or Kotlin code have to be "linked" so that the compiler knows to include them in the app.

```
$ react-native link react-native-smaato-ad
```

Android -
Please make sure AndroidX is enabled in your project by editting `android/gradle.properties` and adding 2 lines:


```
android.useAndroidX=true
android.enableJetifier=true
```

```
   # /android/app/build.gradle

    implementation 'com.smaato.android.sdk:smaato-sdk:21.5.2'
    implementation 'com.smaato.android.sdk:smaato-sdk-banner:21.5.2'
    implementation 'com.smaato.android.sdk:smaato-sdk-interstitial:21.5.2'
    implementation 'com.smaato.android.sdk:smaato-sdk-rewarded-ads:21.5.2'

```

```
 # /android/build.gradle

    allprojects {
        repositories {
            ...
            maven {
                url "https://s3.amazonaws.com/smaato-sdk-releases/"
            }
            ...
        }
    }

```


```javascript
    // index.js
    import SmaatoAd from 'react-native-smaato-ad'
    SmaatoAd.init('<YOUR ID PUBLISHER>')
```




#### 3. api docs
- [x] [SmaatoAd](Smaato.md)
- [x] [IntertitialAd](intertitials.md)
- [x] [BannerAd](BannerAd.md)
- [x] [RewardAd](Reward.md)
- [ ] [NativeAd](#)
