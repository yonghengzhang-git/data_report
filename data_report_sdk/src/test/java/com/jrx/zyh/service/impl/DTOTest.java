package com.jrx.zyh.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.jrx.zyh.DataReportSdkApplication;
import com.jrx.zyh.mapper.CustomerMapper;
import com.jrx.zyh.model.Customer;
import com.jrx.zyh.model.dto.TransactionInfoMapDTO;
import com.jrx.zyh.service.ITransactionInfoService;
import com.jrx.zyh.util.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.util.*;

/**
 * @author Java实习-张永恒
 * @date 2021/6/3 10:41
 * @describe
 */

@SpringBootTest(classes = DataReportSdkApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class DTOTest {

    @Autowired
    private ITransactionInfoService service;

/*    @Test
    public void test01() throws ParseException, JsonProcessingException {

        List<TransactionInfoDTO> list = service.findTranByDate(DateUtil.parseDate("2021-1-1"));
        Map<Integer, List<TransactionInfoDTO>> map = list.stream().collect(Collectors.groupingBy(TransactionInfoDTO::getCustId));

        ArrayList<DailySummary> dailySummaries = new ArrayList<>();

        for (Map.Entry<Integer, List<TransactionInfoDTO>> entry : map.entrySet()) {

            Integer key = entry.getKey();
            List<TransactionInfoDTO> value = entry.getValue();

            Integer custId = value.get(0).getCustId();
            Date update = new Date(System.currentTimeMillis());
            Date transDate = value.get(0).getTxnDatetime();
            String surname = value.get(0).getSurname();
            BigDecimal maxAmt = value.stream().max(Comparator.comparing(TransactionInfoDTO::getBill)).get().getBill();
            BigDecimal paySum = value.stream().filter(t -> t.getTransType().equals("还款")).map(TransactionInfoDTO::getBill).reduce(BigDecimal.ZERO, BigDecimal::add);
            Integer tranCount = (int)value.stream().filter(t -> t.getTransType().equals("消费")).count();
            Integer payCount = (int)value.stream().filter(t -> t.getTransType().equals("还款")).count();
            BigDecimal tranAmt = value.stream().map(TransactionInfoDTO::getBill).reduce(BigDecimal.ZERO, BigDecimal::add);

            DailySummary summary = new DailySummary(null, custId, update, transDate, surname, maxAmt, paySum, tranCount, payCount, tranAmt);

            dailySummaries.add(summary);

        }

        String s = new ObjectMapper().writeValueAsString(dailySummaries);
        System.out.println(s);

    }*/

/*    @Test
    public void test02() throws ParseException, JsonProcessingException {
        List<TransactionInfoDTO> list = service.findTranByDate(DateUtil.parseDate("2021-1-1"));
        String s = new ObjectMapper().writeValueAsString(list);
        System.out.println(s);
    }*/

    @Test
    public void test03() throws ParseException, JsonProcessingException {
        List<TransactionInfoMapDTO> tran = service.findTranByDate(DateUtil.parseDate("2021-1-1"));
        String s1 = new Gson().toJson(tran);
//        String s = new ObjectMapper().writeValueAsString(tran);
        System.out.println(s1);
    }

    @Autowired
    private CustomerMapper customerMapper;

    @Test
    public void test04(){
        List<Customer> list = customerMapper.selectByCondition(1,null,null);
        Integer count = customerMapper.countByCondition(null,null);

        System.out.println(list);
        System.out.println(count);

    }

}
