package com.student.management.controller

import com.student.management.domain.Student
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController()
@RequestMapping("/api/v1/students")
@CrossOrigin
class StudentController {

    @GetMapping
    fun getAll() : List<Student> {

        var students = listOf<Student>(Student(1,"ntwari",34))

        return students;

    }

}