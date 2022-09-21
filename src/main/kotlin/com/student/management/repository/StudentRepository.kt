package com.student.management.repository

import com.student.management.domain.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.net.Inet4Address

@Repository
interface StudentRepository : JpaRepository<Student, Long> {
    fun findByAddress(address: String): List<Student>
}