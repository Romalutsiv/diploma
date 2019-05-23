package com.example.wonderland.repos;

import com.example.wonderland.domain.ReservMessage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface RevMesRepo extends CrudRepository<ReservMessage, Long> {
    Page<ReservMessage> findAll(Pageable pageable);
}
