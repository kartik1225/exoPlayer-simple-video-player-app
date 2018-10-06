package com.example.apple.videoplayer.MainActivityInfalter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import com.example.apple.videoplayer.R;
import com.example.apple.videoplayer.VideoFile.VideoFile;

import java.util.ArrayList;


public class DirListAdapter extends ArrayAdapter<VideoFile> {
    public DirListAdapter(@NonNull Context context, ArrayList<VideoFile> values) {
        super(context, R.layout.file_list_snippet,values);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View dirListView = inflater.inflate(R.layout.file_list_snippet,parent,false);

        VideoFile videoFile = getItem(position);

        TextView fileName = dirListView.findViewById(R.id.fileName);
        TextView filePath = dirListView.findViewById(R.id.filePath);
        fileName.setText(videoFile.getFileName());
        filePath.setText(videoFile.getFile().getAbsolutePath());

        return dirListView;
    }
}
