package com.jrx.zyh.item.create;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.RandomUtil;
import com.jrx.zyh.model.Customer;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.batch.item.ItemProcessor;
import utils.RandomPersonInfoUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Java实习-张永恒
 * @date 2021/6/1 15:47
 * @describe
 */
public class CreateDataItemProcessor<I,O> implements ItemProcessor<I,O> {


    @Override
    public O process(I i) throws Exception {
        return null;
    }
}
