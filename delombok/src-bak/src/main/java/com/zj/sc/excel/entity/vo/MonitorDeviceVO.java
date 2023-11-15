package com.zj.sc.excel.entity.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 监测设备DTO
 *
 * @author zhoujing
 * @version 1.0
 * @since 2023/8/15 17:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MonitorDeviceVO {

    /**
     * 设备名称
     */
    @ExcelProperty(index = 0, value = "name")
    private String name;

    /**
     * 设备序列号
     */
    @ExcelProperty(index = 1, value = "serial_no")
    private String serialNo;

    /**
     * 设备编码
     */
    @ExcelProperty(index = 2, value = "code")
    private String code;

    /**
     * 设备通道名称
     */
    @ExcelProperty(index = 3, value = "channel_name")
    private String channelName;

    /**
     * 测点位置
     */
    @ExcelProperty(index = 4, value = "point_location_msg")
    private String pointLocationMsg;

    /**
     * 设备类型
     */
    @ExcelProperty(index = 5, value = "type")
    private Integer type;

    /**
     * 传感器类别
     */
    @ExcelProperty(index = 6, value = "sensor_category")
    private String sensorCategory;

    /**
     * 数据标识
     */
    @ExcelProperty(index = 7, value = "data_key")
    private String dataKey;


}
