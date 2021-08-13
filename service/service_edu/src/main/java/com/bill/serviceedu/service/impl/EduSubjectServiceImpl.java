package com.bill.serviceedu.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bill.serviceedu.entity.EduSubject;
import com.bill.serviceedu.entity.excel.SubjectData;
import com.bill.serviceedu.entity.subject.PrimaryClassification;
import com.bill.serviceedu.entity.subject.SecondaryClassification;
import com.bill.serviceedu.listener.SubjectExcelListener;
import com.bill.serviceedu.mapper.EduSubjectMapper;
import com.bill.serviceedu.service.EduSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author bill
 * @since 2021-07-11
 */
@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {

    @Override
    public void saveSubject(MultipartFile file,EduSubjectService eduSubjectService) {
        try {
            InputStream ins = file.getInputStream();
            EasyExcel.read(ins, SubjectData.class, new SubjectExcelListener(eduSubjectService)).sheet().doRead();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<PrimaryClassification> getSubjectTree() {

        List<EduSubject> primarySubjects = this.getPrimaryClassification();
        List<EduSubject> secondarySubjects = this.getSecondaryClassification();

        List<PrimaryClassification> primarySubjectList = new ArrayList<>();

        for (EduSubject eduSubject : primarySubjects) {
            PrimaryClassification primarySubject = new PrimaryClassification();
            BeanUtils.copyProperties(eduSubject,primarySubject);
            String subjectId = eduSubject.getId();
//            primarySubject.setId(subjectId);
//            primarySubject.setTitle(eduSubject.getTitle());
            List<SecondaryClassification> secondarySubjectList = new ArrayList<>();
            for (EduSubject subject : secondarySubjects) {

                if (subjectId.equals(subject.getParentId())) {
                    SecondaryClassification secondarySubject = new SecondaryClassification();
                    BeanUtils.copyProperties(subject,secondarySubject);
//                    secondarySubject.setId(subject.getId());
//                    secondarySubject.setTitle(subject.getTitle());
                    secondarySubjectList.add(secondarySubject);
                }
                primarySubject.setChildren(secondarySubjectList);
            }
            primarySubjectList.add(primarySubject);
        }
        return primarySubjectList;
    }

    @Override
    public List<EduSubject> getPrimaryClassification() {
        QueryWrapper<EduSubject> primaryWrapper = new QueryWrapper<>();
        primaryWrapper.eq("parent_id", "0");
        List<EduSubject> primarySubjects = baseMapper.selectList(primaryWrapper);
        return primarySubjects;
    }

    @Override
    public List<EduSubject> getSecondaryClassification() {
        QueryWrapper<EduSubject> secondaryWrapper = new QueryWrapper<>();
        secondaryWrapper.ne("parent_id", "0");
        List<EduSubject> secondarySubjects = baseMapper.selectList(secondaryWrapper);
        return secondarySubjects;
    }

}
