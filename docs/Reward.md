```typescript
    import{ RewardSmaato } from 'react-native-smaato-ad';
    RewardSmaato.showAd('130626426');
```

```typescript
    interface RewardSmaatoType {
        showAd(adid:string): void;
    }
```

```typescript
    enum EventRewardType {
      onAdLoaded,
      onAdFailedToLoad,
      onAdError,
      onAdStarted,
      onAdClosed,
      onAdClicked,
      onAdReward,
      onAdTTLExpired,
    }
```

```typescript
   //events
   import{ RewardSmaatoEvent,EventReward } from 'react-native-smaato-ad';

   RewardSmaatoEvent.addListener(EventReward.onAdLoaded,(event:any) => {
     console.log(event)
   })
```

