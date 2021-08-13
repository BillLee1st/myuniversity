package com.bill.serviceedu.entity.subject;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bill Lee
 * @description:
 * @date 2021/7/15 23:05
 */

@Data
public class PrimaryClassification {

    private String id;

    private String title;

    private List<SecondaryClassification> children = new ArrayList<>();
}
