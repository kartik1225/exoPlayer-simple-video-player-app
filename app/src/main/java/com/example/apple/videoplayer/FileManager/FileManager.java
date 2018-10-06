package com.example.apple.videoplayer.FileManager;

import android.content.Context;
import android.os.Environment;
import android.widget.Toast;


import java.io.File;
import java.util.ArrayList;

public class FileManager {
    Context context;

    public FileManager(Context context) {
        this.context = context;
    }

//    Global Variables
    File root = Environment.getExternalStorageDirectory();
    ArrayList<File> videoDirPathList = new ArrayList<>();

    private Boolean isExternalStorageReadable(){
        return root.listFiles() != null;
    };

    private Boolean isRootContainVieos(){
        if(isExternalStorageReadable()){
            FileManagerHelper fileManagerHelper = new FileManagerHelper(root);
            return fileManagerHelper.isContainVideo();
        }else {
            Toast.makeText(this.context, "Storage Permission is not granted", Toast.LENGTH_LONG).show();
            return null;
        }
    }

    private void __getVideoDirs(File path){
        File[] fileList = path.listFiles();

        for(File file:fileList){
            if(file.isDirectory()){
                FileManagerHelper fileManagerHelper = new FileManagerHelper(file);

                if(fileManagerHelper.isContainVideo()){
                    videoDirPathList.add(file);
                }

            }
        }
    }

    private void _getVideoDirs(File path){
        File[] fileList = path.listFiles();

        for(File file:fileList){
            if(file.isDirectory()){
                FileManagerHelper fileManagerHelper = new FileManagerHelper(file);

                // loop from lvl 2
                if(fileManagerHelper.isContainVideo()){
                    videoDirPathList.add(file);
                }

                __getVideoDirs(file);

            }
        }
    }

    public ArrayList<File> getVideoDirs(){

        File[] fileList = root.listFiles();

        for(File file:fileList){
            if(file.isDirectory()){
                FileManagerHelper fileManagerHelper = new FileManagerHelper(file);

                // adding root files for base level
                if(fileManagerHelper.isContainVideo()){
                    videoDirPathList.add(file);
                }


                _getVideoDirs(file);
            }
        }

        if (isRootContainVieos()) {
            videoDirPathList.add(root);
        }

        return videoDirPathList;
    }


}
