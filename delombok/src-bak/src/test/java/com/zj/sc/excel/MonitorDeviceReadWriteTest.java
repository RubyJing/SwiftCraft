package com.zj.sc.excel;

import com.zj.sc.SwiftCraftApplicationTests;
import com.zj.sc.excel.entity.vo.MonitorDeviceVO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 监测设备读写测试
 *
 * @author zhoujing
 * @version 1.0
 * @since 2023/8/15 17:09
 */
public class MonitorDeviceReadWriteTest extends SwiftCraftApplicationTests {

    @Autowired
    private MonitorDeviceReadWrite monitorDeviceReadWrite;

    @Test
    public void testReadFile() throws InterruptedException {
        List<MonitorDeviceVO> monitorDeviceVOS = monitorDeviceReadWrite.readFile("/dgj_device_yl.xlsx");
//        List<MonitorDeviceVO> monitorDeviceVOS = monitorDeviceReadWrite.readFile("file\\dgj\\dgj_device_yl.xlsx");
        monitorDeviceVOS.remove(0);
        monitorDeviceReadWrite.packageMonitorDevices(monitorDeviceVOS);

        monitorDeviceReadWrite.writeFile("/dgj_device_yl_sql.xlsx", monitorDeviceVOS);

//        Thread.sleep(1000000);
    }

}
