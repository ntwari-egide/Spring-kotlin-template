package com.student.management.serviceImpl

import com.student.management.domain.Student
import com.student.management.dtos.StudentDto
import com.student.management.repository.StudentRepository
import com.student.management.service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class StudentServiceImpl
    (

    @Autowired
    private val studentRepository: StudentRepository

    ) : StudentService{

    fun checkExistence(id: Long): Student {
        var studentFound : Optional<Student> = studentRepository.findById(id.toLong());

        if(! studentFound.isPresent() ) throw Error("Student with id ${id} is  not present!")

        return studentFound.get();
    }

    override fun getStudentById(id: Long): Student {

        return checkExistence(id)
    }

    override fun getAllStudents(): List<Student> {

        return studentRepository.findAll()
    }

    override fun addStudent(student: StudentDto): Student {

        var newStudent : Student = Student(student.name, student.age, student.address)

        return studentRepository.save(newStudent)
    }

    override fun updateStudent(id: Long,student: StudentDto): Student {

        checkExistence(id);

        var updatedStudent : Student = Student(student.name, student.age, student.address)
        updatedStudent.id = id

        return studentRepository.save(updatedStudent)

    }

    override fun deleteStudent(id: Long): Student {

        var studentFound : Student =  checkExistence(id);

        studentRepository.deleteById(id)

        return studentFound
    }

    override fun getStudentByAddress(address: String): List<Student> {

            return studentRepository.findByAddress(address)
    }
}