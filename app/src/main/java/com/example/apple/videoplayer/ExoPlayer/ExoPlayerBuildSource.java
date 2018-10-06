
package com.example.apple.videoplayer.ExoPlayer;

import android.content.Context;
import android.net.Uri;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.FileDataSource;

import java.io.File;

public class ExoPlayerBuildSource {
    private PlayerView playerView;
    private File video;
    private Context context;
    public SimpleExoPlayer player;

    public ExoPlayerBuildSource(Context context,PlayerView playerView, File video) {
        this.playerView = playerView;
        this.video = video;
        this.context = context;
    }

    private MediaSource buildLocalSource(){
        Uri uri = Uri.fromFile(video);
        DataSpec dataSpec = new DataSpec(uri);

        final FileDataSource fileDataSource = new FileDataSource();

        try{
            fileDataSource.open(dataSpec);
        } catch (FileDataSource.FileDataSourceException e) {
            e.printStackTrace();
        }

        DataSource.Factory factory = new DataSource.Factory() {
            @Override
            public DataSource createDataSource() {
                return fileDataSource;
            }
        };

        MediaSource source = new ExtractorMediaSource.Factory(factory).createMediaSource(fileDataSource.getUri());

        return source;

    }

    public void startVideo(){
        player = ExoPlayerFactory.newSimpleInstance(context,new DefaultTrackSelector());
        playerView.setPlayer(player);

        MediaSource source = buildLocalSource();

        player.prepare(source);
        player.setPlayWhenReady(true);


    }

    public void stopVideo(){
        player.release();
    }
}
