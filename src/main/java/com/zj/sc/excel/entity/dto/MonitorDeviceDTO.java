//package com.zj.sc.excel.entity.dto;
//
//import com.alibaba.excel.annotation.ExcelProperty;
//
///**
// * 监测设备DTO
// *
// * @author zhoujing
// * @version 1.0
// * @since 2023/8/15 17:13
// */
//public class MonitorDeviceDTO {
//    /**
//     * 测点位置
//     */
//    @ExcelProperty(index = 1)
//    private String pointLocationMsg;
//
//    /**
//     * 设备通道名称
//     */
//    @ExcelProperty(index = 3)
//    private String channelName;
//
//    /**
//     * 传感器类别
//     */
//    @ExcelProperty(index = 4)
//    private String sensorCategory;
//
//    /**
//     * 设备序列号
//     */
//    @ExcelProperty(index = 5)
//    private String serialNo;
//
//    /**
//     * 数据标识
//     */
//    @ExcelProperty(index = 13)
//    private String dataKey;
//
//    public MonitorDeviceDTO() {
//    }
//
//    public String getPointLocationMsg() {
//        return this.pointLocationMsg;
//    }
//
//    public String getChannelName() {
//        return this.channelName;
//    }
//
//    public String getSensorCategory() {
//        return this.sensorCategory;
//    }
//
//    public String getSerialNo() {
//        return this.serialNo;
//    }
//
//    public String getDataKey() {
//        return this.dataKey;
//    }
//
//    public void setPointLocationMsg(String pointLocationMsg) {
//        this.pointLocationMsg = pointLocationMsg;
//    }
//
//    public void setChannelName(String channelName) {
//        this.channelName = channelName;
//    }
//
//    public void setSensorCategory(String sensorCategory) {
//        this.sensorCategory = sensorCategory;
//    }
//
//    public void setSerialNo(String serialNo) {
//        this.serialNo = serialNo;
//    }
//
//    public void setDataKey(String dataKey) {
//        this.dataKey = dataKey;
//    }
//
//    public boolean equals(final Object o) {
//        if (o == this) return true;
//        if (!(o instanceof MonitorDeviceDTO)) return false;
//        final MonitorDeviceDTO other = (MonitorDeviceDTO) o;
//        if (!other.canEqual((Object) this)) return false;
//        final Object this$pointLocationMsg = this.getPointLocationMsg();
//        final Object other$pointLocationMsg = other.getPointLocationMsg();
//        if (this$pointLocationMsg == null ? other$pointLocationMsg != null : !this$pointLocationMsg.equals(other$pointLocationMsg))
//            return false;
//        final Object this$channelName = this.getChannelName();
//        final Object other$channelName = other.getChannelName();
//        if (this$channelName == null ? other$channelName != null : !this$channelName.equals(other$channelName))
//            return false;
//        final Object this$sensorCategory = this.getSensorCategory();
//        final Object other$sensorCategory = other.getSensorCategory();
//        if (this$sensorCategory == null ? other$sensorCategory != null : !this$sensorCategory.equals(other$sensorCategory))
//            return false;
//        final Object this$serialNo = this.getSerialNo();
//        final Object other$serialNo = other.getSerialNo();
//        if (this$serialNo == null ? other$serialNo != null : !this$serialNo.equals(other$serialNo)) return false;
//        final Object this$dataKey = this.getDataKey();
//        final Object other$dataKey = other.getDataKey();
//        if (this$dataKey == null ? other$dataKey != null : !this$dataKey.equals(other$dataKey)) return false;
//        return true;
//    }
//
//    protected boolean canEqual(final Object other) {
//        return other instanceof MonitorDeviceDTO;
//    }
//
//    public int hashCode() {
//        final int PRIME = 59;
//        int result = 1;
//        final Object $pointLocationMsg = this.getPointLocationMsg();
//        result = result * PRIME + ($pointLocationMsg == null ? 43 : $pointLocationMsg.hashCode());
//        final Object $channelName = this.getChannelName();
//        result = result * PRIME + ($channelName == null ? 43 : $channelName.hashCode());
//        final Object $sensorCategory = this.getSensorCategory();
//        result = result * PRIME + ($sensorCategory == null ? 43 : $sensorCategory.hashCode());
//        final Object $serialNo = this.getSerialNo();
//        result = result * PRIME + ($serialNo == null ? 43 : $serialNo.hashCode());
//        final Object $dataKey = this.getDataKey();
//        result = result * PRIME + ($dataKey == null ? 43 : $dataKey.hashCode());
//        return result;
//    }
//
//    public String toString() {
//        return "MonitorDeviceDTO(pointLocationMsg=" + this.getPointLocationMsg() + ", channelName=" + this.getChannelName() + ", sensorCategory=" + this.getSensorCategory() + ", serialNo=" + this.getSerialNo() + ", dataKey=" + this.getDataKey() + ")";
//    }
//}
