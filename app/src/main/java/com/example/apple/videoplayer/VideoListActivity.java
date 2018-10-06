package com.example.apple.videoplayer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.os.strictmode.IntentReceiverLeakedViolation;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.apple.videoplayer.FileManager.FileManagerHelper;
import com.example.apple.videoplayer.VideoFile.VideoFile;
import com.example.apple.videoplayer.VideoListActivityInflater.VideoListAdapter;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class VideoListActivity extends Activity {
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_list);
        context = this;
        Bundle extras = getIntent().getExtras();

        if(extras != null){
            File path = new File(extras.getString("file"));
            FileManagerHelper fileManagerHelper = new FileManagerHelper(path);
            ArrayList<File> fileList = fileManagerHelper.getVideos();

            final ArrayList<VideoFile> videoFiles = new ArrayList<>();

            for(File file:fileList){
                VideoFile videoFile = new VideoFile(file);
                videoFiles.add(videoFile);
            }

            ListView _videoList = findViewById(R.id._videoList);
            ArrayAdapter adapter = new VideoListAdapter(this,videoFiles);
            _videoList.setAdapter(adapter);

            _videoList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent(context,VideoScreen.class);
                    String CurrentVideoPath = videoFiles.get(i).getFile().getAbsolutePath();
                    intent.putExtra("video",CurrentVideoPath);
                    context.startActivity(intent);
                }
            });
        }
    }

}
