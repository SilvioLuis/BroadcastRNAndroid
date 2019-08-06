package com.testebroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.testebroadcast.BroadcastReceiverRNModule;
import java.util.Map;
import java.util.HashMap;
import android.util.Log;

public class BroadcastRNReceiver extends BroadcastReceiver {

    private static final String TAG = "JAVA_RECEIVER";

    @Override
    public void onReceive(Context context, Intent intent) {
        //HashMap<String, String> params = new HashMap<>();
        //params.put("action", intent.getAction());
        //params.put("teste", "teste");
       // String content = params.toString();
        
        Log.d(TAG, intent.getAction());        
        BroadcastReceiverRNModule.sendEvent("broadcastNative", intent);
    }
}
