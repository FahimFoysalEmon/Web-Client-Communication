package com.example.servicea;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class healthCheckAService {

    private final healthCheckARepository healthCheckARepository;

    public List<healthCheck> getHealthCheckA() {
        return healthCheckARepository.findAll();
    }


    public healthCheck addHealthCheck(healthCheck healthCheck) {
        return healthCheckARepository.save(healthCheck);
    }

    public healthCheck getHealthCheck(Long id) {
        return healthCheckARepository.findById(id).get();
    }

    public healthCheck updateHealthCheck(healthCheck healthCheck ,Long id) {
        healthCheck changeHealthCheck = healthCheckARepository.findById(id).get();
        changeHealthCheck.setStatus(healthCheck.isStatus());

        return healthCheckARepository.save(changeHealthCheck);
    }

    public void deleteHealthCheck(Long id) {
        healthCheckARepository.deleteById(id);
    }

    public checkServiceA getServiceStatus() {
        return new checkServiceA("Service A", "OK");
    }
}
