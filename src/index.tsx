import { NativeModules, NativeEventEmitter } from 'react-native';
export { default as BannerAd } from './BannerAd';
const { RNInitialize, RNRewardSmaato, RNIntertitialSmaato } = NativeModules;

type Gender = 'FEMALE' | 'MALE' | 'OTHER';
type SmaatoAdInit = {
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
};
const Smaato = RNInitialize;
type IR = {
  showAd(a: string): void;
};
export const RewardSmaato = RNRewardSmaato as IR;
export const IntertitialSmaato = RNIntertitialSmaato as IR;
export const IntertitialSmaatoEvent = new NativeEventEmitter(
  RNIntertitialSmaato
);
export const RewardSmaatoEvent = new NativeEventEmitter(RNRewardSmaato);
export const EventIntertitial = {
  onAdLoaded: 'onAdLoaded',
  onAdFailedToLoad: 'onAdFailedToLoad',
  onAdError: 'onAdError',
  onAdOpened: 'onAdOpened',
  onAdClosed: 'onAdClosed',
  onAdClicked: 'onAdClicked',
  onAdImpression: 'onAdImpression',
  onAdTTLExpired: 'onAdTTLExpired',
};
export const EventReward = {
  onAdLoaded: 'onAdLoaded',
  onAdFailedToLoad: 'onAdFailedToLoad',
  onAdError: 'onAdError',
  onAdStarted: 'onAdStarted',
  onAdClosed: 'onAdClosed',
  onAdClicked: 'onAdClicked',
  onAdReward: 'onAdReward',
  onAdTTLExpired: 'onAdTTLExpired',
};

export default Smaato as SmaatoAdInit;
