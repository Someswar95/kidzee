package com.school.kidzee.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ContactUsDto {
    
    private long contactId;

    private String name;

    private String email;

    private String number;

    private String subject;

    private String message;
}
