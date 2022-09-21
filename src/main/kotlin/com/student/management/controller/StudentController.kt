package com.student.management.controller

import com.student.management.domain.Student
import com.student.management.dtos.StudentDto
import com.student.management.serviceImpl.StudentServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController()
@RequestMapping("/api/v1/students")
@CrossOrigin
class StudentController (
        @Autowired
        private val studentService: StudentServiceImpl

     ){

    @GetMapping
    fun getAll() : List<Student> {

        return studentService.getAllStudents();

    }

    @PostMapping
    fun addStudent(student: StudentDto) : Student {

        return studentService.addStudent(student);

    }


}