package com.jrx.zyh.model.enums;

public enum EducationEnum {

    //受教育情况
    ILLITERACY("文盲"),
    PRIMARY_SCHOOL("小学"),
    MIDDLE_SCHOOL("初中"),
    HIGH_SCHOOL("高中"),
    COLLEGE("大专"),
    UNDERGRADUATE("本科"),
    POSTGRADUATE("研究生"),

    ;

    private String param;

    EducationEnum(String param) {
        this.param = param;
    }

    public String getParam() {
        return param;
    }

}
