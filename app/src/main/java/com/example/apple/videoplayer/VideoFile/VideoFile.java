package com.example.apple.videoplayer.VideoFile;

import java.io.File;

public class VideoFile {
    File file;

    public VideoFile(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public String getFileName(){
        return file.getName();
    }

}
