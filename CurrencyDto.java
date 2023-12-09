package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class CurrencyDto {



//Comments
    private int postId;
    private int id;
    private String name;
    private String email;
    private String body;

//    Posts
    private int userId;
//    private int id;
    private String title;
//    private String body;

//    TO DO
//    private int userId;
//    private int id;
//    private String title;
    private boolean completed;


}
