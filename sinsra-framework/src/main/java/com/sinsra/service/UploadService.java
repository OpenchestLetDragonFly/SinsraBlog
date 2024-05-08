package com.sinsra.service;/*
 * ClassName: UploadService
 * Package: com.sinsra.service
 * @Create: 2024/5/6 22:38
 */

import com.sinsra.domain.ResponseResult;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
    ResponseResult uploadImg(MultipartFile img);
}
