package com.example.servicea;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class healthCheckAController {

    private final healthCheckAService healthCheckAService;

    private final WebClient webClient = WebClient.builder().build();

    @PostMapping(value = "/add/health/")
    private healthCheck addHealthCheck(@RequestBody healthCheck healthCheck) {
        return healthCheckAService.addHealthCheck(healthCheck);
    }

    @PutMapping(value = "/update/health/{id}")
    private healthCheck updateHealthCheck(@RequestBody healthCheck healthCheck, @PathVariable Long id) {
        return healthCheckAService.updateHealthCheck(healthCheck, id);
    }

    @GetMapping(value = "/get/health/{id}")
    private healthCheck getHealthCheck(@PathVariable Long id) {
        return healthCheckAService.getHealthCheck(id);
    }

    @DeleteMapping(value = "/health/{id}")
    private void deleteHealthCheck(@PathVariable Long id) {
        healthCheckAService.deleteHealthCheck(id);
    }

    @GetMapping(value = "/health/check")
    private List<healthCheck> getAllHealthCheck() {
        return healthCheckAService.getHealthCheckA();
    }

    @GetMapping(value = "/check/service")
    private checkServiceA getCheckService() {
        return healthCheckAService.getServiceStatus();
    }

    @GetMapping(value = "/health/")
    public List<checkServiceA> getHealth() {

        return List.of(
                Objects.requireNonNull(webClient.get()
                        .uri("localhost:8081/check/service")
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .retrieve()
                        .bodyToMono(checkServiceA.class)
                        .block()),

                Objects.requireNonNull(webClient.get()
                        .uri("localhost:8082/check/service")
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .retrieve()
                        .bodyToMono(checkServiceA.class).block())
        );

    }

}
