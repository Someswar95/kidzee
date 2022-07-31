package com.school.kidzee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "student")
@NoArgsConstructor
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @Column(name = "phone", length = 15, nullable = false)
    private String phone;

    @Column(name = "alternte_phone", length = 15, nullable = false)
    private String aphone;

    @Column(name = "class", length = 20, nullable = false)
    private String division;

    @Column(name = "dob", length = 50, nullable = false)
    private String dob;

    @Column(name = "fathers_name", length = 50, nullable = false)
    private String fname;

    @Column(name = "mathers_name", length = 50, nullable = false)
    private String mname;


    
}
