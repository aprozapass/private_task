package com.service;

import com.model.csv.ClientCsvBean;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;

import java.io.Reader;
import java.util.List;

@Service
public class CsvBeanExtractorImpl implements CsvBeanExtractor<ClientCsvBean> {
    @Override
    public List<ClientCsvBean> extractBeans(Reader reader) {

        ColumnPositionMappingStrategy<ClientCsvBean> ms
                = new ColumnPositionMappingStrategy<>();
        ms.setType(ClientCsvBean.class);
        CsvToBean<ClientCsvBean> cb
                = new CsvToBeanBuilder<ClientCsvBean>(reader)
                .withSkipLines(1)
                .withType(ClientCsvBean.class)
                .withMappingStrategy(ms)
                .build();
        return cb.parse();
    }
}
