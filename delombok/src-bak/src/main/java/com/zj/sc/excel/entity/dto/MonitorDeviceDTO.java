package com.zj.sc.excel.entity.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * 监测设备DTO
 * @author zhoujing
 * @version 1.0
 * @since 2023/8/15 17:13
 */
@Data
public class MonitorDeviceDTO {
    /**
     * 测点位置
     */
    @ExcelProperty(index = 1)
    private String pointLocationMsg;

    /**
     * 设备通道名称
     */
    @ExcelProperty(index = 3)
    private String channelName;

    /**
     * 传感器类别
     */
    @ExcelProperty(index = 4)
    private String sensorCategory;

    /**
     * 设备序列号
     */
    @ExcelProperty(index = 5)
    private String serialNo;

    /**
     * 数据标识
     */
    @ExcelProperty(index = 13)
    private String dataKey;

}
