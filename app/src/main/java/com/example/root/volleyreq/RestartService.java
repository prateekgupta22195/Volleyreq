package com.example.root.volleyreq;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by root on 1/5/17.
 */

public class RestartService extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("broad", "received");
            context.startService(new Intent(context, Myservice.class));

        Log.i("broad", "after try catch");

    }
}
