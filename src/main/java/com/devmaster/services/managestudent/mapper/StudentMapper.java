package com.devmaster.services.managestudent.mapper;

import com.devmaster.services.managestudent.dto.StudentDto;
import com.devmaster.services.managestudent.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentMapper {
    @Autowired
    private  AddressMapper addressMapper;
    @Autowired
    private  SubjectMapper subjectMapper;
    public StudentDto toDto(Student entity){
        StudentDto dto = StudentDto
                .builder()
                .name(entity.getLastName()+" "+entity.getFirstName())
                .addressDto(addressMapper.toDto(entity.getAdress()))
                .subjectsDto(subjectMapper.toDto(entity.getSubjects()))
                .build();
        return  dto;
    }
    public List<StudentDto> toDto(List<Student> entites){
        List<StudentDto> dtos = new ArrayList<>();
        entites.forEach(entity -> {
            dtos.add(toDto(entity));
        });
        return dtos;
    }
    public Student toEntity(StudentDto dto){
        Student student = Student.builder()
                .id(dto.getId())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .build();
        return  student;
    }
    public  List<Student> toEntity(List<StudentDto> dtos){
        List<Student> students = new ArrayList<>();
        dtos.forEach(dto->{
            students.add(toEntity(dto));
        });
        return  students;
    }
}
