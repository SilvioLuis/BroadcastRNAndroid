import React, { Component } from 'react';

import { 
  View, 
  Text, 
  DeviceEventEmitter 
} from 'react-native';

export default class Main extends Component {
  
  componentDidMount () {
      this.subscription = DeviceEventEmitter.addListener('broadcastNative', this.shutDownAction);
  }

  shutDownAction (e) {
    alert(JSON.stringify(e));
  }
  
  render() {
    return (
      <View style={{
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center'
      }}>
        <Text>Teste</Text>
      </View>
    );
  }
}
