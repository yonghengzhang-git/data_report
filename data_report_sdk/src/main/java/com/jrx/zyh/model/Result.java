package com.jrx.zyh.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Java实习-张永恒
 * @date 2021/6/6 14:17
 * @describe
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {

    /**
     * 返回码
     */
    private Integer code;

    /**
     * 返回内容
     */
    private T data;

    /**
     * 异常提示信息
     */
    private String message;

    /**
     * 响应时间戳
     */
    private Long timestamp;

    /**
     * 响应处理耗时长
     */
    private Long duration;

}
