package com.example.apple.videoplayer.VideoListActivityInflater;

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

public class VideoListAdapter extends ArrayAdapter<VideoFile> {
    public VideoListAdapter(@NonNull Context context, ArrayList<VideoFile> values) {
        super(context, R.layout.video_list_snippet,values);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View inflate = inflater.inflate(R.layout.video_list_snippet,parent,false);

        VideoFile item = getItem(position);

        TextView videoTitle = inflate.findViewById(R.id._videoTitle);
        TextView videoPath = inflate.findViewById(R.id._videoPath);

        videoTitle.setText(item.getFileName());
        videoPath.setText(item.getFile().getAbsolutePath());

        return inflate;
    }
}
