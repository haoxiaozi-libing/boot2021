package com.libing.cmn.service.impl;

import com.alibaba.excel.EasyExcel;
import com.libing.cmn.listener.DictListener;
import com.libing.cmn.mapper.DictMapper;
import com.libing.cmn.service.DictService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.libing.yygh.model.cmn.Dict;
import com.libing.yygh.vo.cmn.DictEeVo;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {
    @Override
    public List<Dict> findChlidData(Long id) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("parent_id", id);
        List<Dict> list = baseMapper.selectList(queryWrapper);
        for (Dict dict : list) {
            dict.setHasChildren(judgeChild(dict.getId()));
        }
        return list;
    }

    private boolean judgeChild(Long id) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("parent_id", id);
        Integer integer = baseMapper.selectCount(queryWrapper);
        return integer > 0;
    }


    /**
     * 导出excel表格步骤
     * 设置下载信息
     * 使用outPut
     */

    @Override
    public List<Dict> exportDictData(HttpServletResponse response) {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = "dict";
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        List<Dict> dicts = baseMapper.selectList(null);
        List<DictEeVo> lists = new ArrayList<>();
        for (Dict dict : dicts) {
            DictEeVo dictEeVo = new DictEeVo();
            BeanUtils.copyProperties(dict, dictEeVo);
            lists.add(dictEeVo);
        }
        try {
            EasyExcel.write(response.getOutputStream(), DictEeVo.class).sheet("dict").doFill(lists);

        } catch (IOException e) {

        }
        return dicts;
    }

    @Override
    public void importDictData(MultipartFile file) {
        try {
            EasyExcel.read(file.getInputStream(), DictEeVo.class, new DictListener(baseMapper)).sheet().doRead();
        } catch (IOException e) {


        }

    }

    @Override
    public String getDictName(String dictCode, String value) {
        return null;
    }

    @Override
    public List<Dict> findByDictCode(String dictCode) {
        return null;
    }
}
