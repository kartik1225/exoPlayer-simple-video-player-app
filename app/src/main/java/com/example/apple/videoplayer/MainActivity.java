package com.example.apple.videoplayer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.apple.videoplayer.FileManager.FileManager;
import com.example.apple.videoplayer.MainActivityInfalter.DirListAdapter;
import com.example.apple.videoplayer.VideoFile.VideoFile;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends Activity {

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        FileManager fileManager = new FileManager(this);

        final ArrayList<File> videoDirs = fileManager.getVideoDirs();

        final ArrayList<VideoFile> videoFiles = new ArrayList<>();

        for(File file:videoDirs){
            VideoFile videoFile = new VideoFile(file);
            videoFiles.add(videoFile);
        }

        ListView _dirList = findViewById(R.id._dirList);

        ListAdapter adapter = new DirListAdapter(this,videoFiles);

        _dirList.setAdapter(adapter);

        _dirList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(context,VideoListActivity.class);
                String currentFile = videoFiles.get(i).getFile().getAbsolutePath();
                intent.putExtra("file",currentFile);
                context.startActivity(intent);
            }
        });


    }
}
