package com.java.orchestration.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StudentWithParents {

    @JsonProperty("rollNumber")
    Long rollNumber;

    @JsonProperty("firstName")
    String firstName;

    @JsonProperty("lastName")
    String lastName;

    @JsonProperty("dateOfBirth")
    Date dateOfBirth;

    @JsonProperty("studentEmailId")
    String studentEmailId;

    @JsonProperty("className")
    String className;

    @JsonProperty("fatherName")
    String fatherName;

    @JsonProperty("motherName")
    String motherName;
}
