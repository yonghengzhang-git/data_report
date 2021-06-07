package com.jrx.zyh.model.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author Java实习-张永恒
 * @date 2021/6/6 14:55
 * @describe
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageInfo<T> implements Serializable {

    /**
     * 页码
     */
    private Integer pageNum;
    /**
     * 页大小
     */
    private Integer pageSize = 20;
    /**
     * 总记录数
     */
    private Integer count;
    /**
     * 总页数
     */
    private Integer pages;
    /**
     * 数据
     */
    private List<T> list;

}
