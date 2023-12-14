package com.devmaster.services.managestudent.controller;


import com.devmaster.services.managestudent.domain.Student;
import com.devmaster.services.managestudent.dto.StudentDto;
import com.devmaster.services.managestudent.projection.IAvgBySubject;
import com.devmaster.services.managestudent.projection.IListStudent;
import com.devmaster.services.managestudent.projection.IMaxpointByStudent;
import com.devmaster.services.managestudent.projection.IStudentFilterClass;
import com.devmaster.services.managestudent.repository.StudentRepository;
import com.devmaster.services.managestudent.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
     StudentService studentService;
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/students")
    List<Student> getAll(){
        return studentService.getAll();
    }
    @PostMapping("/student")
    String save(@RequestBody StudentDto studentDto){
        studentService.save(studentDto);
        return "ok";
    }

    @PostMapping("/studens")
    String save (@RequestBody List<StudentDto> studentDtos){
        studentService.save(studentDtos);
        return "oke";
    }

    @GetMapping("/filter-name")
    List<StudentDto>  filterByName(@RequestParam("name")String name){
        List <StudentDto> dtos = studentService.filterByName(name);
        return dtos;
    }
    @GetMapping("/getStudentBySubject")
    List<StudentDto>  getStudentBySubject(@RequestParam("subject")String subject){
        List <StudentDto> dtos = studentService.getStudentBySubject(subject);
        return dtos;
    }
    @GetMapping("/filter-by-class")
    List<IStudentFilterClass> filterClasses(@RequestParam("nameclass")String nameclass){
        return  studentRepository.findAllByClass(nameclass);
    }

    @GetMapping("/avg-by-subject")
    List<IAvgBySubject> avgBySubject(){
        return  studentRepository.findAllBySubject();
    }
    @GetMapping("/maxpoint-by-student")
    List<IMaxpointByStudent> MaxpointByStudent(){
        return  studentRepository.findMaxpointByStudent();
    }
//    @GetMapping("/idStudent-Ascending")
//    List<IListStudent> ListStudent (){
//        return  studentRepository.();
//    }
}
