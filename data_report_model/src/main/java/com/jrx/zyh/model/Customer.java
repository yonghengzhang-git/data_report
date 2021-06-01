package com.jrx.zyh.model;

import com.jrx.zyh.model.enums.EducationEnum;
import com.jrx.zyh.model.enums.MarriageEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Java实习-张永恒
 * @date 2021/5/30 11:05
 * @describe 客户
 */
@Data
@NoArgsConstructor
public class Customer implements Serializable {

    private Integer custId;

    private String surname;

    private Byte gender;

    private String educaDes;

    private String marDes;

    private Integer birthday;

    private String address;

    private static final long serialVersionUID = 1L;


    /**
     * 枚举创建对象
     */
    public Customer(String surname, Integer gender, EducationEnum educaDes, MarriageEnum marDes, Integer birthday, String address) {
        this.custId = null;
        this.surname = surname;
        this.gender = gender.byteValue();
        this.educaDes = educaDes.getParam();
        this.marDes = marDes.getParam();
        this.birthday = birthday;
        this.address = address;
    }

}
