package com.jrx.zyh.model;

import com.jrx.zyh.model.enums.TransTypeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Java实习-张永恒
 * @date 2021/5/30 11:08
 * @describe 交易订单详情
 */

@Data
@NoArgsConstructor
public class TransactionInfo {

    private Integer transId;

    private Integer custId;

    private String account;

    private String cardNbr;

    private Integer tranno;

    private Integer monthNbr;

    private BigDecimal bill;

    private String transType;

    private Date txnDatetime;

    private static final long serialVersionUID = 1L;

    public TransactionInfo(Integer transId, Integer custId, String account, String cardNbr, Integer tranno, Integer monthNbr, BigDecimal bill, TransTypeEnum transType, Date txnDatetime) {
        this.transId = transId;
        this.custId = custId;
        this.account = account;
        this.cardNbr = cardNbr;
        this.tranno = tranno;
        this.monthNbr = monthNbr;
        this.bill = bill;
        this.transType = transType.getParam();
        this.txnDatetime = txnDatetime;
    }
}
