package com.converter;

import com.model.db.CsvFileEntity;
import com.model.redis.RedisCsvFile;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
final public class CsvFileConverter implements Converter<CsvFileEntity, RedisCsvFile> {

    @Override
    public RedisCsvFile convert(CsvFileEntity CsvFileEntity) {
        return new RedisCsvFile(CsvFileEntity.getOriginalName());
    }
}
