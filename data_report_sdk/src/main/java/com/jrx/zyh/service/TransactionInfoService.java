package com.jrx.zyh.service;

import com.jrx.zyh.model.TransactionInfo;
import com.jrx.zyh.model.dto.TransactionInfoDTO;
import com.jrx.zyh.model.dto.TransactionInfoMapDTO;

import java.util.Date;
import java.util.List;

/**
 * @author Java实习-张永恒
 * @date 2021/5/31 9:29
 */
public interface TransactionInfoService {

    List<TransactionInfo> findAll();

//    List<TransactionInfoDTO> findTranByDate(Date date);
    List<TransactionInfoMapDTO> findTranByDate(Date date);
}
