package com.atguigu.oss.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: AndrewBar
 * @Date: Created in 15:27 2020/12/17
 */
public interface OssService {
    //上传头像到oss
    String uploadFileAvatar(MultipartFile file);
}
