package com.java.orchestration.service;

import com.java.orchestration.models.StudentWithParents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class StudentService {

    @Autowired
    @Qualifier("studentWebClient")
    WebClient studentWebClient;

    public String getHelloWorld() {
        return studentWebClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/student/hello-world/{input}")
                        .build("28")
                )
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    public StudentWithParents getStudentParent(final Long studentInput) {
        return studentWebClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/students/parent/{studentId}")
                        .build(studentInput)
                )
                .retrieve()
                .bodyToMono(StudentWithParents.class)
                .block();
    }
}
