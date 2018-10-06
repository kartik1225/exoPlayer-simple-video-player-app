package com.example.apple.videoplayer.ExoPlayer;

import android.content.Context;

import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;

import java.io.File;

public class ExoPlayerBuilder {
    private PlayerView playerView;
    private File video;
    private Context context;
    public SimpleExoPlayer player;


    public ExoPlayerBuilder(Context context,PlayerView playerView, File video) {
        this.context = context;
        this.playerView = playerView;
        this.video = video;
    }

    public void build(){

    }
}
