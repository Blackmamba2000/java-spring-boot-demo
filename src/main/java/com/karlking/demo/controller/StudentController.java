package com.karlking.demo.controller;

import java.util.List;
import java.util.UUID;

import com.karlking.demo.model.Student;
import com.karlking.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "{studentID}"
    )
    public Student getStudentByID(@PathVariable("studentID") UUID studentID){
        return studentService.getStudentID(studentID);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public void insertNewStudent(@RequestBody Student student){
        studentService.insertNewStudent(UUID.randomUUID(), student);
    }

    @RequestMapping(method = RequestMethod.PUT,
                    produces = MediaType.APPLICATION_JSON_VALUE,
                    path = "{studentID}")
    public void updateStudentByID(@PathVariable("studentID") UUID studentID, @RequestBody Student studentUpdate){
        studentService.updateStudentByID(studentID, studentUpdate);
    }

    @RequestMapping(method = RequestMethod.DELETE,
                    path = "{studentID}",
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteStudentByID(@PathVariable("studentID") UUID studentID){
        studentService.deleteStudentByID(studentID);
    }
}
