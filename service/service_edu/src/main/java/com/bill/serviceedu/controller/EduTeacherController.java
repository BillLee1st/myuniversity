package com.bill.serviceedu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bill.commonutils.R;
import com.bill.servicebase.exceptionHandler.CustomException;
import com.bill.serviceedu.entity.EduTeacher;
import com.bill.serviceedu.entity.vo.TeacherQuery;
import com.bill.serviceedu.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author bill
 * @since 2021-05-16
 */
@Api(description = "讲师管理")
@RestController
@RequestMapping("/eduService/teacher")
@CrossOrigin
public class EduTeacherController {

    @Autowired
    private EduTeacherService eduTeacherService;

    //url = http://localhost:8001/serviceedu/edu-teacher/getAll
    @ApiOperation(value = "查询所有讲师")
    @GetMapping(value = "getAll")
    public R getAllTeacher() {
        List<EduTeacher> list = eduTeacherService.list(null);
        return R.ok().data("items", list);
    }

    @ApiOperation(value = "删除讲师")
    @DeleteMapping("{id}")
    public R removeById(
            @ApiParam(name = "id", value = "讲师id", required = true)
            @PathVariable String id) {
        boolean b = eduTeacherService.removeById(id);
        if (b) {
            return R.ok().message("delete success");
        }
        return R.error().message("delete failed");
    }

    @ApiOperation(value = "讲师分页列表")
    @PostMapping("pageTeacher/{page}/{limit}")
    public R pageList(
            @ApiParam(name = "page", value = "当前页码", required = true) @PathVariable Long page,
            @ApiParam(name = "limit", value = "每页条数", required = true) @PathVariable Long limit,
            @RequestBody(required = false) TeacherQuery teacherQuery) {

        Page<EduTeacher> pageParam = new Page<>(page, limit);

        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();

        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String start = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();

        if (!StringUtils.isEmpty(name)) {
            wrapper.like("name", name);
        }
        if (!StringUtils.isEmpty(level)) {
            wrapper.eq("level", level);
        }
        if (!StringUtils.isEmpty(start)) {
            wrapper.ge("gmt_create", start);
        }
        if (!StringUtils.isEmpty(end)) {
            wrapper.le("gmt_create", end);
        }

        wrapper.orderByDesc("gmt_create");
        eduTeacherService.page(pageParam, wrapper);
        List<EduTeacher> records = pageParam.getRecords();

        long total = pageParam.getTotal();
        Map<String, Object> resultMap = new HashMap<>(2);
        resultMap.put("item", records);
        resultMap.put("total", total);
//        return R.ok().data("list", records).data("total", total);

        return R.ok().data(resultMap);
    }

    @PostMapping("addTeacher")
    public R addTeacher(@RequestBody EduTeacher eduTeacher) {

        boolean save = eduTeacherService.save(eduTeacher);
        if (save) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    @GetMapping(value = "getTeacher/{id}")
    public R getTeacher(@PathVariable String id) {
//        try {
//            int i = 1 / 0;
//        } catch (Exception e) {
//            throw new CustomException(20001, "custom exception");
//        }
        EduTeacher teacher = eduTeacherService.getById(id);
        return R.ok().data("teacher", teacher);
    }

    @PostMapping(value = "updateTeacher")
    public R updateTeacher(@RequestBody EduTeacher eduTeacher) {
        boolean flag = eduTeacherService.updateById(eduTeacher);
        if (flag) {
            return R.ok();
        } else {
            return R.error();
        }
    }
}

