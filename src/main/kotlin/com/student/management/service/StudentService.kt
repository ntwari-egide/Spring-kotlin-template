package com.student.management.service

import com.student.management.domain.Student
import org.springframework.stereotype.Service

@Service
interface StudentService {
    fun getStudentById(id: Int): Student

    fun getAllStudents(): List<Student>

    fun addStudent(student: Student): Student

    fun updateStudent(student: Student): Student

    fun deleteStudent(id: Int)

    fun getStudentByAddress(address: String): List<Student>

}