package com.jrx.zyh.step;

import com.jrx.zyh.item.analysis.AnalysisDataItemProcessor;
import com.jrx.zyh.item.analysis.AnalysisDataItemReader;
import com.jrx.zyh.item.analysis.AnalysisDataItemWriter;
import com.jrx.zyh.model.DailySummary;
import com.jrx.zyh.model.dto.TransactionInfoDTO;
import com.jrx.zyh.model.dto.TransactionInfoMapDTO;
import com.jrx.zyh.util.DateUtil;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author Java实习-张永恒
 * @date 2021/6/5 15:58
 * @describe
 */
@Configuration
public class AnalysisDataStepConfig {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    @Autowired
    private AnalysisDataItemProcessor itemProcessor;

    @Bean
    public Step analysisDataStep(){
        return stepBuilderFactory.get("analysisDataStep")
                .<TransactionInfoMapDTO,DailySummary>chunk(100)
                .reader(tranInfoReader())
                .processor(itemProcessor)
                .writer(dailySummaryWriter())
                .build();
    }

    @Bean
    public AnalysisDataItemWriter dailySummaryWriter() {
        return new AnalysisDataItemWriter(sqlSessionFactory);
    }

    @Bean
    public AnalysisDataItemReader tranInfoReader(){
        HashMap<String, Object> map = new HashMap<>();
        try {
            map.put("date", DateUtil.parseDate("2021-1-1"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new AnalysisDataItemReader(sqlSessionFactory,map);
    }


}
