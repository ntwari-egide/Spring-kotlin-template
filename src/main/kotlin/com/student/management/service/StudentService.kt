package com.student.management.service

import com.student.management.domain.Student
import com.student.management.dtos.StudentDto
import org.springframework.stereotype.Service

@Service
interface StudentService {
    fun getStudentById(id: Long): Student

    fun getAllStudents(): List<Student>

    fun addStudent(student: StudentDto): Student

    fun updateStudent(id: Long,student: StudentDto): Student

    fun deleteStudent(id: Long) : Student

    fun getStudentByAddress(address: String): List<Student>

}