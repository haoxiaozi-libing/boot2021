package com.libing.yygh.api;

import com.libing.yygh.common.result.Result;
import com.libing.yygh.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import sun.awt.geom.AreaOp;

import java.io.IOException;

/**
 * @author lvlibing
 * @create 2021-12-05 13:01
 */

@RestController
@RequestMapping("api/oss/file")
public class FileApiController {

    @Autowired
    FileService fileService;


    //上传文件到阿里云oss
    @PostMapping("/fileUpload")
    public Result fileUpload(MultipartFile file) {
        //获取上传文件的服务器地址
        try {
            String url = fileService.upload(file);
            return  Result.ok(url);
        } catch (IOException e) {


        }
        return Result.ok();
    }
}
