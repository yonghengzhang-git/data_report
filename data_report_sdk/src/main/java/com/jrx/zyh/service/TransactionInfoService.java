package com.jrx.zyh.service;

import com.jrx.zyh.model.TransactionInfo;

import java.util.List;

/**
 * @author Java实习-张永恒
 * @date 2021/5/31 9:29
 */
public interface TransactionInfoService {

    List<TransactionInfo> findAll();

}
