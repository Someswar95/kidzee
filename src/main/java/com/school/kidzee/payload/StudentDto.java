package com.school.kidzee.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StudentDto {
    
    private long id;

    private String name;

    private String email;

    private String phone;

    private String aphone;

    private String division;

    private String dob;

    private String fname;

    private String mname;

}
