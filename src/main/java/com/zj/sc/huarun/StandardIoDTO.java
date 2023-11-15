package com.zj.sc.huarun;

import java.util.List;

public class StandardIoDTO {
    private String type;
    private String io_name;
    private String io_desc;
    private Integer address;

    public StandardIoDTO(List<Object> datas) {
        this.type = (String) datas.get(0);
        this.io_name = (String) datas.get(1);
        this.io_desc = (String) datas.get(2);
        this.address = Integer.parseInt(datas.get(3) + "");
    }

    public String getType() {
        return this.type;
    }

    public String getIo_name() {
        return this.io_name;
    }

    public String getIo_desc() {
        return this.io_desc;
    }

    public Integer getAddress() {
        return this.address;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setIo_name(String io_name) {
        this.io_name = io_name;
    }

    public void setIo_desc(String io_desc) {
        this.io_desc = io_desc;
    }

    public void setAddress(Integer address) {
        this.address = address;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof StandardIoDTO)) return false;
        final StandardIoDTO other = (StandardIoDTO) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$type = this.getType();
        final Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) return false;
        final Object this$io_name = this.getIo_name();
        final Object other$io_name = other.getIo_name();
        if (this$io_name == null ? other$io_name != null : !this$io_name.equals(other$io_name)) return false;
        final Object this$io_desc = this.getIo_desc();
        final Object other$io_desc = other.getIo_desc();
        if (this$io_desc == null ? other$io_desc != null : !this$io_desc.equals(other$io_desc)) return false;
        final Object this$address = this.getAddress();
        final Object other$address = other.getAddress();
        if (this$address == null ? other$address != null : !this$address.equals(other$address)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof StandardIoDTO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $type = this.getType();
        result = result * PRIME + ($type == null ? 43 : $type.hashCode());
        final Object $io_name = this.getIo_name();
        result = result * PRIME + ($io_name == null ? 43 : $io_name.hashCode());
        final Object $io_desc = this.getIo_desc();
        result = result * PRIME + ($io_desc == null ? 43 : $io_desc.hashCode());
        final Object $address = this.getAddress();
        result = result * PRIME + ($address == null ? 43 : $address.hashCode());
        return result;
    }

    public String toString() {
        return "StandardIoDTO(type=" + this.getType() + ", io_name=" + this.getIo_name() + ", io_desc=" + this.getIo_desc() + ", address=" + this.getAddress() + ")";
    }
}
