package com.jrx.zyh.model.dto;

import lombok.Data;

import java.util.List;

/**
 * @author Java实习-张永恒
 * @date 2021/6/2 17:51
 * @describe
 */
@Data
public class TransactionInfoMapDTO {
    private String name;
    private List<TransactionInfoDTO> list;

}
