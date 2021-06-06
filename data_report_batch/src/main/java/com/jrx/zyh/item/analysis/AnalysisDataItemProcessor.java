package com.jrx.zyh.item.analysis;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jrx.zyh.model.DailySummary;
import com.jrx.zyh.model.TransactionInfo;
import com.jrx.zyh.model.dto.TransactionInfoDTO;
import com.jrx.zyh.model.dto.TransactionInfoMapDTO;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Java实习-张永恒
 * @date 2021/6/2 17:29
 * @describe 分析汇总的处理过程
 */
@Component
public class AnalysisDataItemProcessor<I, O> implements ItemProcessor<TransactionInfoMapDTO, DailySummary> {
    @Override
    public DailySummary process(TransactionInfoMapDTO mapDTO) throws Exception {

        List<TransactionInfoDTO> value = mapDTO.getList();

        //客户id
        Integer custId = value.get(0).getCustId();
        //修改时间
        Date update = new Date(System.currentTimeMillis());
        //消费日期
        Date transDate = value.get(0).getTxnDatetime();
        //客户姓名
        String surname = mapDTO.getName();
        //最大单笔交易金额
        BigDecimal maxAmt = value.stream()
                .max(Comparator.comparing(TransactionInfoDTO::getBill))
                .get().getBill();
        //还款总额
        BigDecimal paySum = value.stream().
                filter(t -> t.getTransType().equals("还款"))
                .map(TransactionInfoDTO::getBill)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        //消费总数
        Integer tranCount = (int) value.stream()
                .filter(t -> t.getTransType().equals("消费"))
                .count();
        //还款总数
        Integer payCount = (int) value.stream()
                .filter(t -> t.getTransType().equals("还款"))
                .count();
        //交易总额
        BigDecimal tranAmt = value.stream()
                .map(TransactionInfoDTO::getBill)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        //创建DailySummary对象并放入集合中
        DailySummary summary = new DailySummary(null, custId, update, transDate, surname, maxAmt, paySum, tranCount, payCount, tranAmt);

        return summary;
    }
}
