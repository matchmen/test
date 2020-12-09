package com.lqm.demo.utils;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.export.styler.IExcelExportStyler;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

/**
 * 导出Excel工具类
 *
 * @author sunluyang on 2017/6/5.
 */

public class ExcelUtils {

    private ExcelUtils() {

    }
    /**
     * 导出Excel到 OutputStream
     *
     * @param exportObjectClass 导出实例类型
     * @param targetDataList    导出目标数据（？与exportObjectClass保持一致）
     * @param sheetName         sheet名称
     * @param outputStream      Excel接收输出流
     * @param excelExportStylerClass Excel样式(默认为DefaultExcelExportStyler.class,可以为空)
     */
    public static void exportExcel(Class<?> exportObjectClass, List<?> targetDataList, Class<? extends IExcelExportStyler> excelExportStylerClass, String sheetName, OutputStream outputStream) throws IOException {

        writeToOutputStream(outputStream, ExcelExportUtil.exportExcel(createExportParams(sheetName, excelExportStylerClass), exportObjectClass, targetDataList));
    }

    /**
     * 导出Excel到 OutputStream
     *
     * @param exportObjectClass 导出实例类型与exportObjectClass保持一致
     * @param targetDataList    导出目标数据（？）
     * @param sheetName         sheet名称
     * @param outputStream      Excel接收输出流
     */
    public static void exportExcel(Class<?> exportObjectClass, List<?> targetDataList,String sheetName,OutputStream outputStream) throws IOException {

        writeToOutputStream(outputStream, ExcelExportUtil.exportExcel(createExportParams(sheetName, DefaultExcelExportStyler.class), exportObjectClass, targetDataList));
    }

    /**
     * 大批量数据导出Excel
     *
     * @param exportObjectClass     导出实例类型
     * @param sheetName             sheet名称
     * @param outputStream          Excel接收输出流
     * @param exportExcelCallback   回调方法，用于获取目标数据
     * @throws IOException
     */
    public static void exportBigExcel(Class<?> exportObjectClass, String sheetName, OutputStream outputStream, ExportExcelCallback exportExcelCallback) throws IOException {

        exportBigExcel(exportObjectClass, sheetName, outputStream, 1_000, exportExcelCallback);

    }

    /**
     * 大批量数据导出Excel
     *
     * @param exportObjectClass     导出实例类型
     * @param sheetName             sheet名称
     * @param batchSize             每次加载数量
     * @param outputStream          Excel接收输出流
     * @param exportExcelCallback   回调方法，用于获取目标数据
     * @throws IOException
     */
    public static void exportBigExcel(Class<?> exportObjectClass, String sheetName, OutputStream outputStream,int batchSize, ExportExcelCallback exportExcelCallback) throws IOException {

        ExportParams exportParams = createExportParams(sheetName, DefaultExcelExportStyler.class);

        Workbook workbook = ExcelExportUtil.exportBigExcel(exportParams, exportObjectClass, new ArrayList<>());

        for (int i = 0; ; i++) {

            List<?> targetData = exportExcelCallback.getTargetData(i, batchSize);

            if(CollectionUtils.isEmpty(targetData)){
                break;
            }
            workbook = ExcelExportUtil.exportBigExcel(exportParams, exportObjectClass, targetData);
        }

        ExcelExportUtil.closeExportBigExcel();

        writeToOutputStream(outputStream,workbook);

    }

    private static ExportParams createExportParams(String sheetName,Class<? extends IExcelExportStyler> excelExportStylerClass) {
        ExportParams exportParams = new ExportParams(null,sheetName);
        exportParams.setStyle(Objects.isNull(excelExportStylerClass) ? DefaultExcelExportStyler.class : excelExportStylerClass);
        return exportParams;
    }

    private static void writeToOutputStream(OutputStream outputStream, Workbook workbook) throws IOException {
        workbook.write(outputStream);
    }

}
