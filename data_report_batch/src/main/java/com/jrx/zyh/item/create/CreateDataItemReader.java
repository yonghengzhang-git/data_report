package com.jrx.zyh.item.create;

import com.jrx.zyh.model.Customer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
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
