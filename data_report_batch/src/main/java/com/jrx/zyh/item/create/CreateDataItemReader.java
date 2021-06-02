package com.jrx.zyh.item.create;

import org.springframework.batch.item.support.ListItemReader;

import java.util.List;

/**
 * @author Java实习-张永恒
 * @date 2021/6/1 15:46
 * @describe
 */
public class CreateDataItemReader<T> extends ListItemReader<T> {

    public CreateDataItemReader(List<T> list) {
        super(list);
    }
}
