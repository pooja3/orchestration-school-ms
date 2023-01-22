package com.java.orchestration.models;

import lombok.*;

import java.sql.Date;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentsParentsAndTeachersResponse {

    Long rollNumber;

    String firstName;

    String lastName;

    Date dateOfBirth;

    String studentEmailId;

    String className;

    String fatherName;

    String motherName;

    List<TeachersResponse> teachersResponseList;

}
