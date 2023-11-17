//package com.zj.sc.excel.entity.vo;
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
//public class MonitorDeviceVO {
//
//    /**
//     * 设备名称
//     */
//    @ExcelProperty(index = 0, value = "name")
//    private String name;
//
//    /**
//     * 设备序列号
//     */
//    @ExcelProperty(index = 1, value = "serial_no")
//    private String serialNo;
//
//    /**
//     * 设备编码
//     */
//    @ExcelProperty(index = 2, value = "code")
//    private String code;
//
//    /**
//     * 设备通道名称
//     */
//    @ExcelProperty(index = 3, value = "channel_name")
//    private String channelName;
//
//    /**
//     * 测点位置
//     */
//    @ExcelProperty(index = 4, value = "point_location_msg")
//    private String pointLocationMsg;
//
//    /**
//     * 设备类型
//     */
//    @ExcelProperty(index = 5, value = "type")
//    private Integer type;
//
//    /**
//     * 传感器类别
//     */
//    @ExcelProperty(index = 6, value = "sensor_category")
//    private String sensorCategory;
//
//    /**
//     * 数据标识
//     */
//    @ExcelProperty(index = 7, value = "data_key")
//    private String dataKey;
//
//
//    public MonitorDeviceVO(String name, String serialNo, String code, String channelName, String pointLocationMsg, Integer type, String sensorCategory, String dataKey) {
//        this.name = name;
//        this.serialNo = serialNo;
//        this.code = code;
//        this.channelName = channelName;
//        this.pointLocationMsg = pointLocationMsg;
//        this.type = type;
//        this.sensorCategory = sensorCategory;
//        this.dataKey = dataKey;
//    }
//
//    public MonitorDeviceVO() {
//    }
//
//    public static MonitorDeviceVOBuilder builder() {
//        return new MonitorDeviceVOBuilder();
//    }
//
//    public String getName() {
//        return this.name;
//    }
//
//    public String getSerialNo() {
//        return this.serialNo;
//    }
//
//    public String getCode() {
//        return this.code;
//    }
//
//    public String getChannelName() {
//        return this.channelName;
//    }
//
//    public String getPointLocationMsg() {
//        return this.pointLocationMsg;
//    }
//
//    public Integer getType() {
//        return this.type;
//    }
//
//    public String getSensorCategory() {
//        return this.sensorCategory;
//    }
//
//    public String getDataKey() {
//        return this.dataKey;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setSerialNo(String serialNo) {
//        this.serialNo = serialNo;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }
//
//    public void setChannelName(String channelName) {
//        this.channelName = channelName;
//    }
//
//    public void setPointLocationMsg(String pointLocationMsg) {
//        this.pointLocationMsg = pointLocationMsg;
//    }
//
//    public void setType(Integer type) {
//        this.type = type;
//    }
//
//    public void setSensorCategory(String sensorCategory) {
//        this.sensorCategory = sensorCategory;
//    }
//
//    public void setDataKey(String dataKey) {
//        this.dataKey = dataKey;
//    }
//
//    public boolean equals(final Object o) {
//        if (o == this) return true;
//        if (!(o instanceof MonitorDeviceVO)) return false;
//        final MonitorDeviceVO other = (MonitorDeviceVO) o;
//        if (!other.canEqual((Object) this)) return false;
//        final Object this$name = this.getName();
//        final Object other$name = other.getName();
//        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
//        final Object this$serialNo = this.getSerialNo();
//        final Object other$serialNo = other.getSerialNo();
//        if (this$serialNo == null ? other$serialNo != null : !this$serialNo.equals(other$serialNo)) return false;
//        final Object this$code = this.getCode();
//        final Object other$code = other.getCode();
//        if (this$code == null ? other$code != null : !this$code.equals(other$code)) return false;
//        final Object this$channelName = this.getChannelName();
//        final Object other$channelName = other.getChannelName();
//        if (this$channelName == null ? other$channelName != null : !this$channelName.equals(other$channelName))
//            return false;
//        final Object this$pointLocationMsg = this.getPointLocationMsg();
//        final Object other$pointLocationMsg = other.getPointLocationMsg();
//        if (this$pointLocationMsg == null ? other$pointLocationMsg != null : !this$pointLocationMsg.equals(other$pointLocationMsg))
//            return false;
//        final Object this$type = this.getType();
//        final Object other$type = other.getType();
//        if (this$type == null ? other$type != null : !this$type.equals(other$type)) return false;
//        final Object this$sensorCategory = this.getSensorCategory();
//        final Object other$sensorCategory = other.getSensorCategory();
//        if (this$sensorCategory == null ? other$sensorCategory != null : !this$sensorCategory.equals(other$sensorCategory))
//            return false;
//        final Object this$dataKey = this.getDataKey();
//        final Object other$dataKey = other.getDataKey();
//        if (this$dataKey == null ? other$dataKey != null : !this$dataKey.equals(other$dataKey)) return false;
//        return true;
//    }
//
//    protected boolean canEqual(final Object other) {
//        return other instanceof MonitorDeviceVO;
//    }
//
//    public int hashCode() {
//        final int PRIME = 59;
//        int result = 1;
//        final Object $name = this.getName();
//        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
//        final Object $serialNo = this.getSerialNo();
//        result = result * PRIME + ($serialNo == null ? 43 : $serialNo.hashCode());
//        final Object $code = this.getCode();
//        result = result * PRIME + ($code == null ? 43 : $code.hashCode());
//        final Object $channelName = this.getChannelName();
//        result = result * PRIME + ($channelName == null ? 43 : $channelName.hashCode());
//        final Object $pointLocationMsg = this.getPointLocationMsg();
//        result = result * PRIME + ($pointLocationMsg == null ? 43 : $pointLocationMsg.hashCode());
//        final Object $type = this.getType();
//        result = result * PRIME + ($type == null ? 43 : $type.hashCode());
//        final Object $sensorCategory = this.getSensorCategory();
//        result = result * PRIME + ($sensorCategory == null ? 43 : $sensorCategory.hashCode());
//        final Object $dataKey = this.getDataKey();
//        result = result * PRIME + ($dataKey == null ? 43 : $dataKey.hashCode());
//        return result;
//    }
//
//    public String toString() {
//        return "MonitorDeviceVO(name=" + this.getName() + ", serialNo=" + this.getSerialNo() + ", code=" + this.getCode() + ", channelName=" + this.getChannelName() + ", pointLocationMsg=" + this.getPointLocationMsg() + ", type=" + this.getType() + ", sensorCategory=" + this.getSensorCategory() + ", dataKey=" + this.getDataKey() + ")";
//    }
//
//    public static class MonitorDeviceVOBuilder {
//        private String name;
//        private String serialNo;
//        private String code;
//        private String channelName;
//        private String pointLocationMsg;
//        private Integer type;
//        private String sensorCategory;
//        private String dataKey;
//
//        MonitorDeviceVOBuilder() {
//        }
//
//        public MonitorDeviceVOBuilder name(String name) {
//            this.name = name;
//            return this;
//        }
//
//        public MonitorDeviceVOBuilder serialNo(String serialNo) {
//            this.serialNo = serialNo;
//            return this;
//        }
//
//        public MonitorDeviceVOBuilder code(String code) {
//            this.code = code;
//            return this;
//        }
//
//        public MonitorDeviceVOBuilder channelName(String channelName) {
//            this.channelName = channelName;
//            return this;
//        }
//
//        public MonitorDeviceVOBuilder pointLocationMsg(String pointLocationMsg) {
//            this.pointLocationMsg = pointLocationMsg;
//            return this;
//        }
//
//        public MonitorDeviceVOBuilder type(Integer type) {
//            this.type = type;
//            return this;
//        }
//
//        public MonitorDeviceVOBuilder sensorCategory(String sensorCategory) {
//            this.sensorCategory = sensorCategory;
//            return this;
//        }
//
//        public MonitorDeviceVOBuilder dataKey(String dataKey) {
//            this.dataKey = dataKey;
//            return this;
//        }
//
//        public MonitorDeviceVO build() {
//            return new MonitorDeviceVO(this.name, this.serialNo, this.code, this.channelName, this.pointLocationMsg, this.type, this.sensorCategory, this.dataKey);
//        }
//
//        public String toString() {
//            return "MonitorDeviceVO.MonitorDeviceVOBuilder(name=" + this.name + ", serialNo=" + this.serialNo + ", code=" + this.code + ", channelName=" + this.channelName + ", pointLocationMsg=" + this.pointLocationMsg + ", type=" + this.type + ", sensorCategory=" + this.sensorCategory + ", dataKey=" + this.dataKey + ")";
//        }
//    }
//}
