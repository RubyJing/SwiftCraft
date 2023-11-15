package com.zj.sc.huarun;

import cn.hutool.core.util.ReflectUtil;

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

    public String getGroup() {
        return this.group;
    }

    public String getName() {
        return this.name;
    }

    public Integer getAddress() {
        return this.address;
    }

    public String getAttribute() {
        return this.attribute;
    }

    public String getType() {
        return this.type;
    }

    public String getDescription() {
        return this.description;
    }

    public String getPrecision() {
        return this.precision;
    }

    public String getDecimal() {
        return this.decimal;
    }

    public String getValue() {
        return this.value;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Integer address) {
        this.address = address;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrecision(String precision) {
        this.precision = precision;
    }

    public void setDecimal(String decimal) {
        this.decimal = decimal;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof IoOutputEntity)) return false;
        final IoOutputEntity other = (IoOutputEntity) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$group = this.getGroup();
        final Object other$group = other.getGroup();
        if (this$group == null ? other$group != null : !this$group.equals(other$group)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$address = this.getAddress();
        final Object other$address = other.getAddress();
        if (this$address == null ? other$address != null : !this$address.equals(other$address)) return false;
        final Object this$attribute = this.getAttribute();
        final Object other$attribute = other.getAttribute();
        if (this$attribute == null ? other$attribute != null : !this$attribute.equals(other$attribute)) return false;
        final Object this$type = this.getType();
        final Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description))
            return false;
        final Object this$precision = this.getPrecision();
        final Object other$precision = other.getPrecision();
        if (this$precision == null ? other$precision != null : !this$precision.equals(other$precision)) return false;
        final Object this$decimal = this.getDecimal();
        final Object other$decimal = other.getDecimal();
        if (this$decimal == null ? other$decimal != null : !this$decimal.equals(other$decimal)) return false;
        final Object this$value = this.getValue();
        final Object other$value = other.getValue();
        if (this$value == null ? other$value != null : !this$value.equals(other$value)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof IoOutputEntity;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $group = this.getGroup();
        result = result * PRIME + ($group == null ? 43 : $group.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $address = this.getAddress();
        result = result * PRIME + ($address == null ? 43 : $address.hashCode());
        final Object $attribute = this.getAttribute();
        result = result * PRIME + ($attribute == null ? 43 : $attribute.hashCode());
        final Object $type = this.getType();
        result = result * PRIME + ($type == null ? 43 : $type.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        final Object $precision = this.getPrecision();
        result = result * PRIME + ($precision == null ? 43 : $precision.hashCode());
        final Object $decimal = this.getDecimal();
        result = result * PRIME + ($decimal == null ? 43 : $decimal.hashCode());
        final Object $value = this.getValue();
        result = result * PRIME + ($value == null ? 43 : $value.hashCode());
        return result;
    }

    public String toString() {
        return "IoOutputEntity(group=" + this.getGroup() + ", name=" + this.getName() + ", address=" + this.getAddress() + ", attribute=" + this.getAttribute() + ", type=" + this.getType() + ", description=" + this.getDescription() + ", precision=" + this.getPrecision() + ", decimal=" + this.getDecimal() + ", value=" + this.getValue() + ")";
    }
}
