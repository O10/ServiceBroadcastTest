package com.example.servicebroadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by O10 on 19.11.2015.
 */
public class TestBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("receiver","onReceive gets called");
        context.startService(new Intent(context, PlayerService.class));
    }
}
