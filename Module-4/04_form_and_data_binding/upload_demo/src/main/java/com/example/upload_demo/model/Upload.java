package com.example.upload_demo.model;

import org.springframework.web.multipart.MultipartFile;

public class Upload {
    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public Upload() {
    }
}
