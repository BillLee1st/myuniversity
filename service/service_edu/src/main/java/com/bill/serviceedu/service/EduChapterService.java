package com.bill.serviceedu.service;

import com.bill.serviceedu.entity.EduChapter;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bill.serviceedu.entity.course.ChapterVo;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author bill
 * @since 2021-07-17
 */
public interface EduChapterService extends IService<EduChapter> {

    List<ChapterVo> getChapterVideoByCourseId(String courseId);
}
