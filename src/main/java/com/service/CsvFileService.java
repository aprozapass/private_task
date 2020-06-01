package com.service;

import com.model.redis.RedisCsvFile;

import java.io.InputStream;
import java.util.List;

public interface CsvFileService {
    boolean exists(String id);
    void save(String id, InputStream is);
    List<RedisCsvFile> findAll();
}
