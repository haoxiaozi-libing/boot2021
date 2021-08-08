package com.libing.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.libing.mapper.HospitalSetMapper;
import com.libing.service.HospitalSetService;
import com.libing.yygh.model.hosp.HospitalSet;
import com.libing.yygh.vo.order.SignInfoVo;
import org.springframework.stereotype.Service;

/**
 * @author lvlibing
 * @create 2021-08-08 15:55
 */
@Service
public class HospitalSetServiceImpl extends ServiceImpl<HospitalSetMapper,HospitalSet> implements HospitalSetService {

    @Override
    public String getSignKey(String hoscode) {
        return null;
    }

    @Override
    public SignInfoVo getSignInfoVo(String hoscode) {
        return null;
    }
}
