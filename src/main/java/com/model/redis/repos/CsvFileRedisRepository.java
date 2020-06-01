package com.model.redis.repos;

import com.model.redis.RedisCsvFile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CsvFileRedisRepository extends CrudRepository<RedisCsvFile, String> {
    List<RedisCsvFile> findAll();
}
