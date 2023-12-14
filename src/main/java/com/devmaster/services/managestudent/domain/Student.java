package com.devmaster.services.managestudent.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "student")
public class Student {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column(name = "first_name")
    private  String firstName;

    @Column(name = "last_name")
    private  String lastName;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_address")
    Adress adress;

    @ManyToMany
    @JoinTable(
            name = "student_subject",
            joinColumns = @JoinColumn(name = "id_student"),
            inverseJoinColumns = @JoinColumn(name = "id_subject")
    )
    List<Subject> subjects = new ArrayList<>();

}
