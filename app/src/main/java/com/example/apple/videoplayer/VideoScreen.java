package com.example.apple.videoplayer;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;

import com.example.apple.videoplayer.ExoPlayer.ExoPlayerBuildSource;
import com.example.apple.videoplayer.ExoPlayer.ExoPlayerBuilder;
import com.google.android.exoplayer2.ui.PlayerView;

import java.io.File;

public class VideoScreen extends Activity {
    ExoPlayerBuildSource exoPlayerBuildSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_screen);
        PlayerView playerView = findViewById(R.id.player_view);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            File video = new File(extras.getString("video"));

            exoPlayerBuildSource= new ExoPlayerBuildSource(this,playerView,video);


        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        exoPlayerBuildSource.startVideo();
    }

    @Override
    protected void onStop() {
        super.onStop();
        exoPlayerBuildSource.stopVideo();
    }

    // full screen stuff
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }

    private void hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    // Shows the system bars by removing all the flags
// except for the ones that make the content appear under the system bars.
    private void showSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }

}
