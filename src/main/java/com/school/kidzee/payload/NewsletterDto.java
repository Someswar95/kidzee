package com.school.kidzee.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NewsletterDto {

    private long newsId;

    private String name;

    private String email;

    private String joinDate;

}
