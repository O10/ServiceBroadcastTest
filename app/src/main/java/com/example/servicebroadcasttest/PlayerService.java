package com.example.servicebroadcasttest;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by O10 on 19.11.2015.
 */
public class PlayerService extends Service {
    public final static String SERVICE_DEBUG="serv_deb";

    private MediaPlayer mediaPlayer;
    private IBinder serviceBinder;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(SERVICE_DEBUG, "onCreate called");

        serviceBinder=new ServiceBinder();

        mediaPlayer = MediaPlayer.create(this, R.raw.vivaldi);
        mediaPlayer.setLooping(true); // Set looping
        mediaPlayer.setVolume(100, 100);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(SERVICE_DEBUG,"onStartCommand called");
        mediaPlayer.seekTo(0);
        mediaPlayer.prepareAsync();
        mediaPlayer.start();

        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(SERVICE_DEBUG,"onDestroy called");
        mediaPlayer.stop();
        mediaPlayer.release();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return serviceBinder;
    }

    class ServiceBinder extends Binder{
        //TODO implementacjabindera
    }


}
