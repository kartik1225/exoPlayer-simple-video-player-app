package com.example.apple.videoplayer.FileManager;

import android.text.Editable;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

public class FileManagerHelper {
    File path;

    public FileManagerHelper(File path) {
        this.path = path;
    }
    // not Supported formats:  "avi" "flv" "mpg" "vob" "wmv" "mpeg"
    String[] extensions = {"3gp","m4v","mkv","mov","mp4","mts","webm"};

    private Boolean isContain(final String[] extension){
        ArrayList<File> _container = new ArrayList<>();
        for(final String ext:extensions){
            File[] match = path.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File file, String s) {
                    return s.toLowerCase().endsWith(ext);
                }
            });

            for (File file:match){
                _container.add(file);
            }
        }
        return !_container.isEmpty() ;

    }

    private ArrayList<File> getContaining(final String[] extensions){
        ArrayList<File> _container = new ArrayList<>();
        for(final String extension:extensions){
            File[] match = path.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File file, String s) {
                    return s.toLowerCase().endsWith(extension);
                }
            });

            for (File file:match){
                _container.add(file);
            }
     }
     return _container;
    }

    public Boolean isContainVideo() {
        boolean hasMp4 = isContain(extensions);
        return hasMp4;
    }

    // videoScreen intent
    public ArrayList<File> getVideos(){
        ArrayList<File> videoFiles = getContaining(extensions);
        return videoFiles;
    }





}
