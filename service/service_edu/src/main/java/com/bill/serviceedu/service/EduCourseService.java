package com.bill.serviceedu.service;

import com.bill.serviceedu.entity.EduCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bill.serviceedu.entity.vo.CourseInfoVo;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author bill
 * @since 2021-07-17
 */
public interface EduCourseService extends IService<EduCourse> {


    String saveCourseInfo(CourseInfoVo courseInfoVo);

    CourseInfoVo getCourseInfoById(String courseId);

    String updateCourseInfo(CourseInfoVo courseInfoVo);

}
