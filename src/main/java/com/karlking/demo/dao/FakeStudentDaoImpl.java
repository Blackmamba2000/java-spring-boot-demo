package com.karlking.demo.dao;

import com.karlking.demo.model.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository("fakeDao")
public class FakeStudentDaoImpl implements StudentDao{

    private final Map<UUID, Student> database;

    public FakeStudentDaoImpl() {
        database = new HashMap<>();
        UUID studentId = UUID.randomUUID();
        database.put(studentId, new Student(studentId, 35, "Karl", "King", "Intro to Angular"));
    }

    @Override
    public int insertNewStudent(UUID studentID, Student student) {
        database.put(studentID, student);
        return 1;
    }

    @Override
    public Student selectStudentByID(UUID studentID) {
        return database.get(studentID);
    }

    @Override
    public List<Student> selectAllStudents() {
        return new ArrayList<>(database.values());
    }

    @Override
    public int updateStudentByID(UUID studentID, Student studentUpdate) {
        database.put(studentID, studentUpdate);
        return 1;
    }

    @Override
    public int deleteStudentByID(UUID studentID) {
        database.remove(studentID);
        return 1;
    }
}
