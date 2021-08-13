package com.bill.eduservice;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.annotation.ExcelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bill Lee
 * @description:
 * @date 2021/6/20 19:41
 */
public class Data {

    @ExcelProperty(value = "编号", index = 0)
    private int id;

    @ExcelProperty(value = "姓名", index = 1)
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ExcelDemo{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }

    private static List<Data> data() {
        List<Data> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Data data = new Data();
            data.setId(i);
            data.setName("Jane" + i);
            list.add(data);
        }
        return list;
    }

    public static void main(String[] args) {

        String fileName = "D:\\other\\demo.xlsx";
//        EasyExcel.write(fileName,Data.class).sheet("学生信息").doWrite(data());

        EasyExcel.read(fileName, Data.class, new ExcelListener()).sheet().doRead();
    }
}
