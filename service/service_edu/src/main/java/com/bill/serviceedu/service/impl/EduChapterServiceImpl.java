package com.bill.serviceedu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bill.serviceedu.entity.EduChapter;
import com.bill.serviceedu.entity.EduVideo;
import com.bill.serviceedu.entity.course.ChapterVo;
import com.bill.serviceedu.entity.course.VideoVo;
import com.bill.serviceedu.mapper.EduChapterMapper;
import com.bill.serviceedu.service.EduChapterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bill.serviceedu.service.EduVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author bill
 * @since 2021-07-17
 */
@Service
public class EduChapterServiceImpl extends ServiceImpl<EduChapterMapper, EduChapter> implements EduChapterService {

    @Autowired
    private EduVideoService eduVideoService;


    @Override
    public List<ChapterVo> getChapterVideoByCourseId(String courseId) {

        List<ChapterVo> chapterVoList = new ArrayList<>();

        QueryWrapper<EduChapter> chapterWrapper = new QueryWrapper<>();
        chapterWrapper.eq("course_id", courseId);
        List<EduChapter> chapters = baseMapper.selectList(chapterWrapper);

        for (EduChapter chapter : chapters) {
            ChapterVo chapterVo = new ChapterVo();
            chapterVo.setId(chapter.getId());
            chapterVo.setTitle(chapter.getTitle());

            QueryWrapper<EduVideo> videoWrapper = new QueryWrapper<>();
            videoWrapper.eq("chapter_id", chapter.getId());
            List<EduVideo> videos = eduVideoService.list(videoWrapper);

            List<VideoVo> videoVoList = new ArrayList<>();
            for (EduVideo video : videos) {
                VideoVo videoVo = new VideoVo();
                videoVo.setId(video.getId());
                videoVo.setTitle(video.getTitle());
                videoVoList.add(videoVo);
            }
            chapterVo.setChildren(videoVoList);
            chapterVoList.add(chapterVo);
        }

        return chapterVoList;
    }
}
