package com.lmeng.blog.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @version 1.0
 * @learner Lmeng
 * @date 2023/7/24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultUtil {
    private boolean success;

    private Integer code;

    private String msg;

    private Object data;

    public static ResultUtil success(Object data) {
        return new ResultUtil(true,200,"success",data);
    }
    public static ResultUtil fail(Integer code, String msg) {
        return new ResultUtil(false,code,msg,null);
    }
}
