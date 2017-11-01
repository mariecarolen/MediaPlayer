package com.example.sluhamaamediaplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MusicActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
    }
    public void onMusicPlay (View view){
        if (mediaPlayer == null)
        mediaPlayer = MediaPlayer.create(this, R.raw.nbhdone);
        mediaPlayer.start();
    }
    public void onMusicPause (View view){
        mediaPlayer.pause();
    }
    public void onMusicStop (View view){
        mediaPlayer.stop();
        mediaPlayer = null;
    }
}
