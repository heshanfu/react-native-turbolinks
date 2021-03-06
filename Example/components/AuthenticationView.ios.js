import React, { Component } from 'react'
import { NavigatorIOS, WebView } from 'react-native'
import Turbolinks from 'react-native-turbolinks'
import Constants from './Constants';

const signInUrl = Constants.baseUrl + '/sign-in'

export default class AuthenticationView extends Component {

  render() {
    return (
      <NavigatorIOS initialRoute={{component: MyScene, title: 'Sign in'}} style={{flex: 1}}/>
    )
  }
}

class MyScene extends Component {

  handleAuthentication = (e) => {
    if (e.nativeEvent.url == signInUrl) return
    setTimeout(() => Turbolinks.reloadSession(), 800)
    this.webview.stopLoading()
    Turbolinks.dismiss()
  }

  render() {
    return (
        <WebView ref={webview => { this.webview = webview }}
                 source={{uri: signInUrl}}
                 onLoadStart={this.handleAuthentication}/>
    )
  }
}
