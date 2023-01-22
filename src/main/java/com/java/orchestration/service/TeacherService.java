package com.java.orchestration.service;

import com.java.orchestration.models.TeachersResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    @Qualifier("teacherWebClient")
    WebClient teacherWebClient;

    public String getHelloWorld() {
        return teacherWebClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/teacher/hello-world/{input}")
                        .build("23")
                )
                .headers(
                        httpHeaders -> {
                            httpHeaders.set("Accept", "application/octet-stream");
                        })
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    public List<TeachersResponse> getTeachersByClassName(String className) {
        return teacherWebClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/teachers/{classname}")
                        .build(className)
                )
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<TeachersResponse>>() {
                })
                .block();
    }
}