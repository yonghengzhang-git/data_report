package com.jrx.zyh.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Java实习-张永恒
 * @date 2021/5/30 11:06
 * @describe 日汇总
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DailySummary implements Serializable {

    private Integer sId;

    private Integer custId;

    private Date updateTime;

    private Date transDate;

    private String surname;

    private BigDecimal tranMaxAmt;

    private BigDecimal payAmt;

    private Integer tranCnt;

    private Integer payCnt;

    private BigDecimal tranAmt;

    private static final long serialVersionUID = 1L;

}
