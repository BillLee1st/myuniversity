package com.bill.serviceedu.controller;


import com.bill.commonutils.R;
import com.bill.serviceedu.entity.vo.CourseInfoVo;
import com.bill.serviceedu.service.EduCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author bill
 * @since 2021-07-17
 */
@RestController
@RequestMapping("/eduService/course")
@CrossOrigin
public class EduCourseController {

    @Autowired
    private EduCourseService eduCourseService;

    @PostMapping("/addCourseInfo")
    public R addCourseInfo(@RequestBody CourseInfoVo courseInfoVo) {
        String id = eduCourseService.saveCourseInfo(courseInfoVo);
        return R.ok().data("courseId", id);
    }

    @PostMapping("/getCourseInfo/{courseId}")
    public R getCourseInfo(@PathVariable("courseId") String courseId) {
        CourseInfoVo courseInfoVo = eduCourseService.getCourseInfoById(courseId);
        return R.ok().data("courseInfo", courseInfoVo);
    }

    @PostMapping("/updateCourseInfo")
    public R updateCourseInfo(@RequestBody CourseInfoVo courseInfoVo) {
        String courseId = eduCourseService.updateCourseInfo(courseInfoVo);
        return R.ok().data("courseId", courseId);
    }
}

