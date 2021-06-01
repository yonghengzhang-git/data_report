package com.jrx.zyh.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Java实习-张永恒
 * @date 2021/5/31 20:56
 * @describe
 */

@Configuration
public class SimulatedDataJobConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    @Qualifier("createStep")
    private Step createStep;

    @Bean
    public Job simulatedDataJob(){
        return jobBuilderFactory.get("simulatedDataJob")
                .start(createStep)
                .build();
    }



}
