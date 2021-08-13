package com.bill.serviceedu.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Bill Lee
 * @description:
 * @date 2021/5/20 21:32
 */
@Data
public class TeacherQuery {

    @ApiModelProperty(value = "teacher name")
    private String name;

    @ApiModelProperty(value = "teacher level")
    private Integer level;

    @ApiModelProperty(value = "start time")
    private String begin;

    @ApiModelProperty(value = "end time")
    private String end;
}
