package com.bill.servicebase.exceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Bill Lee
 * @description:
 * @date 2021/5/23 12:27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomException extends RuntimeException{
    private Integer code;

    private String msg;
}
