```javascript
    import React from 'react';
    import { BannerAd } from 'react-native-smaato-ad';

    export default () => {
        return (
              <BannerAd
                style={{ height: 250,width: 300}}
                adID={'130626424'}
                adsize={'MEDIUM_RECTANGLE_300x250'}
              />
        )
    }
```


```typescript
type bannerSize =
  | 'SKYSCRAPER_120x600'
  | 'LEADERBOARD_728x90'
  | 'MEDIUM_RECTANGLE_300x250'
  | 'XX_LARGE_320x50';

interface props {
  adID: string;
  adsize?: bannerSize;
  lat?: number;
  long?: number;
  style?: StyleProp<ViewStyle>;
  onAdLoaded?: Function;  //onAdLoaded={(e: any) => {console.log(e.nativeEvent)}}log get dimensions & details of ads
  onAdFailedToLoad?: Function;
  onAdImpression?: Function;
  onAdClicked?: Function;
  onAdTTLExpired?: Function;
}
```


