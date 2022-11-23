package com.example.servicea;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface healthCheckARepository extends JpaRepository<healthCheck, Long> {
}
