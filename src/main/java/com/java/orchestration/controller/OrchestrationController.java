package com.java.orchestration.controller;

import com.java.orchestration.models.StudentWithParents;
import com.java.orchestration.models.StudentsParentsAndTeachersResponse;
import com.java.orchestration.models.TeachersResponse;
import com.java.orchestration.service.StudentService;
import com.java.orchestration.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrchestrationController {

    @Autowired
    StudentService studentService;

    @Autowired
    TeacherService teacherService;

    @GetMapping("/api/helloFromOrchestration")
    public ResponseEntity<?> fetchAllDetails() {
        return ResponseEntity.ok().body("helloFromStudent = " + studentService.getHelloWorld() + "\n" + "helloFromTeacher = " + teacherService.getHelloWorld());
    }

    @GetMapping("/api/students/{studentInput}/{className}")
    public ResponseEntity<?> fetchStudentDetailsWithTeachersOnSameClass(@PathVariable("studentInput") Long studentInput, @PathVariable("className") String className) {
        StudentWithParents studentWithParents = studentService.getStudentParent(studentInput);

        List<TeachersResponse> teachersResponse = teacherService.getTeachersByClassName(className);

        StudentsParentsAndTeachersResponse studentsParentsAndTeachersResponse = StudentsParentsAndTeachersResponse.builder()
                .firstName(studentWithParents.getFirstName())
                .lastName(studentWithParents.getLastName())
                .className(studentWithParents.getClassName())
                .dateOfBirth(studentWithParents.getDateOfBirth())
                .rollNumber(studentWithParents.getRollNumber())
                .studentEmailId(studentWithParents.getStudentEmailId())
                .fatherName(studentWithParents.getFatherName())
                .motherName(studentWithParents.getMotherName())
                .teachersResponseList(teachersResponse)
                .build();


        return ResponseEntity.ok().body(studentsParentsAndTeachersResponse);
    }
}
