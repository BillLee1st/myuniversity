package com.bill.serviceorder.client;

import com.bill.commonutils.ordervo.CourseWebVoOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Bill Lee
 * @description:
 * @date 2021/8/19 22:23
 */

@Component
@FeignClient("service-edu")
public interface EduClient {

    @PostMapping("/getCourseInfoWeb/{courseId}")
    public CourseWebVoOrder getCourseInfoWeb(@PathVariable("courseId") String courseId);


}