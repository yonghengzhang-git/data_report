package com.jrx.zyh.service;

import com.jrx.zyh.model.DailySummary;

import java.util.List;

/**
 * @author Java实习-张永恒
 * @date 2021/5/31 9:31
 */
public interface IDailySummaryService {

    List<DailySummary> findAll();

}
