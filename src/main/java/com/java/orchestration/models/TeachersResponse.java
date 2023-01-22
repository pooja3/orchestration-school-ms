package com.java.orchestration.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TeachersResponse {

    @JsonProperty("teacherName")
    String teacherName;

    @JsonProperty("emailId")
    String emailId;

    @JsonProperty("phoneNumber")
    String phoneNumber;

    @JsonProperty("teacherTitle")
    String teacherTitle;

    @JsonProperty("className")
    String className;
}
