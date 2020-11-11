package com.karlking.demo.dao;

import com.karlking.demo.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("mysqlDbDao")
public class MySQLStudentDaoImpl implements StudentDao {

    //private final MySQLDbTemplate mysqlDbTemplate;

    @Override
    public int insertNewStudent(UUID studentID, Student student) {
        return 0;
    }

    @Override
    public Student selectStudentByID(UUID studentID) {
        return null;
    }

    @Override
    public List<Student> selectAllStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(UUID.randomUUID(), 15, "MySQL", "DB", "database"));
        return students;
    }

    @Override
    public int updateStudentByID(UUID student, Student studentUpdate) {
        return 0;
    }

    @Override
    public int deleteStudentByID(UUID studentID) {
        return 0;
    }
}
