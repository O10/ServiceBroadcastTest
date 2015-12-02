package com.example.servicebroadcasttest;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;


//TODO stop button
//TODO Receiver
//TODO IntentService vs zwykły
//TODO //TODO wydzielony wątek dla metody prepare

public class MainActivity extends AppCompatActivity {
    private Button startButton;
    private Button stopButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton= (Button) findViewById(R.id.start_button);
        stopButton=(Button) findViewById(R.id.stop_button);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startMusicService();
            }
        });
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopMusicService();
            }
        });
    }

    private void startMusicService(){
        Intent intent=new Intent(this,PlayerIntentService.class);
        startService(intent);
    }

    //TODO stop music service
    private void stopMusicService(){

    }


}
