package com.libing.controller;

import com.libing.mapper.HospitalSetMapper;
import com.libing.service.HospitalSetService;
import com.libing.yygh.model.hosp.HospitalSet;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public List<HospitalSet> getAll(){
        List<HospitalSet> list = hospitalSetService.list();
        return list;
    }

}
