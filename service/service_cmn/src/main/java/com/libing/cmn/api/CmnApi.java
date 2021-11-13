package com.libing.cmn.api;

import com.libing.cmn.pojo.User;
import com.libing.cmn.service.DictService;
import com.libing.yygh.common.result.Result;
import com.libing.yygh.model.cmn.Dict;
import io.swagger.annotations.ApiOperation;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author lvlibing
 * @create 2021-08-20 20:55
 */
@RestController
@RequestMapping("/admin/cmn/dict")
@CrossOrigin
public class CmnApi {
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/redis")
    public void templateRedisMy() {
        redisTemplate.opsForValue().set("lvlibing", "lvlibing");
        Object lvlibing = redisTemplate.opsForValue().get("lvlibing");
        System.out.println(lvlibing);
    }

    @Autowired
    DictService dictService;

    // 根据数据id查询子数据列表
    @ApiOperation(value = "根据数据id查询子数据列表")
    @GetMapping("findChildData/{id}")
    public Result findChildData(@PathVariable Long id) {
        List<Dict> list = dictService.findChlidData(id);
        return Result.ok(list);
    }

    //导入数据字典
    @PostMapping("/importData")
    public Result importDict(MultipartFile file) {
        dictService.importDictData(file);
        return Result.ok();
    }

    //导出数据字典接口
    @GetMapping("/exportData")
    public void exportDict(HttpServletResponse response) {
        dictService.exportDictData(response);
    }


}
