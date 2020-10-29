package com.reactnativesmaatoad

import java.util.Arrays

import com.facebook.react.ReactPackage
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.ViewManager

class SmaatoAdPackage : ReactPackage {
    override fun createNativeModules(reactContext: ReactApplicationContext): List<NativeModule> {
        return Arrays.asList<NativeModule>(
          InitializeModule(reactContext),
          IntertitialAdModule(reactContext),
          RewardAdModule(reactContext)
        )
    }

    override fun createViewManagers(reactContext: ReactApplicationContext): List<ViewManager<*, *>> {
//        return emptyList<ViewManager<*, *>>()
      return mutableListOf(
//        BannerViewManager(),
        BannerManager()
      )
    }
}
