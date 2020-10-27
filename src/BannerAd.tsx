import React from 'react';
import { requireNativeComponent, StyleProp, ViewStyle } from 'react-native';

type bannerSize =
  | 'SKYSCRAPER_120x600'
  | 'LEADERBOARD_728x90'
  | 'MEDIUM_RECTANGLE_300x250'
  | 'XX_LARGE_320x50';
//
// type adreload =
//   | 'DISABLED'
//   | 'DEFAULT'
//   | 'VERY_SHORT'
//   | 'SHORT'
//   | 'NORMAL'
//   | 'LONG'
//   | 'VERY_LONG';

interface props {
  adID: string;
  adsize?: bannerSize;
  // adReload: adreload;
  lat?: number;
  long?: number;
  style?: StyleProp<ViewStyle>;
  onAdLoaded?: Function;
  onAdFailedToLoad?: Function;
  onAdImpression?: Function;
  onAdClicked?: Function;
  onAdTTLExpired?: Function;
}

const BannerAd = React.forwardRef((props: props, ref: any) => (
  <UILayer {...props} ref={ref} />
));

const UILayer = requireNativeComponent<props>('RNBannerSmaato');

export default BannerAd;
