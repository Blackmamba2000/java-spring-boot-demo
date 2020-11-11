package com.karlking.demo.service;

import com.karlking.demo.dao.StudentDao;
import com.karlking.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    // Reference to the FakeStudentDao Implementation (Depe
    private final StudentDao studentDao;

    @Autowired
    public StudentService(@Qualifier("mysqlDbDao") StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public int insertNewStudent(UUID studentID, Student student){
        UUID studentUID = studentID == null ? UUID.randomUUID() : studentID;
        student.setId(studentID);
        return studentDao.insertNewStudent(studentUID, student);
    }

    public Student getStudentID(UUID studentID){
        return studentDao.selectStudentByID(studentID);
    }

    public List<Student> getAllStudents(){
        return studentDao.selectAllStudents();
    }

    public int updateStudentByID(UUID student, Student studentUpdate){
        studentUpdate.setId(student);
        return studentDao.updateStudentByID(student, studentUpdate);
    }

    public int deleteStudentByID(UUID studentID){
        return studentDao.deleteStudentByID(studentID);
    }
}
