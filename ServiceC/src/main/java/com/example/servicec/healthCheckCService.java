package com.example.servicec;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class healthCheckCService {

    private final healthCheckCRepository healthCheckCRepository;

    public healthCheck addHealthCheck(healthCheck healthCheck) {
        return healthCheckCRepository.save(healthCheck);
    }

    public healthCheck getHealthCheck(Long id) {
        return healthCheckCRepository.findById(id).get();
    }

    public healthCheck updateHealthCheck(healthCheck healthCheck ,Long id) {
        healthCheck changeHealthCheck = healthCheckCRepository.findById(id).get();
        changeHealthCheck.setStatus(healthCheck.isStatus());

        return healthCheckCRepository.save(changeHealthCheck);
    }

    public void deleteHealthCheck(Long id) {
        healthCheckCRepository.deleteById(id);
    }

    public List<healthCheck> getHealthCheckC() {
        return healthCheckCRepository.findAll();
    }

    public checkServiceC getServiceStatus() {
        return new checkServiceC("Service C", "OK");
    }
}
