package com.example.servicec;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class healthCheckCController {

    private final healthCheckCService healthCheckCService;

    private final WebClient webClient = WebClient.builder().build();

    @PostMapping(value = "/add/health/")
    private healthCheck addHealthCheck(@RequestBody healthCheck healthCheck) {
        return healthCheckCService.addHealthCheck(healthCheck);
    }

    @PutMapping(value = "/update/health/{id}")
    private healthCheck updateHealthCheck(@RequestBody healthCheck healthCheck, @PathVariable Long id) {
        return healthCheckCService.updateHealthCheck(healthCheck, id);
    }

    @GetMapping(value = "/get/health/{id}")
    private healthCheck getHealthCheck(@PathVariable Long id) {
        return healthCheckCService.getHealthCheck(id);
    }

    @DeleteMapping(value = "/health/{id}")
    private void deleteHealthCheck(@PathVariable Long id) {
        healthCheckCService.deleteHealthCheck(id);
    }

    @GetMapping(value = "/health/check")
    private List<healthCheck> getAllHealthCheck() {
        return healthCheckCService.getHealthCheckC();
    }

    @GetMapping(value = "/check/service")
    private checkServiceC getCheckService() {
        return healthCheckCService.getServiceStatus();
    }

    @GetMapping(value = "/health/")
    public List<checkServiceC> getHealth() {

        return List.of(
                Objects.requireNonNull(webClient.get()
                        .uri("localhost:8080/check/service")
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .retrieve()
                        .bodyToMono(checkServiceC.class)
                        .block()),

                Objects.requireNonNull(webClient.get()
                        .uri("localhost:8081/check/service")
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .retrieve()
                        .bodyToMono(checkServiceC.class).block())
        );

    }


}
