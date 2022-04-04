package com.libing.yygh.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author lvlibing
 * @create 2021-12-05 13:05
 */
public interface FileService {
    String upload(MultipartFile file) throws IOException;
}
