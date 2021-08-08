package com.libing.controller;

import com.libing.mapper.HospitalSetMapper;
import com.libing.service.HospitalSetService;
import com.libing.yygh.common.result.Result;
import com.libing.yygh.model.hosp.HospitalSet;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.bouncycastle.est.ESTSourceConnectionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lvlibing
 * @create 2021-08-08 14:45
 */
@RestController
@RequestMapping(value = "admin/hosp/hospitalSet")
public class HospSetApi {

    //注入service
    @Autowired
    private HospitalSetService hospitalSetService;

    @GetMapping("/all")
    public Result<List<HospitalSet>> getAll(){
        List<HospitalSet> list = hospitalSetService.list();
        Result<List<HospitalSet>> ok = Result.ok(list);
        return ok;
    }
    @DeleteMapping("{id}")
    public Result deleteById(@PathVariable("id") int id){
        boolean b = hospitalSetService.removeById(id);
        if(b){
            return Result.ok();
        }else {
            return Result.fail();
        }

    }


}
