package com.lqm.demo.utils;

import java.util.List;

/**
 * Excel导出回调接口
 */
public interface ExportExcelCallback {

    List<?> getTargetData(int currentPage,int pageSize);
}
