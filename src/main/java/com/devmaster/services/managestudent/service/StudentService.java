package com.devmaster.services.managestudent.service;

import com.devmaster.services.managestudent.dto.StudentDto;
import com.devmaster.services.managestudent.mapper.StudentMapper;
import com.devmaster.services.managestudent.domain.Student;
import com.devmaster.services.managestudent.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentMapper studentMapper;

    public List<Student>getAll(){
        List<Student> students = studentRepository.findAll();
        return students;
    }

    public void save(StudentDto studentDto) {
        Student student = studentMapper.toEntity(studentDto);
        studentRepository.save(student);
    }

    public void save(List<StudentDto> studentDtos) {
    List<Student> students = studentMapper.toEntity(studentDtos);
    studentRepository.saveAll(students);
    }

    public List<StudentDto> filterByName(String name) {
        List<Student>students = studentRepository.filterByName(name);
        return  studentMapper.toDto(students);
    }

    public List<StudentDto> getStudentBySubject(String name) {
        List<Student>students = studentRepository.getStudentBySubject(name);
        return  studentMapper.toDto(students );
    }


}
