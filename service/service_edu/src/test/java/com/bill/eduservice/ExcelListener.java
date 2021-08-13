package com.bill.eduservice;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.CellData;

import java.util.Map;

/**
 * @author Bill Lee
 * @description:
 * @date 2021/7/11 20:59
 */
public class ExcelListener extends AnalysisEventListener<Data> {

    @Override
    public void invoke(Data data, AnalysisContext analysisContext) {
        System.out.println("data = " + data);
    }

    public void invokeHead(Map<Integer, CellData> headMap, AnalysisContext context) {
        System.out.println("head = " + headMap);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
