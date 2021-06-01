package com.jrx.zyh.step;

import com.jrx.zyh.model.Customer;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Java实习-张永恒
 * @date 2021/5/31 21:05
 * @describe
 */
@Configuration
public class CreateDataStepConfig {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Autowired
    @Qualifier("createdDataItemWriter")
    private ItemWriter createdDataItemWriter;

    @Bean
    public Step createStep(){
        return stepBuilderFactory.get("createStep")
                .<Customer,Customer>chunk(2)
                .writer(createdDataItemWriter)
                .build();
    }

}
