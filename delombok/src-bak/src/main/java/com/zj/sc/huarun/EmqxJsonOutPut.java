package com.zj.sc.huarun;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhoujing
 * @version 1.0
 * @since 2023/11/13 19:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmqxJsonOutPut {

    /**
     * 名称
     */
    private String name;

    /**
     * 类型
     */
    private String type;
}
