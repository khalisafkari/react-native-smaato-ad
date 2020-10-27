```typescript
    import{ IntertitialSmaato } from 'react-native-smaato-ad';
    IntertitialSmaato.showAd('130626426');
```

```typescript
    interface IntertitialType {
        showAd(adid:string): void;
    }
```

```typescript
    enum EventIntertitialType {
        onAdLoaded,
        onAdFailedToLoad,
        onAdError,
        onAdOpened,
        onAdClosed,
        onAdClicked,
        onAdImpression,
        onAdTTLExpired
    }
```

```typescript
   //events
   import{ IntertitialSmaatoEvent,EventIntertitial } from 'react-native-smaato-ad';

   IntertitialSmaatoEvent.addListener(EventIntertitial.onAdLoaded,(event:any) => {
     console.log(event)
   })
```

