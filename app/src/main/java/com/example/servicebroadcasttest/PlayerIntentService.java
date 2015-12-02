package com.example.servicebroadcasttest;

import android.app.IntentService;
import android.content.Intent;
import android.media.MediaPlayer;
import android.util.Log;

/**
 * Created by O10 on 19.11.2015.
 */
public class PlayerIntentService extends IntentService {
    private final static String INTENT_DEBUG = "int_deb";
    private MediaPlayer mediaPlayer;

    public PlayerIntentService() {
        super("PlayerIntentService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(INTENT_DEBUG, "onCreate gets called");
        mediaPlayer = MediaPlayer.create(this, R.raw.vivaldi);
        mediaPlayer.setLooping(true); // Set looping
        mediaPlayer.setVolume(100, 100);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(INTENT_DEBUG, "onHanldeIntent gets called");
        mediaPlayer.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(INTENT_DEBUG, "onDestroy gets called");
        mediaPlayer.stop();
        mediaPlayer.release();
    }
}
