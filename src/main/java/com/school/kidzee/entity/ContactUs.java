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
@Table(name = "contactUs")
@Getter
@Setter
@NoArgsConstructor
public class ContactUs {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long contactId;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "number", nullable = false, length = 20)
    private String number;

    @Column(name = "subject", nullable = false)
    private String subject;

    @Column(name = "message", nullable = false, length = 1000)
    private String message;

    @Column(name = "messageTime")
    private String time;

}
