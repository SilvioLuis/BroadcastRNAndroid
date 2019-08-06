package com.testebroadcast;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.BroadcastReceiver;
import com.testebroadcast.BroadcastReceiverRNPackage;
import com.testebroadcast.BroadcastReceiverRNModule;
import com.testebroadcast.BroadcastRNReceiver;
import com.facebook.react.ReactApplication;
import com.swmansion.gesturehandler.react.RNGestureHandlerPackage;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;

import java.util.Arrays;
import java.util.List;
import android.util.Log;

public class MainApplication extends Application implements ReactApplication {

	BroadcastReceiver defaultReceiver = new BroadcastRNReceiver();

	private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
		@Override
		public boolean getUseDeveloperSupport() {
			return BuildConfig.DEBUG;
		}

		@Override
		protected List<ReactPackage> getPackages() {
			return Arrays.<ReactPackage>asList(
				new MainReactPackage(),
				new RNGestureHandlerPackage(),
				new BroadcastReceiverRNPackage()
			);
		}

		@Override
		protected String getJSMainModuleName() {
			return "index";
		}
	};

	@Override
	public ReactNativeHost getReactNativeHost() {
		return mReactNativeHost;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		registerReceiver(defaultReceiver, new IntentFilter(Intent.ACTION_SCREEN_ON));
		registerReceiver(defaultReceiver, new IntentFilter(Intent.ACTION_SCREEN_OFF));
		SoLoader.init(this, /* native exopackage */ false);
	}
}
