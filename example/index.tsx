import { AppRegistry } from 'react-native';
import App from './src/App';
import { name as appName } from './app.json';
import SmaatoAd from 'react-native-smaato-ad';
SmaatoAd.init('1100044945');

AppRegistry.registerComponent(appName, () => App);
