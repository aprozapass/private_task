package com.model.db.repos;

import com.model.db.CsvFileEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CsvFileDBRepository extends CrudRepository<CsvFileEntity, String> {
}
