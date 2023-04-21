package com.example.controller;

import com.aliyun.oss.model.MultipartUpload;
import com.example.pojo.Result;
import com.example.utils.AliOSSUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class UploadController {

    @Autowired
    private AliOSSUtils aliOSSUtils;
    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {
        String url=aliOSSUtils.upload(image);
        return Result.success(url);
    }

}
