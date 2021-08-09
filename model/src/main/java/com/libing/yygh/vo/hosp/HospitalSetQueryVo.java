package com.libing.yygh.vo.hosp;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class HospitalSetQueryVo {

    // 根据医院名称和编号查询，封装vo类
    @ApiModelProperty(value = "医院名称")
    private String hosname;

    @ApiModelProperty(value = "医院编号")
    private String hoscode;
}
