package com.example.servicec;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface healthCheckCRepository extends JpaRepository<healthCheck, Long> {
}
