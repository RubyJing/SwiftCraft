package com.zj.sc.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.enums.CellExtraTypeEnum;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.fastjson.JSON;
import com.zj.sc.excel.cover.CustomStringConverter;
import com.zj.sc.excel.entity.dto.MonitorDeviceDTO;
import com.zj.sc.excel.entity.vo.MonitorDeviceVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.xmlbeans.impl.jam.provider.ResourcePath;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 监测设备读写
 *
 * @author zhoujing
 * @version 1.0
 * @since 2023/8/15 17:12
 */
@Component
@Slf4j
public class MonitorDeviceReadWrite {

    /**
     * 读取文件
     *
     * @param resourceFilePath 文件路径
     * @return List<MonitorDeviceVO>
     */
    public List<MonitorDeviceVO> readFile(String resourceFilePath) {
        // 获取resource文件的路径
        URL resourceUrl = ResourcePath.class.getResource(resourceFilePath);

        // 这里默认每次会读取100条数据 然后返回过来 直接调用使用数据就行
        // 具体需要返回多少行可以在`PageReadListener`的构造函数设置
        List<MonitorDeviceVO> monitorDevices = new ArrayList<>();
        assert resourceUrl != null;
        EasyExcel.read(resourceUrl.getPath(), MonitorDeviceDTO.class, new PageReadListener<MonitorDeviceDTO>(dataList -> {
                    for (MonitorDeviceDTO deviceDTO : dataList) {
                        log.info("读取到一条数据{}", JSON.toJSONString(deviceDTO));
                        MonitorDeviceVO monitorDeviceVO = MonitorDeviceVO.builder()
                                .pointLocationMsg(deviceDTO.getPointLocationMsg())
                                .channelName(deviceDTO.getChannelName())
                                .sensorCategory(deviceDTO.getSensorCategory())
                                .serialNo(deviceDTO.getSerialNo())
                                .dataKey(deviceDTO.getDataKey())
                                .build();
                        monitorDevices.add(monitorDeviceVO);
                    }
                }))
                .registerConverter(new CustomStringConverter())  // 注册自定义转换器
                .extraRead(CellExtraTypeEnum.MERGE)   // 读取合并单元格 todo 未实现
                .sheet(3).doRead();

        // 存在合并单元格处理：设备通道、传感器类别
        String channelName = "";
        String sensorCategory = "";
        for (MonitorDeviceVO monitorDevice : monitorDevices) {
            if (monitorDevice.getChannelName() == null) {
                monitorDevice.setChannelName(channelName);
            } else {
                channelName = monitorDevice.getChannelName();
            }
            if (monitorDevice.getSensorCategory() == null) {
                monitorDevice.setSensorCategory(sensorCategory);
            } else {
                sensorCategory = monitorDevice.getSensorCategory();
            }
        }

        return monitorDevices;
    }


    /**
     * 封装监测设备
     *
     * @param monitorDevices 监测设备
     */
    public void packageMonitorDevices(List<MonitorDeviceVO> monitorDevices) {
        int serialNo = 1;
        for (MonitorDeviceVO monitorDevice : monitorDevices) {
            // 名称截取点位详情左括号前一截
            monitorDevice.setName(monitorDevice.getPointLocationMsg().substring(0, monitorDevice.getPointLocationMsg().indexOf("（")));
            // 设备类型：1-应力监测，2-裂纹监测
            monitorDevice.setType(1);
            // 传感器类别：1-单向应变，2-温补
            if (monitorDevice.getSensorCategory().contains("单向应变")) {
                monitorDevice.setSensorCategory("1");
            } else if (monitorDevice.getSensorCategory().contains("温补")) {
                monitorDevice.setSensorCategory("2");
            }
            // 设备序列号生成规则：通道名称4位（不足补零）+传感器类别1位（不足补零）+ 5位序列号
            String channelName = monitorDevice.getChannelName();
            if (channelName.length() < 4) {
                // CH01这种，补零
                channelName = channelName.substring(0, 2) + "0" + channelName.charAt(2);
            }
            monitorDevice.setCode(channelName + monitorDevice.getSensorCategory() + String.format("%05d", serialNo++));
        }
    }

    /**
     * 写入文件
     *
     * @param resourceFilePath 文件路径
     * @param monitorDevices   监测设备
     */
    public void writeFile(String resourceFilePath, List<MonitorDeviceVO> monitorDevices) {
        URL resourceUrl = ResourcePath.class.getResource(resourceFilePath);
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        assert resourceUrl != null;
        EasyExcel.write(resourceUrl.getPath(), MonitorDeviceVO.class)
                .sheet("模板")
                .doWrite(monitorDevices);
    }
}
