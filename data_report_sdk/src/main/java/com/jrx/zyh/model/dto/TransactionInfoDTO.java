package com.jrx.zyh.model.dto;

import com.jrx.zyh.model.enums.TransTypeEnum;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class TransactionInfoDTO {

    private Integer transId;

    private Integer custId;

//    private String surname;

    private String account;

    private String cardNbr;

    private Long tranNo;

    private Integer monthNbr;

    private BigDecimal bill;

    private String transType;

    private Date txnDatetime;

    private static final long serialVersionUID = 1L;

    public TransactionInfoDTO( Integer custId, String account, String cardNbr, Long tranno, Integer monthNbr, BigDecimal bill, TransTypeEnum transType, Date txnDatetime) {
        this.custId = custId;
        this.account = account;
        this.cardNbr = cardNbr;
        this.tranNo = tranno;
        this.monthNbr = monthNbr;
        this.bill = bill;
        this.transType = transType.getParam();
        this.txnDatetime = txnDatetime;
    }
}
