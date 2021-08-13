package com.bill.serviceedu.service;

import com.bill.serviceedu.entity.EduSubject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bill.serviceedu.entity.subject.PrimaryClassification;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author bill
 * @since 2021-07-11
 */
public interface EduSubjectService extends IService<EduSubject> {

    void saveSubject(MultipartFile file,EduSubjectService eduSubjectService);

     List<EduSubject> getPrimaryClassification();

     List<EduSubject> getSecondaryClassification();

    List<PrimaryClassification> getSubjectTree();
}
