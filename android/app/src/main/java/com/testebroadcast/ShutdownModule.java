package com.testebroadcast;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import android.content.Intent;
import java.util.Map;
import java.util.HashMap;
import android.util.Log;

public class ShutdownModule extends ReactContextBaseJavaModule  {
    private static ReactApplicationContext reactContext;
    private static final String TAG = "JAVA_MODULE";

    public ShutdownModule (ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    public static void sendEvent(String eventName, Intent intent) {

        WritableMap params = Arguments.createMap();
        params.put("action", intent.getAction());
        params.put("teste", "teste");
        
        Log.d(TAG, intent.getAction());

        reactContext
            .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
            .emit(eventName, params);
    }

    @Override
    public String getName() {
        return "ShutdownModule";
    }
}