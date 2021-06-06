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
 * @date 2021/6/5 15:57
 * @describe
 */
@Configuration
public class AnalysisDataJobConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    @Qualifier("analysisDataStep")
    private Step analysisDataStep;

    @Bean
    public Job analysisDataJob(){
        return jobBuilderFactory.get("analysisDataJob")
                .incrementer(new RunIdIncrementer())
                .start(analysisDataStep)
                .build();
    }

}
