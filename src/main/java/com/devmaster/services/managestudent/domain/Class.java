package com.devmaster.services.managestudent.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "classes")
public class Class {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nameClass")
    private Integer nameClass;
    @OneToMany
    @JoinColumn(name = "id_address")
    List<Student> students = new ArrayList<>();

}