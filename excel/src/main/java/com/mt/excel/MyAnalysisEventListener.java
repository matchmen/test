package com.mt.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import lombok.Data;

/**
 * author: liqm
 * 2020-02-14
 */
@Data
public class MyAnalysisEventListener extends AnalysisEventListener<User> {
    @Override
    public void invoke(User data, AnalysisContext context) {
        System.out.println("data:" + data);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
    }
}
