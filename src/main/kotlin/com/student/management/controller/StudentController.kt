package com.student.management.controller

import com.student.management.domain.Student
import com.student.management.dtos.StudentDto
import com.student.management.serviceImpl.StudentServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
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
    fun addStudent(@RequestBody student: StudentDto) : ResponseEntity<Any> {

        var savedStudent : Student = studentService.addStudent(student);

        return ResponseEntity.ok(savedStudent)
    }

    @GetMapping("/byid/{id}")
    fun getStudentById(@RequestParam id: Long) : Student {

        return studentService.getStudentById(id);

    }

    @PutMapping("/update/{id}")
    fun updateStudent(@RequestParam id: Long, @RequestParam student: StudentDto) : Student {

        return studentService.updateStudent(id, student);

    }

    @DeleteMapping("/delete/{id}")
    fun deleteStudent(id: Long) : Student {

        return studentService.deleteStudent(id);

    }




}