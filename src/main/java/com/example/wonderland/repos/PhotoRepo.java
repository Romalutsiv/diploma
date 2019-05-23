package com.example.wonderland.repos;

import com.example.wonderland.domain.PhotoReport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface PhotoRepo extends CrudRepository<PhotoReport, Long> {
    Page<PhotoReport> findAll(Pageable pageable);

}
