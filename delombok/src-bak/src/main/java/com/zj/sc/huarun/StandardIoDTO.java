package com.zj.sc.huarun;

import lombok.Data;

import java.util.List;

@Data
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
}
