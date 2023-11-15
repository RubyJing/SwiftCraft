package com.zj.sc.excel.cover;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.converters.ReadConverterContext;
import com.alibaba.excel.converters.WriteConverterContext;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.data.WriteCellData;

/**
 * 自定义字符串转换器
 * @author zhoujing
 * @version 1.0
 * @since 2023/8/15 18:19
 */
public class CustomStringConverter implements Converter<String> {

    @Override
    public Class<?> supportJavaTypeKey() {
        return String.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    /**
     * 这里读的时候会调用
     *
     * @param context 上下文
     * @return java数据
     */
    @Override
    public String convertToJavaData(ReadConverterContext<?> context) {
        // 去掉空格
        String stringValue = context.getReadCellData().getStringValue();
        stringValue = stringValue.replaceAll(" ", "");
        return stringValue;
    }

    /**
     * 这里是写的时候会调用 不用管
     *
     * @return excel数据
     */
    @Override
    public WriteCellData<?> convertToExcelData(WriteConverterContext<String> context) {
        return new WriteCellData<>(context.getValue());
    }

}
