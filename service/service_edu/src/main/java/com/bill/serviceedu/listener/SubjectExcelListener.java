package com.bill.serviceedu.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bill.servicebase.exceptionHandler.CustomException;
import com.bill.serviceedu.entity.EduSubject;
import com.bill.serviceedu.entity.excel.SubjectData;
import com.bill.serviceedu.service.EduSubjectService;

/**
 * @author Bill Lee
 * @description:
 * @date 2021/7/12 22:45
 */
public class SubjectExcelListener extends AnalysisEventListener<SubjectData> {

    private EduSubjectService eduSubjectService;

    public SubjectExcelListener() {

    }

    public SubjectExcelListener(EduSubjectService eduSubjectService) {
        this.eduSubjectService = eduSubjectService;
    }

    @Override
    public void invoke(SubjectData subjectData, AnalysisContext analysisContext) {

        if (subjectData == null) {
            throw new CustomException(20001,"file is null");
        }

        String firstSubjectName = subjectData.getFirstSubjectName();
        EduSubject firstSubject = existFirstSubject(eduSubjectService, firstSubjectName);
        if (StringUtils.isEmpty(firstSubject)) {
            firstSubject = new EduSubject();
            firstSubject.setTitle(firstSubjectName);
            firstSubject.setParentId("0");
            eduSubjectService.save(firstSubject);
        }

        String parentId = firstSubject.getId();
//        String secondSubjectName = subjectData.getFirstSubjectName();
        EduSubject secondSubject = existSecondSubject(eduSubjectService, firstSubjectName, parentId);

        if (StringUtils.isEmpty(secondSubject)) {
            secondSubject = new EduSubject();
            secondSubject.setTitle(firstSubjectName);
            secondSubject.setParentId(parentId);
            eduSubjectService.save(secondSubject);
        }
    }


    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }

    private EduSubject existFirstSubject(EduSubjectService eduSubjectService, String name) {
        QueryWrapper<EduSubject> wrapper = new QueryWrapper<>();
        wrapper.eq("title", name);
        wrapper.eq("parent_id", "0");

        EduSubject firstSubject = eduSubjectService.getOne(wrapper);
        return firstSubject;
    }

    private EduSubject existSecondSubject(EduSubjectService eduSubjectService, String name, String parentId) {
        QueryWrapper<EduSubject> wrapper = new QueryWrapper();
        wrapper.eq("title", name);
        wrapper.eq("parent_id", parentId);

        EduSubject secondEduSubject = eduSubjectService.getOne(wrapper);
        return secondEduSubject;
    }
}
