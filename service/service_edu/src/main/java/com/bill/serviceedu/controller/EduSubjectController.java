package com.bill.serviceedu.controller;


import com.bill.commonutils.R;
import com.bill.serviceedu.entity.subject.PrimaryClassification;
import com.bill.serviceedu.service.EduSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author bill
 * @since 2021-07-11
 */
@RestController
@RequestMapping("/eduService/subject")
@CrossOrigin
public class EduSubjectController {

    @Autowired
    private EduSubjectService eduSubjectService;


    @PostMapping("add")
    public R addSubject(MultipartFile file) {
        eduSubjectService.saveSubject(file, eduSubjectService);
        return R.ok();
    }

    @PostMapping("list")
    public R listSubject() {
        List<PrimaryClassification> subjects =  eduSubjectService.getSubjectTree();
        return R.ok().data("subjects",subjects);
    }
}

