package com.example.sluhamaamediaplayer;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    TextView txt1, txt2;
    CheckBox checkBox;
    ToggleButton toggleButton;
    Button watchVideo;
    RadioButton radioBtn;
    MediaPlayer mediaPlayer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1 = (TextView) findViewById(R.id.textView1);
        txt2 = (TextView) findViewById(R.id.textView2);
        checkBox = (CheckBox)findViewById(R.id.checkBox1);
        toggleButton = (ToggleButton)findViewById(R.id.toggleButton1);
        radioBtn = (RadioButton)findViewById(R.id.radioButton);
        watchVideo = (Button)findViewById(R.id.watchVideo);
        watchVideo.setEnabled(false);

        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(this, R.raw.nbhdtwo);
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();

        CompoundButton.OnCheckedChangeListener checker = new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton checkBox, boolean isChecked) {
                if (checkBox.isChecked()){
                    watchVideo.setEnabled(true);
                }
                else if (watchVideo.isEnabled()){
                    watchVideo.setEnabled(false);
                }
            }
        };
        checkBox.setOnCheckedChangeListener(checker);
        watchVideo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, VideoActivity.class);
                startActivity(intent);
                mediaPlayer.stop();
            }
        });

    }
    public void onToggle(View view) {
        if (toggleButton.isChecked()){
            mediaPlayer.stop();
            txt1.setText("Music is off.");
        }else
            txt1.setText("No Music.");
    }
    public void onRadio(View view){
        if (radioBtn.isChecked())
            txt2.setText("You pushed the button.");
        else;
    }
}
