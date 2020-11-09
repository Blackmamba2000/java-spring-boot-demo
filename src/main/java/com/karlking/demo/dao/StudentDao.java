package com.karlking.demo.dao;

import com.karlking.demo.model.Student;

import java.util.List;
import java.util.UUID;

public interface StudentDao {

    int insertNewStudent(UUID studentID, Student student);

    Student selectStudentByID(UUID studentID);

    List<Student> selectAllStudents();

    int updateStudentByID(UUID student, Student studentUpdate);

    int deleteStudentByID(UUID studentID);
}
