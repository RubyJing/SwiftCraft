package com.zj.sc.huarun;

import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.ReflectUtil;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class IoOutputEntity {
    private String group;
    private String name;
    private Integer address;
    private String attribute;
    private String type;
    private String description;
    private String precision;
    private String decimal;
    private String value;

    public IoOutputEntity(StandardIoDTO standardIo, IoConfigEntity entity) {
        this.group = entity.getDevice_code();
        this.name = standardIo.getIo_name();
        this.attribute = IoConfigUtils.attributeMap.get(standardIo.getType());
        this.type = IoConfigUtils.typeMap.get(standardIo.getType());
        this.description = standardIo.getIo_desc();
        Integer address = Integer.parseInt(standardIo.getAddress() + "");
        Integer startIndex = Integer.parseInt(ReflectUtil.getFieldValue(entity, IoConfigUtils.startIndexMap.get(standardIo.getType())) + "");
        this.address = address + startIndex; //需要判定并累加
    }

    public IoOutputEntity(String group, String name, String attribute, String type, String value) {
        this.group = group;
        this.name = name;
        this.attribute = attribute;
        this.type = type;
        this.value = value;
    }

}
