package com.mt.excel;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.alibaba.excel.util.DateUtils;
import com.sun.org.apache.xpath.internal.operations.Number;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * author: liqm
 * 2020-02-14
 */
public class LocalDateConverter implements Converter<LocalDate> {
    @Override
    public Class supportJavaTypeKey() {
        return null;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return null;
    }

    @Override
    public LocalDate convertToJavaData(CellData cellData, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) throws Exception {

        String value = cellData.getStringValue();
        System.out.println(value);
        if (StringUtils.isBlank(value)) {
            return null;
        }
        String []arr = value.split("-");
        if(arr.length != 3){
            throw new Exception("日期格式错误");
        }
        int year = Integer.parseInt(arr[0]);
        int month = Integer.parseInt(arr[1]);
        int day = Integer.parseInt(arr[2]);
        return LocalDate.of(year, month, day);
    }

    @Override
    public CellData convertToExcelData(LocalDate value, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) throws Exception {

        if (contentProperty == null || contentProperty.getDateTimeFormatProperty() == null) {
            return new CellData(value.format(DateTimeFormatter.ISO_LOCAL_DATE));
        } else {
            return new CellData(value.format(DateTimeFormatter.ofPattern(contentProperty.getDateTimeFormatProperty().getFormat())));
        }
    }
}
