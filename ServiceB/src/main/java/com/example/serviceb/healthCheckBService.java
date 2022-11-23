package com.example.serviceb;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class healthCheckBService {

    private final healthCheckBRepository healthCheckBRepository;


    public healthCheck addHealthCheck(healthCheck healthCheck) {
        return healthCheckBRepository.save(healthCheck);
    }

    public healthCheck getHealthCheck(Long id) {
        return healthCheckBRepository.findById(id).get();
    }

    public healthCheck updateHealthCheck(healthCheck healthCheck ,Long id) {
        healthCheck changeHealthCheck = healthCheckBRepository.findById(id).get();
        changeHealthCheck.setStatus(healthCheck.isStatus());

        return healthCheckBRepository.save(changeHealthCheck);
    }

    public void deleteHealthCheck(Long id) {
        healthCheckBRepository.deleteById(id);
    }

    public List<healthCheck> getHealthCheckB() {
        return healthCheckBRepository.findAll();
    }

    public checkServiceB getServiceStatus() {
        return new checkServiceB("Service B", "OK");
    }
}
