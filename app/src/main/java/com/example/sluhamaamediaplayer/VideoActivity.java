package com.example.sluhamaamediaplayer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        VideoView vView = (VideoView)findViewById(R.id.videoView1);
        vView.requestFocus();
        String vSource = "android.resource://com.example.sluhamaamediaplayer/" + R.raw.dove;
        vView.setVideoURI(Uri.parse(vSource));
        vView.setMediaController(new MediaController(this));
        vView.start();
    }

    public void playMusic(View view) {
        Intent intent = new Intent(VideoActivity.this, MusicActivity.class);
        startActivity(intent);
    }
}
