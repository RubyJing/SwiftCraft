package com.zj.sc.huarun;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.util.StrUtil;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
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
        if(null == o) return 0;
        String data = o + "";
        if(StrUtil.isEmpty(data)) return 0;
        if(CollUtil.contains(emptyCellNames, data)) return 0;
        return Integer.parseInt(o + "");
    }

}
