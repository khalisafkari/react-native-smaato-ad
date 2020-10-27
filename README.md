# react-native-smaato-ad


[![Facebook Ads](https://www.smaato.com/wp-content/uploads/2019/11/featured-image-rewarded-video.png)](https://smaato.com)

Monetize Your App With the **Smaato** Publisher Platform
                          Maximize your mobile advertising fill rates and eCPMs.

[![npm version](https://badge.fury.io/js/react-native-smaato-ad.svg)](https://badge.fury.io/js/react-native-smaato-ad)


## Platforms Supported

- [x] Android

_Note: Why isn't the iOS version available? because i don't have mac os_

## Getting Started

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
- [x] [Guide Full](docs/Getting-Started.md)
- [x] [SmaatoAd](docs/Smaato.md)
- [x] [IntertitialAd](docs/intertitials.md)
- [x] [BannerAd](docs/BannerAd.md)
- [x] [RewardAd](docs/Reward.md)
- [ ] [NativeAd](#)


#### [Common issues](https://github.com/khalisafkari/react-native-smaato-ad/issues)

## License

MIT
