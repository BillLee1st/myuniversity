package com.bill.serviceedu.entity.excel;


import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author Bill Lee
 * @description:
 * @date 2021/7/12 22:42
 */
@Data
public class SubjectData {

    @ExcelProperty(index = 0)
    private String firstSubjectName;

    @ExcelProperty(index = 1)
    private String secondSubjectName;

}
