package com.jrx.zyh.web.controller;

import com.jrx.zyh.service.IDailySummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Java实习-张永恒
 * @date 2021/6/6 14:43
 * @describe
 */
//@RestController
public class DailySummaryController {

    @Autowired
    private IDailySummaryService dailySummaryService;


}
