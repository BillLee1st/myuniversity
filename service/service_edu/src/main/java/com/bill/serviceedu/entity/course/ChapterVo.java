package com.bill.serviceedu.entity.course;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bill Lee
 * @description:
 * @date 2021/7/19 22:05
 */
@Data
public class ChapterVo {

    private String id;

    private String title;

    List<VideoVo> children = new ArrayList<>();
}
