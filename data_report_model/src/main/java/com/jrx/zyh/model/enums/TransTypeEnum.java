package com.jrx.zyh.model.enums;

/**
 * @author Java实习-张永恒
 * @date 2021/5/30 16:59
 * @describe
 */
public enum TransTypeEnum {

    //交易类型
    CONSUMPTION("消费"),
    REPAYMENT("还款")

    ;

    private String param;

    TransTypeEnum(String param) {
        this.param = param;
    }

    public String getParam() {
        return param;
    }

}
