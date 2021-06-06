package com.jrx.zyh.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Java实习-张永恒
 * @date 2021/5/31 20:56
 * @describe
 */

//@Configuration
public class SimulatedDataJobConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    @Qualifier("createCustStep")
    private Step createCustStep;

    @Autowired
    @Qualifier("createTranStep")
    private Step createTranStep;

    /**
     * 批量生产客户信息的job
     * @return
     */
    @Bean
    public Job simulatedCustDataJob(){
        return jobBuilderFactory.get("simulatedCustDataJob")
                .incrementer(new RunIdIncrementer())
                .start(createCustStep)
                .build();
    }

    /**
     * 批量生产交易记录信息的job
     * @return
     */
    @Bean
    public Job simulatedTranDataJob(){
        return jobBuilderFactory.get("simulatedTranDataJob")
                .incrementer(new RunIdIncrementer())
                .start(createTranStep)
                .build();
    }



}
