package com.mx.globant.repository;

import com.mx.globant.Entity.History;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends CrudRepository<History, Long> {

    @Override
    List<History> findAll();
}
