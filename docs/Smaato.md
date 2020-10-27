```typescript
    import SmaatoAd from 'react-native-smaato-ad';

    //example
    SmaatoAd.init('<YOUR ID PUBLISHER>');
    SmaatoAd.getVersion().then((version) => {
        console.log(version)
    })
```
```typescript
    interface SmaatoAdType  {
      init(a: string): void;
      getVersion(): Promise<string>;
      getKeywords(): Promise<string>;
      setKeywords(a: string): Promise<string>;
      getSearchQuery(): Promise<string>;
      setSearchQuery(a: string): Promise<string>;
      getGender(): Promise<any>;
      setGender(a: Gender): Promise<any>;
      getAge(): Promise<number>;
      setAge(a: number): Promise<number>;
      getLatLng(): Promise<any>;
      setLatLng(
        latitude?: number | any,
        longitude?: number | any,
        accuracy?: number | any,
        time?: string | any
      ): Promise<any>;
      isGPSEnabled(): Promise<any>;
      setGPSEnabled(a: boolean): Promise<any>;
      getPublisherId(): Promise<any>;
      getRegion(): Promise<any>;
      setRegion(a: string): Promise<any>;
      getZip(): Promise<any>;
      setZip(zip: string): Promise<any>;
      getLanguage(): Promise<any>;
      setLanguage(lang: string): Promise<any>;
      getCoppa(): Promise<any>;
      setCoppa(a: boolean): Promise<any>;
      isWatermarkEnabled(): Promise<any>;
      setWatermarkEnabled(a: boolean): Promise<any>;
      getUsPrivacyString(): Promise<any>;
      isCompanionAdSkippable(): Promise<any>;
      setIsCompanionAdSkippable(skip: boolean): Promise<any>;
      getAdContentRating(): Promise<any>;
    };
```
