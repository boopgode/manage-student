package com.devmaster.services.managestudent.controller;

import com.devmaster.services.managestudent.dto.StudentDto;
import com.devmaster.services.managestudent.repository.StudentRepository;
import com.devmaster.services.managestudent.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/view")
public class DemoViewController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentRepository studentRepository;

//    @GetMapping("/demo/{name}")
//    public  String showDemo(@PathVariable("name") String name , Model model){
//        model.addAttribute("name",name);
//        return "demo";
//    }
//
//    @GetMapping("/demo/student")
//    public String showDemo(Model model){
//        StudentDto studentDto = new StudentDto();
//        studentDto.setFirstName("thinhj");
//        studentDto.setLastName("hoangf");
//        model.addAttribute("student",studentDto);
//        return "demo"; // return sang file html
//
//    }

    @GetMapping("/demo/students")
    public String showDemo(Model model) {
        model.addAttribute("students", studentRepository.getAllDemo());
        return "demo";

    }

    @GetMapping("/add-student")
    public String showAddStudent(Model model) {
        model.addAttribute("student", new StudentDto());

        return "layout/addstudent";
    }

    @PostMapping("/student")
    public String save(@ModelAttribute("student") StudentDto studentDto) {
        studentService.save(studentDto);
        return "redirect:/view/demo/students";
    }
}
