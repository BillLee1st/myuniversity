package com.bill.serviceoss.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Bill Lee
 * @description:
 * @date 2021/6/17 21:05
 */
public interface OssService {
    String uploadFileAvatar(MultipartFile file);
}
