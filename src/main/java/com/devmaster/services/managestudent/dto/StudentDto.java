package com.devmaster.services.managestudent.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private String name;
    private String firstName;
    private String lastName;
    private int id;
    private AddressDto  addressDto;
    private List<SubjectDto> subjectsDto;
}
