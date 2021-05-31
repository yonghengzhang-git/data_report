package com.jrx.zyh.model.enums;

public enum MarriageEnum {

    //婚姻情况
    UNMARRIED("未婚"),
    FIRST_MARRIAGE("初婚"),
    REMARRIED("再婚"),
    REMARRIAGE("复婚"),
    DIVORCE("离婚"),
    WIDOWED("丧偶"),

    ;

    private String param;

    MarriageEnum(String param) {
        this.param = param;
    }

    public String getParam() {
        return param;
    }

}
