package com.zj.sc.huarun;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.util.StrUtil;
import lombok.experimental.Accessors;

import java.util.List;

@Accessors(chain = true)
public class IoConfigEntity {

    private static final List<String> emptyCellNames = ListUtil.of("M", "N", "O", "P", "Q");

    private Integer port;
    private String station_code;
    private String device_code;
    private String device_type;
    private String time_unit;
    private String region_com_id;
    private String project_com_id;
    private String maintenance_com_id;
    private String manufacturer;
    private String model;
    private String line;
    private String period;
    private Integer ycStart;
    private Integer yxStart;
    private Integer ymStart;
    private Integer ykStart;
    private Integer ytStart;

    public IoConfigEntity(List<Object> datas) {
        this.port = Integer.parseInt(datas.get(0) + "");
        this.station_code = (String) datas.get(1);
        this.device_code = (String) datas.get(2);
        this.device_type = (String) datas.get(3);
        this.time_unit = (String) datas.get(4);
        this.region_com_id = (String) datas.get(5);
        this.project_com_id = (String) datas.get(6);
        this.maintenance_com_id = (String) datas.get(7);
        this.manufacturer = (String) datas.get(8);
        this.model = (String) datas.get(9);
        this.line = (String) datas.get(10);
        this.period = (String) datas.get(11);
        this.ycStart = datas.size() > 12 ? convert(datas.get(12)) : 0;
        this.yxStart = datas.size() > 13 ? convert(datas.get(13)) : 0;
        this.ymStart = datas.size() > 14 ? convert(datas.get(14)) : 0;
        this.ykStart = datas.size() > 15 ? convert(datas.get(15)) : 0;
        this.ytStart = datas.size() > 16 ? convert(datas.get(16)) : 0;
    }

    private Integer convert(Object o) {
        if (null == o) return 0;
        String data = o + "";
        if (StrUtil.isEmpty(data)) return 0;
        if (CollUtil.contains(emptyCellNames, data)) return 0;
        return Integer.parseInt(o + "");
    }

    public Integer getPort() {
        return this.port;
    }

    public String getStation_code() {
        return this.station_code;
    }

    public String getDevice_code() {
        return this.device_code;
    }

    public String getDevice_type() {
        return this.device_type;
    }

    public String getTime_unit() {
        return this.time_unit;
    }

    public String getRegion_com_id() {
        return this.region_com_id;
    }

    public String getProject_com_id() {
        return this.project_com_id;
    }

    public String getMaintenance_com_id() {
        return this.maintenance_com_id;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public String getModel() {
        return this.model;
    }

    public String getLine() {
        return this.line;
    }

    public String getPeriod() {
        return this.period;
    }

    public Integer getYcStart() {
        return this.ycStart;
    }

    public Integer getYxStart() {
        return this.yxStart;
    }

    public Integer getYmStart() {
        return this.ymStart;
    }

    public Integer getYkStart() {
        return this.ykStart;
    }

    public Integer getYtStart() {
        return this.ytStart;
    }

    public IoConfigEntity setPort(Integer port) {
        this.port = port;
        return this;
    }

    public IoConfigEntity setStation_code(String station_code) {
        this.station_code = station_code;
        return this;
    }

    public IoConfigEntity setDevice_code(String device_code) {
        this.device_code = device_code;
        return this;
    }

    public IoConfigEntity setDevice_type(String device_type) {
        this.device_type = device_type;
        return this;
    }

    public IoConfigEntity setTime_unit(String time_unit) {
        this.time_unit = time_unit;
        return this;
    }

    public IoConfigEntity setRegion_com_id(String region_com_id) {
        this.region_com_id = region_com_id;
        return this;
    }

    public IoConfigEntity setProject_com_id(String project_com_id) {
        this.project_com_id = project_com_id;
        return this;
    }

    public IoConfigEntity setMaintenance_com_id(String maintenance_com_id) {
        this.maintenance_com_id = maintenance_com_id;
        return this;
    }

    public IoConfigEntity setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    public IoConfigEntity setModel(String model) {
        this.model = model;
        return this;
    }

    public IoConfigEntity setLine(String line) {
        this.line = line;
        return this;
    }

    public IoConfigEntity setPeriod(String period) {
        this.period = period;
        return this;
    }

    public IoConfigEntity setYcStart(Integer ycStart) {
        this.ycStart = ycStart;
        return this;
    }

    public IoConfigEntity setYxStart(Integer yxStart) {
        this.yxStart = yxStart;
        return this;
    }

    public IoConfigEntity setYmStart(Integer ymStart) {
        this.ymStart = ymStart;
        return this;
    }

    public IoConfigEntity setYkStart(Integer ykStart) {
        this.ykStart = ykStart;
        return this;
    }

    public IoConfigEntity setYtStart(Integer ytStart) {
        this.ytStart = ytStart;
        return this;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof IoConfigEntity)) return false;
        final IoConfigEntity other = (IoConfigEntity) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$port = this.getPort();
        final Object other$port = other.getPort();
        if (this$port == null ? other$port != null : !this$port.equals(other$port)) return false;
        final Object this$station_code = this.getStation_code();
        final Object other$station_code = other.getStation_code();
        if (this$station_code == null ? other$station_code != null : !this$station_code.equals(other$station_code))
            return false;
        final Object this$device_code = this.getDevice_code();
        final Object other$device_code = other.getDevice_code();
        if (this$device_code == null ? other$device_code != null : !this$device_code.equals(other$device_code))
            return false;
        final Object this$device_type = this.getDevice_type();
        final Object other$device_type = other.getDevice_type();
        if (this$device_type == null ? other$device_type != null : !this$device_type.equals(other$device_type))
            return false;
        final Object this$time_unit = this.getTime_unit();
        final Object other$time_unit = other.getTime_unit();
        if (this$time_unit == null ? other$time_unit != null : !this$time_unit.equals(other$time_unit)) return false;
        final Object this$region_com_id = this.getRegion_com_id();
        final Object other$region_com_id = other.getRegion_com_id();
        if (this$region_com_id == null ? other$region_com_id != null : !this$region_com_id.equals(other$region_com_id))
            return false;
        final Object this$project_com_id = this.getProject_com_id();
        final Object other$project_com_id = other.getProject_com_id();
        if (this$project_com_id == null ? other$project_com_id != null : !this$project_com_id.equals(other$project_com_id))
            return false;
        final Object this$maintenance_com_id = this.getMaintenance_com_id();
        final Object other$maintenance_com_id = other.getMaintenance_com_id();
        if (this$maintenance_com_id == null ? other$maintenance_com_id != null : !this$maintenance_com_id.equals(other$maintenance_com_id))
            return false;
        final Object this$manufacturer = this.getManufacturer();
        final Object other$manufacturer = other.getManufacturer();
        if (this$manufacturer == null ? other$manufacturer != null : !this$manufacturer.equals(other$manufacturer))
            return false;
        final Object this$model = this.getModel();
        final Object other$model = other.getModel();
        if (this$model == null ? other$model != null : !this$model.equals(other$model)) return false;
        final Object this$line = this.getLine();
        final Object other$line = other.getLine();
        if (this$line == null ? other$line != null : !this$line.equals(other$line)) return false;
        final Object this$period = this.getPeriod();
        final Object other$period = other.getPeriod();
        if (this$period == null ? other$period != null : !this$period.equals(other$period)) return false;
        final Object this$ycStart = this.getYcStart();
        final Object other$ycStart = other.getYcStart();
        if (this$ycStart == null ? other$ycStart != null : !this$ycStart.equals(other$ycStart)) return false;
        final Object this$yxStart = this.getYxStart();
        final Object other$yxStart = other.getYxStart();
        if (this$yxStart == null ? other$yxStart != null : !this$yxStart.equals(other$yxStart)) return false;
        final Object this$ymStart = this.getYmStart();
        final Object other$ymStart = other.getYmStart();
        if (this$ymStart == null ? other$ymStart != null : !this$ymStart.equals(other$ymStart)) return false;
        final Object this$ykStart = this.getYkStart();
        final Object other$ykStart = other.getYkStart();
        if (this$ykStart == null ? other$ykStart != null : !this$ykStart.equals(other$ykStart)) return false;
        final Object this$ytStart = this.getYtStart();
        final Object other$ytStart = other.getYtStart();
        if (this$ytStart == null ? other$ytStart != null : !this$ytStart.equals(other$ytStart)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof IoConfigEntity;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $port = this.getPort();
        result = result * PRIME + ($port == null ? 43 : $port.hashCode());
        final Object $station_code = this.getStation_code();
        result = result * PRIME + ($station_code == null ? 43 : $station_code.hashCode());
        final Object $device_code = this.getDevice_code();
        result = result * PRIME + ($device_code == null ? 43 : $device_code.hashCode());
        final Object $device_type = this.getDevice_type();
        result = result * PRIME + ($device_type == null ? 43 : $device_type.hashCode());
        final Object $time_unit = this.getTime_unit();
        result = result * PRIME + ($time_unit == null ? 43 : $time_unit.hashCode());
        final Object $region_com_id = this.getRegion_com_id();
        result = result * PRIME + ($region_com_id == null ? 43 : $region_com_id.hashCode());
        final Object $project_com_id = this.getProject_com_id();
        result = result * PRIME + ($project_com_id == null ? 43 : $project_com_id.hashCode());
        final Object $maintenance_com_id = this.getMaintenance_com_id();
        result = result * PRIME + ($maintenance_com_id == null ? 43 : $maintenance_com_id.hashCode());
        final Object $manufacturer = this.getManufacturer();
        result = result * PRIME + ($manufacturer == null ? 43 : $manufacturer.hashCode());
        final Object $model = this.getModel();
        result = result * PRIME + ($model == null ? 43 : $model.hashCode());
        final Object $line = this.getLine();
        result = result * PRIME + ($line == null ? 43 : $line.hashCode());
        final Object $period = this.getPeriod();
        result = result * PRIME + ($period == null ? 43 : $period.hashCode());
        final Object $ycStart = this.getYcStart();
        result = result * PRIME + ($ycStart == null ? 43 : $ycStart.hashCode());
        final Object $yxStart = this.getYxStart();
        result = result * PRIME + ($yxStart == null ? 43 : $yxStart.hashCode());
        final Object $ymStart = this.getYmStart();
        result = result * PRIME + ($ymStart == null ? 43 : $ymStart.hashCode());
        final Object $ykStart = this.getYkStart();
        result = result * PRIME + ($ykStart == null ? 43 : $ykStart.hashCode());
        final Object $ytStart = this.getYtStart();
        result = result * PRIME + ($ytStart == null ? 43 : $ytStart.hashCode());
        return result;
    }

    public String toString() {
        return "IoConfigEntity(port=" + this.getPort() + ", station_code=" + this.getStation_code() + ", device_code=" + this.getDevice_code() + ", device_type=" + this.getDevice_type() + ", time_unit=" + this.getTime_unit() + ", region_com_id=" + this.getRegion_com_id() + ", project_com_id=" + this.getProject_com_id() + ", maintenance_com_id=" + this.getMaintenance_com_id() + ", manufacturer=" + this.getManufacturer() + ", model=" + this.getModel() + ", line=" + this.getLine() + ", period=" + this.getPeriod() + ", ycStart=" + this.getYcStart() + ", yxStart=" + this.getYxStart() + ", ymStart=" + this.getYmStart() + ", ykStart=" + this.getYkStart() + ", ytStart=" + this.getYtStart() + ")";
    }
}
