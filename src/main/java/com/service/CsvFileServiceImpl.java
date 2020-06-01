package com.service;

import com.converter.ClientConverter;
import com.converter.CsvFileConverter;
import com.model.csv.ClientCsvBean;
import com.model.db.ClientEntity;
import com.model.db.CsvFileEntity;
import com.model.db.repos.CsvFileDBRepository;
import com.model.redis.RedisCsvFile;
import com.model.redis.repos.CsvFileRedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class CsvFileServiceImpl implements CsvFileService {

    private final CsvFileRedisRepository csvFileRedisRepository;

    private final CsvFileDBRepository csvFileDBRepository;

    private final ClientConverter clientConverter;

    private final CsvFileConverter csvFileConverter;

    @Autowired
    public CsvFileServiceImpl(CsvFileRedisRepository csvFileRedisRepository,
                              CsvFileDBRepository csvFileDBRepository,
                              ClientConverter clientConverter,
                              CsvFileConverter csvFileConverter) {
        this.csvFileRedisRepository = csvFileRedisRepository;
        this.csvFileDBRepository = csvFileDBRepository;
        this.clientConverter = clientConverter;
        this.csvFileConverter = csvFileConverter;
    }

    @Override
    public boolean exists(String originalName) {
        return csvFileRedisRepository.findById(originalName).isPresent();
    }


    @Override
    public void save(String originalName, InputStream is) {
        CsvBeanExtractorImpl extractor = new CsvBeanExtractorImpl();
        List<ClientCsvBean> clientCsvBeans = extractor.extractBeans(new InputStreamReader(is));
        List<ClientEntity> clientEntities = clientConverter.convertAll(clientCsvBeans);
        CsvFileEntity CsvFileEntity = new CsvFileEntity(originalName, clientEntities);
        csvFileDBRepository.save(CsvFileEntity);
        RedisCsvFile redisCsvFile = csvFileConverter.convert(CsvFileEntity);
        csvFileRedisRepository.save(redisCsvFile);
    }

    @Override
    public List<RedisCsvFile> findAll() {
        return csvFileRedisRepository.findAll();
    }
}
