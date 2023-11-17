//package com.zj.sc.excel;
//
//import com.alibaba.excel.metadata.CellExtra;
//import lombok.extern.slf4j.Slf4j;
//
//import java.util.List;
//import java.util.Map;
//
///**
// * EasyExcel工具类
// *
// * @author zhoujing
// * @version 1.0
// * @since 2023/8/16 10:49
// */
//@Slf4j
//public class EasyExcelHelper {
//
//    /**
//     * 处理合并单元格
//     *
//     * @param data               解析数据
//     * @param extraMergeInfoList 合并单元格信息
//     * @param headRowNumber      起始行
//     * @return 填充好的解析数据
//     */
//    public static List<Map<Integer, String>> explainMergeData(List<Map<Integer, String>> data, List<CellExtra> extraMergeInfoList, Integer headRowNumber) {
//        //循环所有合并单元格信息
//        extraMergeInfoList.forEach(cellExtra -> {
//            int firstRowIndex = cellExtra.getFirstRowIndex() - headRowNumber;
//            int firstColumnIndex = cellExtra.getFirstColumnIndex();
//            int lastRowIndex = cellExtra.getLastRowIndex() - headRowNumber;
//            int lastColumnIndex = cellExtra.getLastColumnIndex();
//            // 获取初始值
//            String initValue = getInitValueFromList(firstRowIndex, firstColumnIndex, data);
//            // 设置值
//            for (int i = firstRowIndex; i <= lastRowIndex; i++) {
//                for (int j = firstColumnIndex; j <= lastColumnIndex; j++) {
//                    setInitValueToList(initValue, i, j, data);
//                }
//            }
//        });
//        return data;
//    }
//
//    /**
//     * 设置合并单元格的值
//     *
//     * @param filedValue  值
//     * @param rowIndex    行
//     * @param columnIndex 列
//     * @param data        解析数据
//     */
//    public static void setInitValueToList(String filedValue, Integer rowIndex, Integer columnIndex, List<Map<Integer, String>> data) {
//        Map<Integer, String> object = data.get(rowIndex);
//        object.put(columnIndex, String.valueOf(filedValue));
//    }
//
//    /**
//     * 获取合并单元格的初始值
//     * rowIndex对应list的索引
//     * columnIndex对应实体内的字段
//     *
//     * @param firstRowIndex    起始行
//     * @param firstColumnIndex 起始列
//     * @param data             列数据
//     * @return 初始值
//     */
//    public static String getInitValueFromList(Integer firstRowIndex, Integer firstColumnIndex, List<Map<Integer, String>> data) {
//        String filedValue = null;
//        Map<Integer, String> object = data.get(firstRowIndex);
//        for (Map.Entry<Integer, String> entry : object.entrySet()) {
//            if (entry.getKey().equals(firstColumnIndex)) {
//                filedValue = entry.getValue();
//                break;
//            }
//        }
//        return filedValue;
//    }
//}
//
