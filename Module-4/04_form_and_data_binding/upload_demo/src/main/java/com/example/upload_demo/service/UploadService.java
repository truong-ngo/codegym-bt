package com.example.upload_demo.service;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class UploadService {
    public void uploadFile(MultipartFile file) throws IOException {
        String path = "C:\\Learning\\Codegym\\codegym-bt\\Module-4\\04_form_and_data_binding\\upload_demo\\src\\main\\webapp\\uploadFile\\";
        String fileName = file.getOriginalFilename();
        FileCopyUtils.copy(file.getBytes(), new File(path + fileName));
    }
}
