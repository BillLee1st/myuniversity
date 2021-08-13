package com.bill.serviceedu.controller;


import com.bill.commonutils.R;
import com.bill.serviceedu.entity.course.ChapterVo;
import com.bill.serviceedu.service.EduChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author bill
 * @since 2021-07-17
 */
@RestController
@RequestMapping("/eduService/chapter")
@CrossOrigin
public class EduChapterController {

    @Autowired
    private EduChapterService eduChapterService;


    @GetMapping("getChapterVideo/{courseId}")
    public R getChapterVideo(@PathVariable("courseId") String courseId) {
        List<ChapterVo> list =  eduChapterService.getChapterVideoByCourseId(courseId);
        return R.ok().data("chapterVideoList", list);
    }

}

