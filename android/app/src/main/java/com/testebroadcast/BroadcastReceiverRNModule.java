package com.testebroadcast;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import android.content.Intent;
import java.util.Map;
import java.util.HashMap;
import android.util.Log;

public class BroadcastReceiverRNModule extends ReactContextBaseJavaModule  {
    private static ReactApplicationContext reactContext;
    private static final String TAG = "JAVA_MODULE";

    public BroadcastReceiverRNModule (ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    public static void sendEvent(String eventName, Intent intent) {

        WritableMap params = Arguments.createMap();
        params.putString("action", intent.getAction());
        params.putString("teste", "teste");
        
        Log.d(TAG, intent.getAction());

        reactContext
            .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
            .emit(eventName, params);
    }

    @Override
    public String getName() {
        return "BroadcastReceiverRNModule";
    }
}