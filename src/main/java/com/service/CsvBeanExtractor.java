package com.service;

import com.model.csv.CsvBean;

import java.io.Reader;
import java.util.List;

public interface CsvBeanExtractor<T extends CsvBean> {
    List<T> extractBeans(Reader reader);
}
