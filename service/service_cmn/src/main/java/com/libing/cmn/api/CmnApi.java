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
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author lvlibing
 * @create 2021-08-20 20:55
 */
@RestController
@RequestMapping("/admin/cmn/dict")
//@CrossOrigin
public class CmnApi {
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    private MongoTemplate mongoTemplate;


    @GetMapping("/redis")
    public void templateRedisMy() {
        List<Person> people = Arrays.asList(
                new Person("zhangsan", 14, new Adress("北京1", "北京1", "海淀区1")),
                new Person("lisi", 142, new Adress("北京2", "北京2", "海淀区2")),
                new Person("wangwu", 143, new Adress("北京3", "北京3", "海淀区3"))
        );


        redisTemplate.opsForValue().set("lvlibing", people,1, TimeUnit.MINUTES);
        List<Person> list= (List<Person>)redisTemplate.opsForValue().get("lvlibing");

        System.out.println(list);
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
    @ApiOperation(value = "导出清单", notes = "export", produces = "application/octet-stream")
    public void exportDict(HttpServletResponse response) {
        dictService.exportDictData(response);
    }


    //根据dictcode和value查询
    @GetMapping("getName/{dictCode}/{value}")
    public String getName(@PathVariable String dictCode,
                          @PathVariable String value) {
        String dictName = dictService.getDictName(dictCode, value);
        return dictName;
    }

    //根据value查询
    @GetMapping("getName/{value}")
    public String getName(@PathVariable String value) {
        String dictName = dictService.getDictName("", value);
        return dictName;
    }

    //根据dictCode获取下级节点
    @ApiOperation(value = "根据dictCode获取下级节点")
    @GetMapping("findByDictCode/{dictCode}")
    public Result findByDictCode(@PathVariable String dictCode) {
        List<Dict> list = dictService.findByDictCode(dictCode);
        return Result.ok(list);
    }

}
