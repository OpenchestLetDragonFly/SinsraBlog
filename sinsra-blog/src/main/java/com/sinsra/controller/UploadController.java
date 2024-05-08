package com.sinsra.controller;/*
 * ClassName: UploadController
 * Package: com.sinsra.controller
 * @Create: 2024/5/6 22:34
 */

import com.sinsra.domain.ResponseResult;
import com.sinsra.service.UploadService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
public class UploadController {
    @Resource
    private UploadService uploadService;

    @PostMapping("/upload")
    public ResponseResult uploadImp(MultipartFile img){
        return uploadService.uploadImg(img);
        
    }
}
