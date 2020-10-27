import * as React from 'react';
import { Button, StyleSheet, Text, View } from 'react-native';
import { useCallback } from 'react';
import SDK, {
  IntertitialSmaato,
  RewardSmaato,
  BannerAd,
} from 'react-native-smaato-ad';

export default function App() {
  React.useEffect(() => {
    SDK.init('1100044945');
  }, []);

  const showAdIntertital = useCallback(() => {
    IntertitialSmaato.showAd('130626426');
  }, []);
  const showAdRewards = useCallback(() => {
    RewardSmaato.showAd('130626428');
  }, []);

  return (
    <View style={styles.container}>
      <Text>khalis</Text>
      <Button title={'ad Intertitial'} onPress={showAdIntertital} />
      <Button title={'ad rewardAd'} onPress={showAdRewards} />
      <BannerAd
        adID={'130897362'}
        onAdLoaded={(e: any) => {
          console.log(e.nativeEvent);
        }}
        onAdFailedToLoad={(e: any) => {
          console.log(e.nativeEvent);
        }}
        adsize={'XX_LARGE_320x50'}
        lat={-31.083332}
        long={150.916672}
        style={{ height: 50, width: 320, aspectRatio: 6.4 }}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
});
