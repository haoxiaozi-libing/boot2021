package com.libing.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.libing.mapper.HospitalSetMapper;
import com.libing.service.HospitalSetService;
import com.libing.yygh.model.hosp.HospitalSet;

/**
 * @author lvlibing
 * @create 2021-08-08 15:55
 */
public class HospitalSetServiceImpl extends ServiceImpl<HospitalSetMapper,HospitalSet> implements HospitalSetService {

    @Override
    public String getSignKey(String hoscode) {
        return null;
    }
}
