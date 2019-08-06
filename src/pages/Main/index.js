import React, { Component } from 'react';

import { 
  	View, 
	Text, 
	TouchableOpacity,
  	DeviceEventEmitter
} from 'react-native';

export default class Main extends Component {
  
  	componentDidMount () {
	  	this.subscription = DeviceEventEmitter.addListener('broadcastNative', this.shutDownAction);
  	}

  	shutDownAction (e) {
		console.log(e);
		alert(JSON.stringify(e));
  	}
  
  	render() {
		return (
			<View style={{
				flex: 1,
				justifyContent: 'center',
				alignItems: 'center'
			}}>
				<TouchableOpacity
					onPress={() => {
						//alert('hey!');
						console.log('APERTOU O BOTÃO');
					}}
				>
					<Text>Teste</Text>
				</TouchableOpacity>
				
			</View>
		);
  	}
}
