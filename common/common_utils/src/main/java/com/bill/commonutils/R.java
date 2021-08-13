package com.bill.commonutils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;


/**
 * @author Bill Lee
 * @description:
 * @date 2021/5/17 22:44
 */

@Data
public class R {

    @ApiModelProperty(value = "success or not")
    public boolean success;

    @ApiModelProperty(value = "code return")
    private Integer code;

    @ApiModelProperty(value = "message return")
    private String message;

    @ApiModelProperty(value = "data return")
    private Map<String, Object> data = new HashMap<>();

    public static R ok() {
        R r = new R();
        r.setSuccess(true);
        r.setCode(ResultCode.success);
        r.setMessage("成功");
        return r;
    }
    public static R error() {
        R r = new R();
        r.setSuccess(false);
        r.setCode(ResultCode.error);
        r.setMessage("失败");
        return r;
    }
    public R success(boolean success) {
        this.setSuccess(success);
        return this;
    }
    public R message(String message) {
        this.setMessage(message);
        return this;
    }
    public R code(Integer code) {
        this.setCode(code);
        return this;
    }
    public R data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }
    public R data(Map<String, Object> map) {
        this.setData(map);
        return this;
    }

}
